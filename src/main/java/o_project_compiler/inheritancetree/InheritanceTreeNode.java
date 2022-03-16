/*
 * Copyright (C) 2018  Danijel Askov
 *
 * This file is part of MicroJava Compiler.
 *
 * MicroJava Compiler is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MicroJava Compiler is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package o_project_compiler.inheritancetree;

import java.util.ArrayList;
import java.util.List;

import o_project_compiler.exceptions.WrongObjectException;
import o_project_compiler.exceptions.WrongStructureException;
import o_project_compiler.inheritancetree.visitor.InheritanceTreeVisitor;
import o_project_compiler.vmt.VMT;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

/**
 *
 * @author Danijel Askov
 */
public class InheritanceTreeNode {

    private final List<InheritanceTreeNode> children = new ArrayList<>();
    private InheritanceTreeNode parent;

    private Obj clss;
    private final VMT vmt = new VMT();

    public InheritanceTreeNode(Obj clss, InheritanceTreeNode parent) throws WrongObjectException, WrongStructureException {
        if (clss == null || clss.getType() == null) {
            throw new NullPointerException();
        }
        if (clss.getKind() != Obj.Type) {
            throw new WrongObjectException();
        }
        if (clss.getType().getKind() != Struct.Class) {
            throw new WrongStructureException();
        }
        this.parent = parent;
        if (this.parent != null) {
            this.parent.children.add(this);
        }
        this.clss = clss;
    }

    public InheritanceTreeNode(Obj clss) throws WrongObjectException, WrongStructureException {
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
        return children.size() != 0;
    }

    public int childrenNum(){return children.size();}

    public void accept(InheritanceTreeVisitor inheritanceTreeNodeVisitor) {
        inheritanceTreeNodeVisitor.visit(this);
        for (InheritanceTreeNode child : children) {
            child.accept(inheritanceTreeNodeVisitor);
        }
    }
}
