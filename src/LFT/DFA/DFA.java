package LFT.DFA;


import java.util.HashSet;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Un oggetto della classe DFA rappresenta un automa a stati finiti
 * deterministico
 */
public class DFA
{
    /** 
     * Numero degli stati dell'automa. Ogni stato e` rappresentato da
     * un numero interno non negativo, lo stato con indice 0 e` lo
     * stato iniziale.
     */
    private int numberOfStates;

    /** Insieme degli stati finali dell'automa. */
    private HashSet<Integer> finalStates;

    /**
     * Funzione di transizione dell'automa, rappresentata come una
     * mappa da mosse a stati di arrivo.
     */
    private HashMap<Move, Integer> transitions;

    /**
     * Crea un DFA con un dato numero di stati.
     * @param  n Il numero di stati dell'automa.
     */
    public DFA(int n) {
	numberOfStates = n;
	finalStates = new HashSet<Integer>();
	transitions = new HashMap<Move, Integer>();
    }

    /**
     * Aggiunge uno stato all'automa.
     * @return L'indice del nuovo stato creato
     */
    public int newState() {
	return numberOfStates++;
    }

    /**
     * Aggiunge una serie di transizioni all' automa
     * @param  p  Lo stato di partenza della transizione.
     * @param  start Il simbolo di partenza che etichetta la transizione.
     * @param  end Il simbolo di chiusura che etichetta la transizione.
     * @param  q  Lo stato di arrivo della transizione.
     * @return <code>true</code> se lo stato di partenza e lo stato di
     *         arrivo sono validi, <code>false</code> altrimenti.
     */
    public boolean setMove (int p, char start, char end, int q)
    {
        boolean check = true;
        char ch= start;
        while (ch <= end)
        {
            check = setMove(p, ch, q);
        }
        return check;
    }
    
    /**
     * Aggiunge una transizione all'automa.
     * @param  p  Lo stato di partenza della transizione.
     * @param  ch Il simbolo che etichetta la transizione.
     * @param  q  Lo stato di arrivo della transizione.
     * @return <code>true</code> se lo stato di partenza e lo stato di
     *         arrivo sono validi, <code>false</code> altrimenti.
     */
    public boolean setMove(int p, char ch, int q) {
	if (!validState(p) || !validState(q))
	    return false;

	transitions.put(new Move(p, ch), q);
	return true;
    }

    /**
     * Aggiunge uno stato finale.
     * @param  p Lo stato che si vuole aggiungere a quelli finali.
     * @return <code>true</code> se lo stato e` valido,
     *         <code>false</code> altrimenti.
     */
    public boolean addFinalState(int p) {
	if (validState(p)) {
	    finalStates.add(p);
	    return true;
	} else
	    return false;
    }

    /**
     * Determina se uno stato e` valido oppure no.
     * @param  p Lo stato da controllare.
     * @return <code>true</code> se lo stato e` valido,
     *         <code>false</code> altrimenti.
     * @see #numberOfStates
     */
    public boolean validState(int p) {
	return (p >= 0 && p < numberOfStates);
    }

    /**
     * Determina se uno stato e` finale oppure no.
     * @param  p Lo stato da controllare.
     * @return <code>true</code> se lo stato e` finale,
     *         <code>false</code> altrimenti.
     * @see #finalStates
     */
    public boolean finalState(int p) {
	return finalStates.contains(p);
    }

    /**
     * Restituisce il numero di stati dell'automa.
     * @return Numero di stati.
     */
    public int numberOfStates() {
	return numberOfStates;
    }

    /**
     * Restituisce l'alfabeto dell'automa, ovvero l'insieme di simboli
     * che compaiono come etichette delle transizioni dell'automa.
     * @return L'alfabeto dell'automa.
     */
    public HashSet<Character> alphabet() {
	HashSet<Character> alphabet = new HashSet<Character>();
	for (Move m : transitions.keySet())
	    alphabet.add(m.ch);
	return alphabet;
    }

    /**
     * Esegue una mossa dell'automa.
     * @param p  Stato di partenza prima della transizione.
     * @param ch Simbolo da riconoscere.
     * @return Stato di arrivo dopo la transizione, oppure
     *         <code>-1</code> se l'automa non ha una transizione
     *         etichettata con <code>ch</code> dallo stato
     *         <code>p</code>.
     */
    public int move(int p, char ch) {
	Move move = new Move(p, ch);
	if (transitions.containsKey(move))
	    return transitions.get(move);
	else
	    return -1;
    }

    /**
     * Verifica se una stringa e` riconosciuta dall'automa.
     * @param  s  Stringa da riconoscere.
     * @return <code>true</code> se la stringa e` stata riconosciuta,
     *         <code>false</code> altrimenti.
     */
    public boolean scan(String s) {
	int state = 0;
        int i = 0;
        while (state >= 0 && i < s.length()) {
            final char ch = s.charAt(i++);
            state = move(state, ch);
        }
        return finalState(state);
       
    }

    /**
     * Stampa una rappresentazione testuale dell'automa da
     * visualizzare con <a href="http://www.graphviz.org">GraphViz</a>.
     * @param name Nome dell'automa.
     */
    public void toDOT(String name) {
	// DA IMPLEMENTARE
        String text="digraph "+name+" {\n" +
                    "rankdir=LR;\n" +
                    "node [shape = doublecircle];\n";
        for(Integer c : finalStates )
        {
            text+=" q"+c+"; ";
        }
        text+="\n node [shape = circle];\n";
        Support_Transitions arr_tmp = new Support_Transitions();
        for(Entry<Move, Integer> entry : transitions.entrySet()) {
            Move key = entry.getKey();
            Integer value = entry.getValue();
            
            arr_tmp.AddTransiction(key.start, key.ch, value);
            //text+="q"+key.start+" -> q"+value+" [ label = \""+key.ch+"\" ] \n";
                // do what you have to do here
                // In your case, an other loop.
        }
        text+=arr_tmp.toDot();
        text+="\n}";
        System.out.println(text);

                }

    
    private Support_Transitions GenerateSupport()
    {
        Support_Transitions arr_tmp = new Support_Transitions();
        for(Entry<Move, Integer> entry : transitions.entrySet()) {
            Move key = entry.getKey();
            Integer value = entry.getValue();
            
            arr_tmp.AddTransiction(key.start, key.ch, value);
//            s+="\t\t\tcase "+String.valueOf(key.start)+" : \n";  
        }
        return arr_tmp;
    }
    
    
    /**
     * Stampa una classe Java con un metodo <code>scan</code> che implementa 
     * l'automa.
     * @param name Nome della classe da generare.
     */
    public void toJava(String name) {
	String s="public class "+name+" {\n" +
                    "\tpublic static boolean scan(String s)\n" +
                    "\t{\n" +
                    "\t\tint state = 0;\n" +
                    "\t\tint i = 0;\n" +
                    "\t\twhile(state >= 0 && i < s.length()) {\n" +
                    "\t\tfinal char ch = s.charAt(i++);\n" +
                    "\t\tswitch(state) {\n";
//        Support_Transitions arr_tmp = new Support_Transitions();
//        for(Entry<Move, Integer> entry : transitions.entrySet()) {
//            Move key = entry.getKey();
//            Integer value = entry.getValue();
//            
//            arr_tmp.AddTransiction(key.start, key.ch, value);
////            s+="\t\t\tcase "+String.valueOf(key.start)+" : \n";  
//        }
        Support_Transitions arr_tmp = GenerateSupport();
        s+=arr_tmp.toJava();
        s+="\t\t\t}\n\t\t}\n";
        
        s+="\t\treturn ";
        Object[] arr =finalStates.toArray();
        for(int i=0; i< finalStates.size()-1;i++)
        {
            s += "state == "+arr[i]+" && ";
        }
        s+="state == "+String.valueOf(arr[arr.length-1])+";\n\t\t}\n";
        s+="\tpublic static void main(String[] args)\n" +
           "\t{\n" +
           "\t\tSystem.out.println(scan(args[0]) ? \"OK\" : \"NOPE\");\n" +
            "\t}\n" +
            "}\n";
        
        System.out.println(s);
    }
    
    
    /**************PROBLEMI DI RAGGIUNGIBILITA'******************/
    
    
    protected void reach(Integer state)
    {
//        Metodo SUpport
//        Support_Transitions arr_tmp = GenerateSupport();
//        Boolean[] res = arr_tmp.reach(state, numberOfStates);
        
//        Metodo Normale
        Boolean[] res = new Boolean[numberOfStates];
        for(int i=0; i< numberOfStates;i++)
        {
           res[i] = (state == i);
        }
        for(int i=0; i< numberOfStates;i++)
        {
            for(Entry<Move, Integer> entry : transitions.entrySet()) {
                Move key = entry.getKey();
                Integer value = entry.getValue();
                
                if(key.start == state)
                    res[value] = true;
                    
            }
        }
 
    }
    
    /**
     *
     * @return boolean  True se e solo se l’automa riconosce il linguaggio vuoto
     */
    public boolean empty()
    {
        reach(0);
        return false;
    }
    
    /**
     * 
     */
    public void sink()
    {
        
    }
    
    
}
