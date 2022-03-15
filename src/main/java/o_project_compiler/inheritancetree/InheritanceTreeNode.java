

package o_project_compiler.inheritancetree;

import java.util.ArrayList;
import java.util.List;

import o_project_compiler.exceptions.WrongObjKindException;
import o_project_compiler.exceptions.WrongStructKindException;
import o_project_compiler.inheritancetree.visitor.LeafNodeVisitor;
import o_project_compiler.vmt.VMT;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;


public class InheritanceTreeNode {

    private final List<InheritanceTreeNode> children = new ArrayList<>();
    private InheritanceTreeNode parent;

    private Obj clss;
    private final VMT vmt = new VMT();

    public InheritanceTreeNode(Obj clss, InheritanceTreeNode parent) throws WrongObjKindException, WrongStructKindException {
        if (clss == null || clss.getType() == null) {
            throw new NullPointerException();
        }
        if (clss.getKind() != Obj.Type) {
            throw new WrongObjKindException();
        }
        if (clss.getType().getKind() != Struct.Class) {
            throw new WrongStructKindException();
        }
        this.parent = parent;
        if (this.parent != null) {
            this.parent.children.add(this);
        }
        this.clss = clss;
    }

    public InheritanceTreeNode(Obj clss) throws WrongObjKindException, WrongStructKindException {
        this(clss, InheritanceTree.ROOT_NODE);
    }

    public Obj getClss() {

        return clss;
    }

    public VMT getVMT() {

        return vmt;
    }

    public InheritanceTreeNode getParent() {

        return parent;
    }

    public List<InheritanceTreeNode> getChildren() {

        return children;
    }

    public boolean hasChildren() {
        if (children.size() != 0) {
            return true;
        }
        return false;
    }

    public void accept(LeafNodeVisitor inheritanceTreeNodeVisitor) {
        inheritanceTreeNodeVisitor.visit(this);
        for (InheritanceTreeNode child : children) {
            child.accept(inheritanceTreeNodeVisitor);
        }
    }
}
