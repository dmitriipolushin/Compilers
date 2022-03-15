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

package o_project_compiler.loggers;

import java_cup.runtime.Symbol;

public class SyntaxErrorLogger extends Logger<Symbol> {

    public enum SyntaxErrorKind {
        INV_GLOBAL_VAR_DECL, INV_CLASS_INHERITANCE, INV_CLASS_FIELD_DECL, INV_FORM_PAR, INV_ASSIGNMENT, INV_IF_STMT_COND, FATAL_ERROR, INV_DECL,
    }

    public SyntaxErrorLogger() {
        super(LoggerKind.ERROR_LOGER, "Syntax error");
    }

    @Override
    protected String messageBody(Symbol loggedObject, Object... context) {
        SyntaxErrorKind syntaxErrorKind = (SyntaxErrorKind) context[0];
        String message = null;
        switch (syntaxErrorKind) {
            case INV_GLOBAL_VAR_DECL:
                message = "Invalid global variable declaration. Continuing parsing...";
                break;
            case INV_CLASS_INHERITANCE:
                message = "Invalid class inheritance declaration. Continuing parsing...";
                break;
            case INV_CLASS_FIELD_DECL:
                message = "Invalid class field declaration. Continuing parsing...";
                break;
            case INV_FORM_PAR:
                message = "Invalid formal parameter declaration. Continuing parsing...";
                break;
            case INV_ASSIGNMENT:
                message = "Invalid assignment statement. Continuing parsing...";
                break;
            case INV_IF_STMT_COND:
                message = "Invalid if-statement condition. Continuing parsing...";
                break;
            case FATAL_ERROR:
                message = "Fatal syntax error. Continuing parsing...";
                break;
            case INV_DECL:
                message = "Invalid declaration. Continuing parsing...";
                break;
        }
        return message;
    }

}
