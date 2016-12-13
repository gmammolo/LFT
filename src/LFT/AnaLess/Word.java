/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.AnaLess;

/**
 *
 * @author Giuseppe
 */
public class Word extends Token {

    public String lexeme = "";

    public Word(int tag, String s) {
        super(tag);
        lexeme = s;
    }

    public String toString() {
        return "<" + tag + ", " + lexeme + ">";
    }

    public static final Word 
            and = new Word(Tag.AND, "&&"),
            or = new Word(Tag.OR, "||"),
            eq = new Word(Tag.EQ, "=="),
            le = new Word(Tag.LE, "<="),
            ne = new Word(Tag.NE, "<>"),
            ge = new Word(Tag.GE, ">="),
            not = new Word(Tag.NOT, "not"),
            assign = new Word(Tag.ASSIGN, ":="),
            If = new Word(Tag.IF, "if"),
            Then = new Word(Tag.THEN, "then"),
            Else = new Word(Tag.ELSE, "else"),
            While = new Word(Tag.WHILE, "while"),
            Do = new Word(Tag.DO, "do"),
            Begin = new Word(Tag.BEGIN, "begin"),
            End = new Word(Tag.END, "end");
}
