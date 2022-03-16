// generated with ast extension for cup
// version 0.8
// 15/2/2022 17:14:38


package askov.schoolprojects.compilerconstruction.mjcompiler.ast;

public class DelimitedFactor extends Factor {

    private Expr Expr;
    private String R2;

    public DelimitedFactor (Expr Expr, String R2) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.R2=R2;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public String getR2() {
        return R2;
    }

    public void setR2(String R2) {
        this.R2=R2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DelimitedFactor(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+R2);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DelimitedFactor]");
        return buffer.toString();
    }
}
