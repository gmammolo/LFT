/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.DFA;

/**
 *
 * @author giuseppe
 */
public abstract class Model {
    
    protected static DFA dfa;
    
    protected static void SetMove(Integer p, Character ch, Integer q)
    {
        dfa.setMove(p, ch, q);
    }
    
    protected static void AddFinalState(Integer p)
    {
        dfa.addFinalState(p);
    }
    
    
    //public static void GenerateDFA() {}
   
}
