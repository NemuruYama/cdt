/*******************************************************************************
* Copyright (c) 2006, 2008 IBM Corporation and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl_v10.html
*
* Contributors:
*     IBM Corporation - initial API and implementation
*********************************************************************************/

// This file was generated by LPG

package org.eclipse.cdt.internal.core.dom.lrparser.cpp;

public interface CPPNoCastExpressionParsersym {
    public final static int
      TK_asm = 64,
      TK_auto = 49,
      TK_bool = 13,
      TK_break = 76,
      TK_case = 77,
      TK_catch = 116,
      TK_char = 14,
      TK_class = 58,
      TK_const = 47,
      TK_const_cast = 26,
      TK_continue = 78,
      TK_default = 79,
      TK_delete = 40,
      TK_do = 80,
      TK_double = 15,
      TK_dynamic_cast = 27,
      TK_else = 120,
      TK_enum = 65,
      TK_explicit = 50,
      TK_export = 73,
      TK_extern = 43,
      TK_false = 28,
      TK_float = 16,
      TK_for = 81,
      TK_friend = 51,
      TK_goto = 82,
      TK_if = 83,
      TK_inline = 52,
      TK_int = 17,
      TK_long = 18,
      TK_mutable = 53,
      TK_namespace = 62,
      TK_new = 41,
      TK_operator = 6,
      TK_private = 117,
      TK_protected = 118,
      TK_public = 119,
      TK_register = 54,
      TK_reinterpret_cast = 29,
      TK_return = 84,
      TK_short = 19,
      TK_signed = 20,
      TK_sizeof = 30,
      TK_static = 55,
      TK_static_cast = 31,
      TK_struct = 66,
      TK_switch = 85,
      TK_template = 45,
      TK_this = 32,
      TK_throw = 39,
      TK_try = 74,
      TK_true = 33,
      TK_typedef = 56,
      TK_typeid = 34,
      TK_typename = 10,
      TK_union = 67,
      TK_unsigned = 21,
      TK_using = 60,
      TK_virtual = 46,
      TK_void = 22,
      TK_volatile = 48,
      TK_wchar_t = 23,
      TK_while = 75,
      TK_integer = 35,
      TK_floating = 36,
      TK_charconst = 37,
      TK_stringlit = 24,
      TK_identifier = 1,
      TK_Completion = 121,
      TK_EndOfCompletion = 122,
      TK_Invalid = 123,
      TK_LeftBracket = 59,
      TK_LeftParen = 2,
      TK_LeftBrace = 57,
      TK_Dot = 115,
      TK_DotStar = 94,
      TK_Arrow = 101,
      TK_ArrowStar = 88,
      TK_PlusPlus = 11,
      TK_MinusMinus = 12,
      TK_And = 7,
      TK_Star = 5,
      TK_Plus = 8,
      TK_Minus = 9,
      TK_Tilde = 4,
      TK_Bang = 25,
      TK_Slash = 89,
      TK_Percent = 90,
      TK_RightShift = 86,
      TK_LeftShift = 87,
      TK_LT = 61,
      TK_GT = 63,
      TK_LE = 91,
      TK_GE = 92,
      TK_EQ = 95,
      TK_NE = 96,
      TK_Caret = 97,
      TK_Or = 98,
      TK_AndAnd = 99,
      TK_OrOr = 100,
      TK_Question = 112,
      TK_Colon = 70,
      TK_ColonColon = 3,
      TK_DotDotDot = 93,
      TK_Assign = 69,
      TK_StarAssign = 102,
      TK_SlashAssign = 103,
      TK_PercentAssign = 104,
      TK_PlusAssign = 105,
      TK_MinusAssign = 106,
      TK_RightShiftAssign = 107,
      TK_LeftShiftAssign = 108,
      TK_AndAssign = 109,
      TK_CaretAssign = 110,
      TK_OrAssign = 111,
      TK_Comma = 68,
      TK_zero = 38,
      TK_RightBracket = 113,
      TK_RightParen = 72,
      TK_RightBrace = 71,
      TK_SemiColon = 42,
      TK_ERROR_TOKEN = 44,
      TK_EOF_TOKEN = 114;

      public final static String orderedTerminalSymbols[] = {
                 "",
                 "identifier",
                 "LeftParen",
                 "ColonColon",
                 "Tilde",
                 "Star",
                 "operator",
                 "And",
                 "Plus",
                 "Minus",
                 "typename",
                 "PlusPlus",
                 "MinusMinus",
                 "bool",
                 "char",
                 "double",
                 "float",
                 "int",
                 "long",
                 "short",
                 "signed",
                 "unsigned",
                 "void",
                 "wchar_t",
                 "stringlit",
                 "Bang",
                 "const_cast",
                 "dynamic_cast",
                 "false",
                 "reinterpret_cast",
                 "sizeof",
                 "static_cast",
                 "this",
                 "true",
                 "typeid",
                 "integer",
                 "floating",
                 "charconst",
                 "zero",
                 "throw",
                 "delete",
                 "new",
                 "SemiColon",
                 "extern",
                 "ERROR_TOKEN",
                 "template",
                 "virtual",
                 "const",
                 "volatile",
                 "auto",
                 "explicit",
                 "friend",
                 "inline",
                 "mutable",
                 "register",
                 "static",
                 "typedef",
                 "LeftBrace",
                 "class",
                 "LeftBracket",
                 "using",
                 "LT",
                 "namespace",
                 "GT",
                 "asm",
                 "enum",
                 "struct",
                 "union",
                 "Comma",
                 "Assign",
                 "Colon",
                 "RightBrace",
                 "RightParen",
                 "export",
                 "try",
                 "while",
                 "break",
                 "case",
                 "continue",
                 "default",
                 "do",
                 "for",
                 "goto",
                 "if",
                 "return",
                 "switch",
                 "RightShift",
                 "LeftShift",
                 "ArrowStar",
                 "Slash",
                 "Percent",
                 "LE",
                 "GE",
                 "DotDotDot",
                 "DotStar",
                 "EQ",
                 "NE",
                 "Caret",
                 "Or",
                 "AndAnd",
                 "OrOr",
                 "Arrow",
                 "StarAssign",
                 "SlashAssign",
                 "PercentAssign",
                 "PlusAssign",
                 "MinusAssign",
                 "RightShiftAssign",
                 "LeftShiftAssign",
                 "AndAssign",
                 "CaretAssign",
                 "OrAssign",
                 "Question",
                 "RightBracket",
                 "EOF_TOKEN",
                 "Dot",
                 "catch",
                 "private",
                 "protected",
                 "public",
                 "else",
                 "Completion",
                 "EndOfCompletion",
                 "Invalid"
             };

    public final static boolean isValidForParser = true;
}
