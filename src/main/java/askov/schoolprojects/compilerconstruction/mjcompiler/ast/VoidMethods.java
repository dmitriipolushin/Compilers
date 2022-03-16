// generated with ast extension for cup
// version 0.8
// 15/2/2022 17:14:38


package askov.schoolprojects.compilerconstruction.mjcompiler.ast;

public class VoidMethods extends Methods {

    public VoidMethods () {
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
        buffer.append("VoidMethods(\n");

        buffer.append(tab);
        buffer.append(") [VoidMethods]");
        return buffer.toString();
    }
}
