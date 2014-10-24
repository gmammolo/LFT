/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.Lab_24_10_2014.Es2_5;

import LFT.DFA.DFA;
import static LFT.Lab_17_10_2014.lft_es5.LFT_ES5B.GenerateDFA;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author giuseppe
 */
public class Es2_5 {
    private static DFA dfa;
    
        
    public static void GenerateDFA()
    {
        dfa = new DFA(4);
        dfa.setMove(0, '1', 0);
        dfa.setMove(0, '0', 1);
        dfa.setMove(1, '1', 0);
        dfa.setMove(1, '0', 2);
        dfa.setMove(2, '1', 0);
        dfa.setMove(2, '0', 3);
        dfa.setMove(3, '1', 3);
        dfa.setMove(3, '0', 3);
        dfa.setMove(3, '2', 3);
        dfa.setMove(3, '3', 3);
        dfa.setMove(3, 'a', 3);
        dfa.setMove(3, 'b', 3);
        dfa.setMove(3, 'd', 3);
        dfa.addFinalState(3);
    }
    
    public static void toDot(String s) {
        
        GenerateDFA();
//        dfa.toDOT(s);
        dfa.toJava(s);
    }

    public static void main(String[] args) throws Exception {
//        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//        BufferedReader reader = new BufferedReader(inputStreamReader);
//        System.out.println("Type the line:");
//        String line = reader.readLine();

        toDot("esempio");
    }
    
}
