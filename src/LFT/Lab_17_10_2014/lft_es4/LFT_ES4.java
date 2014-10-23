/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LFT.Lab_17_10_2014.lft_es4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ESERCIZIO 4
 * Progettare e implementare un DFA che riconosca il linguaggio degli
 * identicatori in un linguaggio in stile Java: un identicatore e una sequenza non vuota di lettere,
 * numeri, ed il simbolo di sottolineatura _ che non comincia con un numero e che non puo essere
 * composto solo da un _ .
 * @author Giuseppe
 */
public class LFT_ES4 {

    public static boolean scan(String s)
    {
        int state = 0;
        int i = 0;
        while (state >= 0 && i < s.length()) {
        final char ch = s.charAt(i++);
        switch (state) {
            case 0:
                if(ch >= 'a' && ch <='z' || ch >= 'A' && ch <='Z')
                    state = 1;
                else if (ch == '_')
                    state = 2;
                else
                    state = -1;
                break;
            case 1:
                if(ch >= 'a' && ch <='z' || ch >= 'A' && ch <='Z' || ch >= '0' && ch <= '9')
                    state = 1;
                else
                    state = -1;
                break;
            case 2:
                if(ch >= 'a' && ch <='z' || ch >= 'A' && ch <='Z' || ch >= '0' && ch <= '9')
                    state = 1;
                else
                    state = -1;
                break;
            }
        }
        return state == 1;
    }
    
    public static void main(String[] args) throws Exception
    {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        System.out.println("Type the line:");
        String line = reader.readLine();

        
        System.out.println(scan(line) ? "OK" : "NOPE");
    }
 
}
