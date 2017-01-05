/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.AnalisiSintattica;

import LFT.AnalisiLessicale.IllegalStringException;
import LFT.AnalisiLessicale.Lexer;
import LFT.AnalisiLessicale.Tag;
import LFT.AnalisiLessicale.Token;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser3_3 {

    private Lexer lex;
    private BufferedReader pbr;
    private Token look;

    public Parser3_3(Lexer l, BufferedReader br) {
        lex = l;
        pbr = br;
        move();
    }

    void move() {
        try {
            look = lex.lexical_scan(pbr);
        } catch (IllegalStringException ex) {
            Logger.getLogger(Parser3_3.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.err.println("token = " + look);
    }

    void error(String s) {
        throw new Error("near line " + lex.line + ": " + s);
    }

    void match(int t) {
        if (look.tag == t) {
            if (look.tag != Tag.EOF) {
                move();
            }
        } else {
            error("syntax error");
        }
    }

    public void prog() {
        if (look.tag == Tag.PRINT || look.tag == Tag.READ || look.tag == Tag.IF || look.tag == Tag.WHILE || look.tag == Tag.ID || look.tag == (int)'{') {
            statlist();
            match(Tag.EOF);
        } else {
            error("Syntax error in prog " + look.tag);
        }
    }

    private void stat() {
        switch (look.tag) {
            case Tag.PRINT:
                match(Tag.PRINT);
                match('(');
                expr();
                match(')');
                break;
            case Tag.READ:
                match(Tag.READ);
                match('(');
                match(Tag.ID);
                match(')');
                break;
            case Tag.IF:
                match(Tag.IF);
                match('(');
                bexpr();
                match(')');
                stat();
                stat_p();
                break;
            case Tag.WHILE:
                match(Tag.WHILE);
                match('(');
                bexpr();
                match(')');
                stat();
                break;
            case (int) '{':
                match('{');
                statlist();
                match('}');
                break;
            case Tag.ID:
                match(Tag.ID);
                match(Tag.ASSIGN);
                expr();
                break;
            case Tag.EOF: //TODO: Aggiunto Manualmente: verificare 
                break;
            default:
                error("Syntax error in stat " + look.tag);
                break;
        }
    }

    private void stat_p() {
        switch (look.tag) {
            case Tag.ELSE:
                match(Tag.ELSE);
                stat();
                break;
            case (int) ';':
            case (int)'}':
            case Tag.EOF:
                break;
            default:
                error("Syntax error in stat_p " + look.tag);
                break;
        }
    }

    private void statlist() {
        switch (look.tag) {
            case Tag.PRINT:
            case Tag.READ:
            case Tag.IF:
            case Tag.WHILE:
            case (int) '{':
            case Tag.ID:
                stat();
                statlist_p();
                break;
            default:
                error("Syntax error in statlist " + look.tag);
                break;
        }
    }

    private void statlist_p() {
        switch (look.tag) {
            case ';':
                match(';');
                stat();
                statlist_p();
                break;
            case (int) '}':
            case Tag.EOF:
                break;
            default:
                error("Syntax error in statlist_p " + look.tag);
                break;
        }
    }

    private void bexpr() {
        if (look.tag == Tag.ID || look.tag == Tag.NUM || look.tag == (int) '(') {
            expr();
            match(Tag.RELOP);
            expr();
        } else {
            error("Syntax error in bexpr " + look.tag);
        }
    }

    private void expr() {
        if (look.tag == Tag.ID || look.tag == Tag.NUM || look.tag == (int) '(') {
            term();
            exprp();
        } else {
            error("Syntax error in expr " + look.tag);
        }
    }

    private void exprp() {
        switch (look.tag) {
            case '+':
                match('+');
                term();
                exprp();
                break;
            case '-':
                match('-');
                term();
                exprp();
                break;
            case ')':
            case ';':
            case '}':
            case Tag.ELSE:
            case Tag.RELOP:
            case Tag.EOF:
                break;
            default:
                error("Syntax error in exprp " + look.tag);
                break;
        }
    }

    private void term() {
        if (look.tag == (int) '(' || look.tag == Tag.NUM || look.tag == Tag.ID) {
            fact();
            termp();
        } else {
            error("Syntax error in term " + look.tag);
        }
    }

    private void termp() {
        switch (look.tag) {
            case '*':
                match('*');
                fact();
                termp();
                break;
            case '/':
                match('/');
                fact();
                termp();
                break;
            case '+':
            case '-':
            case ')':
            case ';': 
            case '}': 
            case Tag.ELSE:
            case Tag.RELOP:
            case Tag.EOF:
                break;
            default:
                error("Syntax error in termp " + (look.tag));
                break;
        }

    }

    private void fact() {
        switch (look.tag) {
            case Tag.NUM:
            case Tag.ID:
                match(look.tag);
                break;
            case '(':
                match('(');
                expr();
                match(')');
                break;
            default:
                error("Syntax error in fact " + (look.tag));
                break;
        }
    }

    public static void main(String[] args) {
        Lexer lex = new Lexer();
        String path = new File("src/LFT/AnalisiSintattica/source3.txt").getAbsolutePath();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            Parser3_3 parser = new Parser3_3(lex, br);
            parser.prog();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
