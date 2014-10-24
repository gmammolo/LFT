/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.DFA;

import java.util.ArrayList;


public class Transitions {

    private ArrayList transition;
    
    
    public Transitions(){
        transition = new ArrayList();
    }
    
    
    public void AddTransiction(int start, char ch, int end)
    {
        Transition ts=new Transition(start, end,ch); 
        if(transition.contains(ts))
        {
           ((Transition)transition.get(transition.indexOf(ts))).AddLabel(ch);
        }
        else
        {
            transition.add(ts);
        }
    }
    
    
    @Override
    public String toString()
    {
        String s="";
        for(Object o : transition)
        {
            if (o instanceof Transition) {
                Transition m = (Transition) o;
            
                s+=m.toString();
            }
        }
        return s;
    }
    
    /**
     *
     * @author giuseppe
     */
    public class Transition {
        /** Lo stato di partenza. */
        final Integer start;
        /** Lo stato di arrivo. */
        final Integer end;
        public ArrayList<Character> label;

//        /**
//         * Crea uno stato di transizione dal punto start al punto end
//         * @param start
//         * @param end 
//         */
//        public Transition(int start, int end)
//        {
//            this.start = start;
//            this.end = end;
//            this.label= "";
//        }

                /**
         * Crea uno stato di transizione dal punto start al punto end
         * @param start
         * @param end 
         */
        public Transition(int start, int end, char ch)
        {
            this.start = start;
            this.end = end;
            this.label = new ArrayList<Character>();
            this.label.add(ch);
        }
        

         /**
         * Confronta due transizioni.
         * @param o La mossa da confrontare a questa.
         * @return <code>true</code> se le due mosse sono uguali, ovvero
         *         hanno lo stesso stato di partenza e lo stesso simbolo,
         *         <code>false</code> altrimenti.
         */
        public boolean equals(Object o) {
            if (o instanceof Transition) {
                Transition m = (Transition) o;
                return (start == m.start && end == m.end);
            } else
                return false;
        }

        public void AddLabel(char c){
            this.label.add(c);
        }
        
        /**
         * ordina il label
         */
        public void Ordina(){
            
        }
        
        @Override
        public String toString()
        {
            String s="";
            for(Character c : label)
            {
                s+=c+",";
            }
            
            return "q"+this.start+" -> q"+end+" [ label = \""+s+"\" ] \n";
        }

    }
}