/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lft_es2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ESERCIZIO 1 A
 * DFA: Creare un linguaggio che riconosce le stringhe in cui appaiono almeno 3 
 * zeri consegutivi
 * Alfabeto: {0,1}
 * @author Giuseppe
 */
public class LFT_ES2 {

    public static boolean scan(String s)
    {
        int state = 0;
        int i = 0;
        while (state >= 0 && i < s.length()) {
        final char ch = s.charAt(i++);
        switch (state) {
            case 0:
                if(ch == '+' || ch == '-' || ch == '.' || ch == 'e' || ( ch >= '0' && ch <= '9'  ) )
                    state = 1;
                else
                    state = -1;
                break;
            case 1:
                if( ch >= '0' && ch <= '9'  ) 
                    state = 1;
                else if(ch == 'e')
                    state = 3;
                else if(ch == '.')
                    state = 4;
                else
                    state = -1;
                break;
            case 3:
                if(ch == '+' || ch == '-' || ch == '.' || ch == 'e' || ( ch >= '0' && ch <= '9'  ))
                    state = 5;
                else
                    state = -1;
                break;
            case 4:
                if( ch >= '0' && ch <= '9'  ) 
                    state = 4;
                else if(ch == 'e')
                    state = 3;
                else
                    state = -1;
                break;
            }
        }
        return state > 1;
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
