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
    
    
    public String toDot()
    {
        String s="";
        for(Object o : transition)
        {
            if (o instanceof Transition) {
                Transition m = (Transition) o;
            
                s+=m.toDot();
            }
        }
        return s;
    }
    
    
    public String toJava()
    {
        String s = "";
        if(transition.size()>0)
        {
            int oldstate = ((Transition)transition.get(0)).start;
            s+="\t\t\tcase "+oldstate+":\n";
            s+="\t\t\t"+((Transition)transition.get(0)).toJava();
            for(int i=1; i<transition.size()-1;i++)
            {
                Transition tr= ((Transition)transition.get(i));
                if(tr.start != oldstate)
                {
                    s +="\t\t\telse \n \t\t\t\tstate == -1; \n \t\t\tbreak;\n";
                    oldstate = tr.start;
                    s+="\t\t\tcase "+oldstate+":\n\t\t\t"+tr.toJava();
                }
                else
                    s+="\t\t\telse "+tr.toJava();
            }
            s +="\t\t\telse \n \t\t\t\tstate == -1; \n \t\t\tbreak;\n";
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
        
        public String toDot()
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
        
        
        public String toJava()
        {
            String s="if(";
            for(int i=0; i<label.size()-2;i++)
            {
                s+="ch == '"+label.get(i)+"' || ";
            }
            s+="ch == "+label.get(label.size()-1)+" ) \n"+
               "\t\t\t\tstate == "+end+";\n";
            return s;
        }

    }
}