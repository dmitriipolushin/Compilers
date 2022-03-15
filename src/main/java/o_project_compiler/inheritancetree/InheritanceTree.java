

package o_project_compiler.inheritancetree;

import java.util.HashMap;
import java.util.Map;

import o_project_compiler.exceptions.WrongObjKindException;
import o_project_compiler.exceptions.WrongStructKindException;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;


public class InheritanceTree {

    public static final InheritanceTreeNode ROOT_NODE;

    static {
        InheritanceTreeNode root = null;
        try {
            root = new InheritanceTreeNode(new Obj(Obj.Type, "$RootClassNode", new Struct(Struct.Class)), null);
        } catch (WrongObjKindException | WrongStructKindException e) {
            e.printStackTrace();
        }
        ROOT_NODE = root;
    }

    private static final Map<Obj, InheritanceTreeNode> ObjNodeMap = new HashMap<>();

    public static boolean addNodeForClass(Obj clss) throws WrongObjKindException, WrongStructKindException {
        if (ObjNodeMap.containsKey(clss)) {
            return false;
        }
        else {
            ObjNodeMap.put(clss, new InheritanceTreeNode(clss));
            return true;
        }
    }

    public static boolean addNodeForClass(Obj childClass, Obj parentClass)
            throws WrongObjKindException, WrongStructKindException {
        if (ObjNodeMap.containsKey(childClass) || !ObjNodeMap.containsKey(parentClass)) {
            return false;
        }
        else {
            ObjNodeMap.put(childClass, new InheritanceTreeNode(childClass, ObjNodeMap.get(parentClass)));
            return true;
        }
    }

    public static InheritanceTreeNode getNode(Obj clss) throws WrongObjKindException, WrongStructKindException {
        if (clss == null) {
            throw new NullPointerException();
        }
        if (clss.getKind() != Obj.Type) {
            throw new WrongObjKindException();
        }
        if (clss.getType().getKind() != Struct.Class) {
            throw new WrongStructKindException();
        }
        return ObjNodeMap.get(clss);
    }

}
