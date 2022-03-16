package askov.schoolprojects.compilerconstruction.mjcompiler;

import java_cup.runtime.Symbol;
import askov.schoolprojects.compilerconstruction.mjcompiler.loggers.LexicalErrorMJLogger;

%%

%class MJLexer
%cup
%line
%column

%{
	LexicalErrorMJLogger lexicalErrorMJLogger = new LexicalErrorMJLogger();

	private Symbol newSymbol(int type) {
		return new Symbol(type, yyline + 1, yycolumn + 1);
	}

	private Symbol newSymbol(int type, Object value) {
		return new Symbol(type, yyline + 1, yycolumn + 1, value);
	}
%}

%eofval{
	return newSymbol(sym.EOF);
%eofval}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
Whitespace     = {LineTerminator}|[\t\f\b ]

SingleLineComment = "//"{InputCharacter}*{LineTerminator}?
Comment = {SingleLineComment}

DecIntegerLiteral = [0-9]+
PrintableCharLiteral = "'"[ -~]"'"
BooleanLiteral = "true"|"false"
Identifier = [a-zA-Z][a-zA-Z0-9_]*

%%

<YYINITIAL> {
	{Whitespace}           { /* ignore */ }
	
	"program"              { return newSymbol(sym.PROGRAM); }
	"break"                { return newSymbol(sym.BREAK); }
	"class"                { return newSymbol(sym.CLASS); }
	"else"                 { return newSymbol(sym.ELSE); }
	"if"                   { return newSymbol(sym.IF); }
	"new"                  { return newSymbol(sym.NEW); }
	"print"                { return newSymbol(sym.PRINT); }
	"read"                 { return newSymbol(sym.READ); }
	"return"               { return newSymbol(sym.RETURN); }
	"void"                 { return newSymbol(sym.VOID); }
	"do"                   { return newSymbol(sym.DO); }
	"while"                { return newSymbol(sym.WHILE); }
	"extends"              { return newSymbol(sym.EXTENDS);}


    "this"               {return newSymbol(sym.THIS); }

    // static
    // this


//	"minus"                    { return newSymbol(sym.MINUS); }
//	"times"                    { return newSymbol(sym.TIMES); }
//	"div"                    { return newSymbol(sym.DIV); }
//	"%"                    { return newSymbol(sym.MOD); }
//	"++"                   { return newSymbol(sym.INCR); }
//	"--"                   { return newSymbol(sym.DECR); }
//	"=="                   { return newSymbol(sym.EQ); }
//	"!="                   { return newSymbol(sym.NEQ); }
//	"<"                    { return newSymbol(sym.LT); }
//	"<="                   { return newSymbol(sym.LEQ); }
//	">"                    { return newSymbol(sym.GT); }
//	">="                   { return newSymbol(sym.GEQ); }
//	"&&"                   { return newSymbol(sym.AND); }
//	"or"                   { return newSymbol(sym.OR); }

	"="                    { return newSymbol(sym.ASSIGN); }
	
	";"                    { return newSymbol(sym.SEMI); }
	","                    { return newSymbol(sym.COMMA); }
	"."                    { return newSymbol(sym.DOT); }
	
	"("                    { return newSymbol(sym.LPAREN); } // Parentheses (Oble (male) zagrade).
	")"                    { return newSymbol(sym.RPAREN); }
	"["                    { return newSymbol(sym.LBRACKET); } // (Square) Brackets (Uglaste (srednje) zagrade).
	"]"                    { return newSymbol(sym.RBRACKET); }
	"{"                    { return newSymbol(sym.LBRACE); } // (Curly) Braces (Vitičaste (velike) zagrade).
	"}"                    { return newSymbol(sym.RBRACE); }
	
	{Comment}              { /* ignore */ }
	
	{DecIntegerLiteral}    { return newSymbol(sym.INT, new Integer(yytext())); }
	{BooleanLiteral}       { return newSymbol(sym.BOOL, Boolean.valueOf(yytext())); }  
	{PrintableCharLiteral} { return newSymbol(sym.CHAR, new Character(yytext().charAt(1))); }
	
	{Identifier}           { return newSymbol(sym.IDENT, yytext()); }
	
	[^]                    { lexicalErrorMJLogger.log(yytext(), yyline + 1, yycolumn + 1); return newSymbol(sym.ERROR); }
}