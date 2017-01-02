/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.OldAssembler;

import LFT.AnalisiLessicale.IllegalStringException;
import LFT.AnalisiLessicale.Number;
import LFT.AnalisiLessicale.Lexer;
import LFT.AnalisiLessicale.Tag;
import LFT.AnalisiLessicale.Token;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Traduttore {

    private Lexer lex;
    private Token look;
    private BufferedReader pbr;
    private CodeGenerator code;

    public Traduttore(Lexer l, BufferedReader br) {
        lex = l;
        code= new CodeGenerator();
        pbr = br;
        move();
    }

    void move() {
        try {
            look = lex.lexical_scan(pbr);
        } catch (IllegalStringException ex) {
            Logger.getLogger(Traduttore.class.getName()).log(Level.SEVERE, null, ex);
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
        Type expr_val;
        expr_val = prog();
        match(Tag.EOF);
        System.out.println(expr_val);
    }

    public Type prog(){
        Type orE_type;
        match(Tag.PRINT);
        orE_type = orE();
        match(Tag.EOF);
        
       return orE_type;
    }
    
    private Type relE_p( /* ... eventuali parametri ... */) {
        Type addE_type;
        switch (look.tag) {
            case Tag.EQ:
                match(Tag.EQ);
                addE_type = addE();
                int ltrue = code.newLabel();
                int lnext = code.newLabel();
                code.emit(OpCode.if_icmpeq, ltrue);
                code.emit(OpCode.ldc, 0);
                code.emit(OpCode.GOto, lnext);
                code.emitLabel(ltrue);
                code.emit(OpCode.ldc, 1);
                code.emitLabel(lnext);
// ... type checking ...
                break;
            default: 
                addE_type = Type.NULL;
                break;
// ... altri casi ...
        }
        return addE_type;
    }
// ...

    private Type addE_p( /* ... eventuali parametri ... */) {
        Type multE_type;
        switch (look.tag) {
            case '+':
                match('+');
                multE_type = multE();
                code.emit(OpCode.iadd);
                break;
            case '-':
                match('-');
                multE_type = multE();
                code.emit(OpCode.iadd);
                
                break;
            default:
                multE_type = Type.NULL;
        }
        if(multE_type != Type.INTEGER)
            System.out.println("Type non valido");
        return multE_type;
    }

    public static void main(String[] args) {
        Lexer lex = new Lexer();
        String path = new File("src/LFT/Validatore/source.txt").getAbsolutePath();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            Traduttore parser = new Traduttore(lex, br);
            parser.start();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Type multE() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Type addE() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Type orE() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
