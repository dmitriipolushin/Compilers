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

package o_project_compiler.vmt;

import o_project_compiler.exceptions.WrongObjKindException;
import o_project_compiler.inheritancetree.InheritanceTree;
import o_project_compiler.inheritancetree.InheritanceTreeNode;
import o_project_compiler.inheritancetree.visitor.InheritanceTreeVisitor;
import o_project_compiler.util.MJUtils;
import rs.etf.pp1.symboltable.concepts.Obj;

/**
 *
 * @author Danijel Askov
 */
public class VMTCreator implements InheritanceTreeVisitor {

    private void updateVMTs(InheritanceTreeNode node, Obj overriddenMethod) {
        try {
            node.getVMT().add(overriddenMethod);
        } catch (WrongObjKindException e) {
            e.printStackTrace();
        }
        for (InheritanceTreeNode child : node.getChildren()) {
            boolean childVisited = false;
            for (Obj member : child.getClss().getType().getMembers()) {
                if (member.getKind() == Obj.Meth) {
                    try {
                        if (MJUtils.haveSameSignatures(member, overriddenMethod)) {
                            updateVMTs(child, member);
                            childVisited = true;
                            break;
                        }
                    } catch (WrongObjKindException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (!childVisited) {
                updateVMTs(child, overriddenMethod);
            }
        }
    }

    @Override
    public void visit(InheritanceTreeNode node) {
        if (!node.equals(InheritanceTree.ROOT_NODE)) {
            for (Obj member : node.getClss().getType().getMembers()) {
                if (member.getKind() == Obj.Meth) {
                    InheritanceTreeNode parent = node.getParent();
                    while (!parent.equals(InheritanceTree.ROOT_NODE)) {
                        boolean overridenMethodFound = false;
                        for (Obj parentMember : parent.getClss().getType().getMembers()) {
                            if (parentMember.getKind() == Obj.Meth) {
                                try {
                                    if (MJUtils.haveSameSignatures(member, parentMember)) {
                                        if (MJUtils.returnTypesAssignmentCompatible(member, parentMember)) {
                                            overridenMethodFound = true;
                                            updateVMTs(parent, parentMember);
                                            break;
                                        }
                                    }
                                } catch (WrongObjKindException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        if (overridenMethodFound) {
                            break;
                        }
                        parent = parent.getParent();
                    }
                }
            }
        }
    }

}
