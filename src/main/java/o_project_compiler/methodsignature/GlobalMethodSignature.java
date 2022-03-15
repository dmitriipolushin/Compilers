package o_project_compiler.methodsignature;

import o_project_compiler.exceptions.WrongObjKindException;
import rs.etf.pp1.symboltable.concepts.Obj;

public class GlobalMethodSignature extends MethodSignature {

    public GlobalMethodSignature(Obj method) throws WrongObjKindException {
        super(method, false);
    }

    public GlobalMethodSignature(String name) {
        super(name);
    }

}
