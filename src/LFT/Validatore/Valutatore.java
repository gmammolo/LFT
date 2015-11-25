/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.Validatore;

import LFT.AnaLess.Number;
import LFT.AnaLess.Lexer;
import LFT.AnaLess.Tag;
import LFT.AnaLess.Token;
import java.io.*;

public class Valutatore {

    private Lexer lex;
    private Token look;
    private BufferedReader pbr;

    public Valutatore(Lexer l, BufferedReader br) {
        lex = l;
        pbr = br;
        move();
    }

    void move() {
        look = lex.lexical_scan(pbr);
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
        int expr_val = 0;
        expr_val = expr();
        match(Tag.EOF);
        System.out.println(expr_val);
    }
////la procedura
//    start puo
//    ‘
// essere estesa //
//    come in
//    Esercizio
//    3.1
// (
//opzionale
//
//    )

    private int expr() {
        int term_val, exprp_val;
        term_val = term();
        exprp_val = exprp(term_val);
        return exprp_val;
    }
////
//    la procedura
//    expr puo
//    ‘
// essere estesa //
//    come in
//    Esercizio
//    3.1
// (
//opzionale
//
//    )

    private int exprp(int exprp_i) {
        int term_val, exprp_val = 0;
        switch (look.tag) {
            case '+':
                match('+');
                term_val = term();
                exprp_val = exprp(exprp_i + term_val);
                break;
            case '-':
                match('-');
                term_val = term();
                exprp_val = exprp(exprp_i - term_val);
                break;
            case ')':
            case Tag.EOF:
                exprp_val= exprp_i;
                break;
            default:
                error("Syntax error in exprp "+ look.tag);
                break;
        }
        return exprp_val;
    }

    private int term() {
        return termp(fact());
    }

    private int termp(int termp_i) {
        int fact_val, termp_val = 0;
        switch (look.tag) {
            case '*':
                match('*');
                fact_val = fact();
                termp_val = termp(termp_i * fact_val);
                break;
            case '/':
                match('/');
                fact_val = fact();
                termp_val =termp(termp_i / fact_val);
                break;
            case '+':
            case '-':
            case ')':
            case Tag.EOF:
                termp_val = termp_i;
                break;
            default:
                error("Syntax error in termp "+ (look.tag));
                break;
        }
        return termp_val;
    }

    private int fact() {
        int fact_val = 0;
        switch (look.tag) {
            case Tag.NUM:
                fact_val = ((Number)look).value;
                break;
            case '(':
                match('(');
                fact_val= expr();
                match(')');
                break;
            default:
                fact_val = expr();
                break;  
        }
        return fact_val;
    }
    
    public static void main(String[] args) {
        Lexer lex = new Lexer();
        String path = new File("src/LFT/AnaSint/source.txt").getAbsolutePath();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            Valutatore parser = new Valutatore(lex, br);
            parser.start();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
