/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.DFA;

import java.util.ArrayList;
import java.util.Collections;


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
            String s ="";
            Collections.sort(label);
            if(label.size()>0)
            {
                char old = label.get(0);
                s = old+"";
                for(Character c : label)
                {
                    if( old+1 == c)
                    {
                        if( s.charAt(s.length()-1)!= '-' )
                            s+="-";
                    }
                    else if(old != c && s.charAt(s.length()-1)!= old )
                    {
                        s+=old+","+c;
                    }
                    old=c;
                }
                if(s.charAt(s.length()-1)!= old)
                    s+=old;
                
            }
            return "q"+this.start+" -> q"+end+" [ label = \""+s+"\" ] \n";
        }

    }
}