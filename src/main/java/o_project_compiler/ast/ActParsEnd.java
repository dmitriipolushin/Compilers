// generated with ast extension for cup
// version 0.8
// 14/2/2022 18:0:6


package o_project_compiler.ast;

public class ActParsEnd implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String dummy;

    public ActParsEnd (String dummy) {
        this.dummy=dummy;
    }

    public String getDummy() {
        return dummy;
    }

    public void setDummy(String dummy) {
        this.dummy=dummy;
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
        buffer.append("ActParsEnd(\n");

        buffer.append(" "+tab+dummy);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParsEnd]");
        return buffer.toString();
    }
}
