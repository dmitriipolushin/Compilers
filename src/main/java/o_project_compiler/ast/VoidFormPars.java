// generated with ast extension for cup
// version 0.8
// 16/2/2022 22:28:35


package o_project_compiler.ast;

public class VoidFormPars extends FormPars {

    public VoidFormPars () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VoidFormPars(\n");

        buffer.append(tab);
        buffer.append(") [VoidFormPars]");
        return buffer.toString();
    }
}
