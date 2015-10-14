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
public abstract class DFAModel {
    private DFA dfa;
  
    /**
     * Inizializza un DFA: in questo metodo andranno messi i
     * SetMove e AddFinalState
     */
    protected abstract void InitializeDFA ();
    
    /**
     * 
     * @return numero di stati presenti nel DFA
     */
    protected abstract int NumState();
    
    /**
     * Genera il DFA
     */
    private void GenerateDFA() {
        dfa = new DFA(NumState());
        InitializeDFA();
    }
    
    
    protected void SetMove(Integer p, Gen g, Integer q)
    {
        if(g.val.length > 0) {
             SetMove(p, g.val, q);
        }
        else
            SetMove(p, g.start, g.end, q);
    }
    
    
    
    /**
     * Imposta una move da uno stato p ad uno stato q dovuta a un carattere ch
     * @param p stato iniziale  
     * @param ch carattere  
     * @param q stato finale
     */
    protected void SetMove(Integer p, char ch, Integer q)
    {
        dfa.setMove(p, ch, q);
    }
    
    /**
     * Imposta una move da uno stato p ad uno stato q per  un range di valori
     * @param p stato iniziale
     * @param start inizio del range di valori
     * @param end fine del range di valori
     * @param q stato finale
     */
    protected void SetMove(Integer p, char start, char end, Integer q)
    {
        dfa.setMove(p, start,end, q);
    }
        
    /**
     * 
     * @param p stato iniziale 
     * @param ch array di char contente la serie di caratteri che permettono il movimento
     * @param q stato finale
     */
    protected void SetMove(Integer p, char[] ch, Integer q)
    {
        for(Character a :ch) 
        {
            SetMove(p, a, q);
        }
    }
    
    /**
     * Aggiunge un nuovo stato finale al DFA
     * @param p stato finale
     */
    protected void AddFinalState(Integer p)
    {
        dfa.addFinalState(p);
    }
    
    /**
     * Stampa a video il dot del DFA
     * @param s 
     */
   public void toDot(String s) {
        
        GenerateDFA();
        dfa.toDOT(s);
    }
    
   /**
    * Stampa a video il codice del dfa
    * @param s nome della classe java
    */
    public void toJava(String s) {
        
        GenerateDFA();
        dfa.toJava(s);
    }
        
}
