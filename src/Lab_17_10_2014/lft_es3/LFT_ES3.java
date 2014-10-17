/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Lab_17_10_2014.lft_es3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ESERCIZIO 1 A
 * DFA: Creare un linguaggio che riconosce le stringhe in cui appaiono almeno 3 
 * zeri consegutivi
 * Alfabeto: {0,1}
 * @author Giuseppe
 */
public class LFT_ES3 {

    public static boolean scan(String s)
    {
        int state = 0;
        int i = 0;
        while (state >= 0 && i < s.length()) {
        final char ch = s.charAt(i++);
        switch (state) {
            case 0:
                if ( ch >= '0' && ch <= '9'  ) 
                    state = 1;
                else if(ch== '.')
                    state = 2;
                else if(ch == 'e')
                    state = 4;
                else if(ch == '+' || ch == '-' )
                    state = 7;
                else if(ch == ' ')
                    state=0;
                else
                    state = -1;
                break;
            case 1:
                if( ch >= '0' && ch <= '9'  ) 
                    state = 1;
                else if(ch == 'e')
                    state = 4;
                else if(ch == '.')
                    state = 2;
                else
                    state = -1;
                break;
            case 2:
                if( ch >= '0' && ch <= '9'  )
                    state = 3;
                else
                    state = -1;
                break;
            case 3:
                if( ch >= '0' && ch <= '9'  ) 
                    state = 3;
                else if(ch == 'e')
                    state = 4;
                else
                    state = -1;
                break;
            case 4:
                if(ch == '+' || ch == '-' )
                    state = 5;
                else if( ch >= '0' && ch <= '9'  )
                    state = 6;
                else
                    state = -1;
                break;
            case 5:
                if( ch >= '0' && ch <= '9'  )
                    state = 6;
                else
                    state = -1;
            case 6:
                if( ch >= '0' && ch <= '9'  )
                    state = 6;
                else
                    state = -1;
            case 7:
                if( ch >= '0' && ch <= '9'  )
                    state = 1;
                else if(ch == 'e')
                    state = 4;
                else if(ch == '.')
                    state = 2;
                else
                    state = -1;
                            
            }
        }
        return state == 1 || state == 3 || state == 6 ;
    }
    
    public static void main(String[] args) throws Exception
    {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        System.out.println("Input:");
        String line = reader.readLine();

        
        System.out.println(scan(line) ? "OK" : "NOPE");
    }
 
}
