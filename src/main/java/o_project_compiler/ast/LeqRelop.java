// generated with ast extension for cup
// version 0.8
// 9/0/2020 16:10:51


package o_project_compiler.ast;

public class LeqRelop extends Relop {

    public LeqRelop () {
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
        buffer.append("LeqRelop(\n");

        buffer.append(tab);
        buffer.append(") [LeqRelop]");
        return buffer.toString();
    }
}
