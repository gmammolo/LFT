/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.AnaSint;

import LFT.AnaLess.IllegalStringException;
import LFT.AnaLess.Lexer;
import LFT.AnaLess.Tag;
import LFT.AnaLess.Token;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parser {

    private Lexer lex;
    private BufferedReader pbr;
    private Token look;

    public Parser(Lexer l, BufferedReader br) {
        lex = l;
        pbr = br;
        move();
    }

    void move() {
        try {
            look = lex.lexical_scan(pbr);
        } catch (IllegalStringException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
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

    public void start() {
        expr();
        match(Tag.EOF);
    }

    private void expr() {
        term();
        exprp();
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
            case Tag.EOF:
                break;
            default:
                error("Syntax error in exprp "+ look.tag);
                break;
        }
    }

    private void term() {
        fact();
        termp();
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
            //epsileon? 
            case '+':
            case '-':
            case ')':
            case Tag.EOF:
                break;
            default:
                error("Syntax error in termp "+ (look.tag));
                break;
        }

    }

    private void fact() {
        switch (look.tag) {
            case Tag.NUM:
                match(look.tag);
                break;
            case '(':
                match('(');
                expr();
                match(')');
                break;
            default:
                expr();
                break;               
        }
    }

    public static void main(String[] args) {
        Lexer lex = new Lexer();
        String path = new File("src/LFT/AnaSint/source.txt").getAbsolutePath();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            Parser parser = new Parser(lex, br);
            parser.start();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
