/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.Lab_24_10_2014.Es2_5;

import LFT.DFA.*;

/**
 *
 * @author giuseppe
 */
public class Test_Minimize{

    public static DFA dfa;
    
    public static void GenerateDFA() {
        dfa = new DFA(4);
        dfa.setMove(0, '0', 0);
        dfa.setMove(0, '1', 1);
        dfa.setMove(1, '1', 1);
        dfa.setMove(1, '0', 2);
        dfa.setMove(2, '0', 2);
        dfa.setMove(2, '1', 3);
        dfa.setMove(3, '1', 3);
        dfa.setMove(3, '0', 2);
        dfa.addFinalState(1);
        dfa.addFinalState(3);
    }
    
    public static void main(String[] args) throws Exception {
        GenerateDFA();
        dfa.toDOT("esercizio");
        DFA B = dfa.minimize();
        B.toDOT("secondo");
    }
}
