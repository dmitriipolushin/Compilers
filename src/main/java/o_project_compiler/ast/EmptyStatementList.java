// generated with ast extension for cup
// version 0.8
// 14/2/2022 18:0:6


package o_project_compiler.ast;

public class EmptyStatementList extends StatementList {

    public EmptyStatementList () {
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
        buffer.append("EmptyStatementList(\n");

        buffer.append(tab);
        buffer.append(") [EmptyStatementList]");
        return buffer.toString();
    }
}