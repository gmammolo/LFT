/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.Lab_17_10_2014.lft_es5;

import LFT.DFA.DFA;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ESERCIZIO 4 Progettare e implementare un DFA che riconosca il linguaggio
 * degli identicatori in un linguaggio in stile Java: un identicatore e una
 * sequenza non vuota di lettere, numeri, ed il simbolo di sottolineatura _ che
 * non comincia con un numero e che non puo essere composto solo da un _ .
 *
 * @author Giuseppe
 */
public class LFT_ES5B {

    private static DFA dfa;
    
    public static void GenerateDFA()
    {
        dfa = new DFA(4);
        dfa.setMove(0, '0', 1);
        dfa.setMove(0, '1', 2);
        dfa.setMove(1, '0', 1);
        dfa.setMove(1, '1', 2);
        dfa.setMove(2, '0', 3);
        dfa.setMove(2, '1', 1);
        dfa.setMove(3, '0', 2);
        dfa.setMove(3, '1', 3); 
        dfa.addFinalState(0);
        dfa.addFinalState(1);
    }
    
    public static boolean scan(String s) {
        
        GenerateDFA();
        return dfa.scan(s);
    }

    public static void main(String[] args) throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        System.out.println("Type the line:");
        String line = reader.readLine();

        System.out.println(scan(line) ? "OK" : "NOPE");
    }

}
