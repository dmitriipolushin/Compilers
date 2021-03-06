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

import o_project_compiler.inheritancetree.InheritanceTreeNode;
import o_project_compiler.inheritancetree.visitor.InheritanceTreeVisitor;

/**
 *
 * @author Danijel Askov
 */
public class VMTStartAddressGenerator implements InheritanceTreeVisitor {

    private final int firstVMTStartAddress;
    private int currentVMTStartAddress;

    public VMTStartAddressGenerator(int firstVMTStartAddress) {
        this.firstVMTStartAddress = currentVMTStartAddress = firstVMTStartAddress;
    }

    @Override
    public void visit(InheritanceTreeNode node) {
        VMT vmt = node.getVMT();
        vmt.setStartAddress(currentVMTStartAddress);
        node.getClss().setAdr(currentVMTStartAddress);
        currentVMTStartAddress += vmt.getSize();
    }

    public int getTotalVMTSize() {
        return currentVMTStartAddress - firstVMTStartAddress;
    }

}
