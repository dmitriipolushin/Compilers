// generated with ast extension for cup
// version 0.8
// 14/2/2022 18:0:6


package askov.schoolprojects.compilerconstruction.mjcompiler.ast;

public class DivMulop extends Mulop {

    public DivMulop () {
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
        buffer.append("DivMulop(\n");

        buffer.append(tab);
        buffer.append(") [DivMulop]");
        return buffer.toString();
    }
}
