// generated with ast extension for cup
// version 0.8
// 14/2/2022 17:13:34


package o_project_compiler.ast;

public class TimesMulop extends Mulop {

    public TimesMulop () {
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
        buffer.append("TimesMulop(\n");

        buffer.append(tab);
        buffer.append(") [TimesMulop]");
        return buffer.toString();
    }
}
