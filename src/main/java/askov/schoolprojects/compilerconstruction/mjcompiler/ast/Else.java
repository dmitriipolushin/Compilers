// generated with ast extension for cup
// version 0.8
// 14/2/2022 18:0:6


package askov.schoolprojects.compilerconstruction.mjcompiler.ast;

public class Else implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public Else () {
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
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
        buffer.append("Else(\n");

        buffer.append(tab);
        buffer.append(") [Else]");
        return buffer.toString();
    }
}
