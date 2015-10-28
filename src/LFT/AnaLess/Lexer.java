/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.AnaLess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

/**
 *
 * @author Giuseppe
 */
public class Lexer {

    public static int line = 1;
    private char peek = ' ';
    Hashtable<String, Word> words = new Hashtable();

    void reserve(Word w) {
        words.put(w.lexeme, w);
    }

    public Lexer() {
        reserve(new Word(Tag.VAR, "var"));
        reserve(new Word(Tag.NOT, "not"));
        reserve(new Word(Tag.BOOLEAN, "boolean"));
        reserve(new Word(Tag.INTEGER, "integer"));
        reserve(new Word(Tag.TRUE, "true"));
        reserve(new Word(Tag.FALSE, "false"));
        reserve(new Word(Tag.PRINT, "print"));

    }

    private void readch() {
        try {
            peek = (char) System.in.read();
        } catch (IOException exc) {
            peek = (char) -1; //ERROR
        }

    }

    public Token lexical_scan() {
        while (peek == ' ' || peek == '\t' || peek == '\n' || peek == '\r') {
            if (peek == '\n') {
                line++;
            }
            readch();
        }
        switch (peek) {
            case ',':
                peek = ' ';
                return Token.comma;
            case ';':
                peek = ' ';
                return Token.semicolon;
            case '(':
                peek = ' ';
                return Token.lpar;
            case ')':
                peek = ' ';
                return Token.rpar;
            case '+':
                peek = ' ';
                return Token.plus;
            case '-':
                peek = ' ';
                return Token.minus;
            case '*':
                peek = ' ';
                return Token.div;
            case '/':
                peek = ' ';
                return Token.comma;
            case '&':
                readch();
                if (peek == '&') {
                    peek = ' ';
                    return Word.and;
                } else {
                    System.err.println("Erroneous character after & : " + peek);
                    return null;
                }
            case '|':
                readch();
                if (peek == '|') {
                    peek = ' ';
                    return Word.or;
                } else {
                    System.err.println("Erroneous character after | : " + peek);
                    return null;
                }
            case '=':
                readch();
                if (peek == '=') {
                    peek = ' ';
                    return Word.eq;
                } else {
                    System.err.println("Erroneous character after = : " + peek);
                    return null;
                }
            case '<':
                readch();
                if (peek == '=') {
                    peek = ' ';
                    return Word.le;
                } else if (peek == '>') {
                    peek = ' ';
                    return Word.ne;
                } else {
                    return Token.lt;
                }
            case '>':
                readch();
                if (peek == '=') {
                    peek = ' ';
                    return Word.ge;
                } else {
                    return Token.gt;
                }
            case ':':
                readch();
                if (peek == '=') {
                    peek = ' ';
                    return Word.assign;
                } else {
                    return Token.colon;
                }
            default:
                if (Character.isLetter(peek) || peek == '_') {
                    String s = "";
                    if(peek == '_') {
                        do  {
                           s += peek;
                           readch();
                        }while(peek == '_');
                        if(!Character.isDigit(peek) && !Character.isLetter(peek)){
                            System.err.println("Erroneous variable name or illegar string " + peek);
                            return null;
                        }
                            
                    }
                    do {
                        s += peek;
                        readch();
                    } while (Character.isDigit(peek) || Character.isLetter(peek) || peek == '_');
                    if (words.get(s) != null) {
                        return words.get(s);
                    } else {
                        words.put(s, new Word(Tag.ID, s));
                        return words.get(s);
                    }
                    //Gestione not
                } else if (Character.isDigit(peek)) {
                    Integer i = peek - 48;
                    readch();
                    while (Character.isDigit(peek)) {
                        i = i * 10 + (peek - 48);
                        readch();
                    }
                    return new Number(i);
                } else if (peek == '$') {
                    return new Token(Tag.EOF);
                } else {
                    System.err.println("Erroneous character: "
                            + peek);
                    return null;
                }
        }

    }

    public static void main(String[] args) {
        Lexer lex = new Lexer();
        Token tok;
        do {
            tok = lex.lexical_scan();
            System.out.println("Scan: " + tok);
        } while (tok.tag != Tag.EOF);
    }

//    public static void main(String[] args) {
//        Lexer lex = new Lexer();
//        String path = "...path...";
//        try {
//            BufferedReader br = new BufferedReader( new FileReader(path));
//            Token tok;
//            do {
//                tok = lex.lexical_scan(br);
//                System.out.println("Scan: " + tok);
//            } while (tok.tag != Tag.EOF);
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
