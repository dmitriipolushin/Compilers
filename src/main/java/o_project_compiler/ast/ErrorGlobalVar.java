// generated with ast extension for cup
// version 0.8
// 16/2/2022 17:28:34


package o_project_compiler.ast;

public class ErrorGlobalVar extends ErrorProneGlobalVar {

    public ErrorGlobalVar () {
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
        buffer.append("ErrorGlobalVar(\n");

        buffer.append(tab);
        buffer.append(") [ErrorGlobalVar]");
        return buffer.toString();
    }
}
