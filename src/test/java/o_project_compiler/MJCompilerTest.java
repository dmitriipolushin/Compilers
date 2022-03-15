

package o_project_compiler;

import org.junit.Test;
import rs.etf.pp1.mj.runtime.Run;

import java.io.*;


public class MJCompilerTest {

    private static final String PATH_PREFIX = "src" + File.separator + "test" + File.separator +"resources" + File.separator;

    @Test
    public void simpleCalculatorTest() throws Exception {
        System.out.println("\n\n1) Running MicroJava Compiler. Input file: \"" + PATH_PREFIX + "test.mj\"...\n\n");
        // Firstly, we run MicroJava Compiler
        MJCompiler.main(new String[]{PATH_PREFIX + "test.mj", PATH_PREFIX + "test.obj"});

        System.out.println("\n\n2) Running MicroJava Virtual Machine. Input file: \"" + PATH_PREFIX + "test.obj\"...\n\n");
        final InputStream originalInputStream = System.in;
        final FileInputStream fileInputStream = new FileInputStream(new File(PATH_PREFIX + "input_stream.txt"));
        System.setIn(fileInputStream);
        // Secondly, we start MicroJava Virtual Machine
        Run.main(new String[]{PATH_PREFIX + "test.obj"});
        System.setIn(originalInputStream);
    }

}
