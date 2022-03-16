// generated with ast extension for cup
// version 0.8
// 16/2/2022 17:28:34


package o_project_compiler.ast;

public class MultipleFieldFieldList extends FieldList {

    private Field Field;
    private FieldList FieldList;

    public MultipleFieldFieldList (Field Field, FieldList FieldList) {
        this.Field=Field;
        if(Field!=null) Field.setParent(this);
        this.FieldList=FieldList;
        if(FieldList!=null) FieldList.setParent(this);
    }

    public Field getField() {
        return Field;
    }

    public void setField(Field Field) {
        this.Field=Field;
    }

    public FieldList getFieldList() {
        return FieldList;
    }

    public void setFieldList(FieldList FieldList) {
        this.FieldList=FieldList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Field!=null) Field.accept(visitor);
        if(FieldList!=null) FieldList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Field!=null) Field.traverseTopDown(visitor);
        if(FieldList!=null) FieldList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Field!=null) Field.traverseBottomUp(visitor);
        if(FieldList!=null) FieldList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleFieldFieldList(\n");

        if(Field!=null)
            buffer.append(Field.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FieldList!=null)
            buffer.append(FieldList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleFieldFieldList]");
        return buffer.toString();
    }
}
