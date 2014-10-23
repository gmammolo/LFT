/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.Lab_17_10_2014.lft_es5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ESERCIZIO 4 Progettare e implementare un DFA che riconosca il linguaggio
 * degli identicatori in un linguaggio in stile Java: un identicatore e una
 * sequenza non vuota di lettere, numeri, ed il simbolo di sottolineatura _ che
 * non comincia con un numero e che non puo essere composto solo da un _ .
 *
 * @author Giuseppe
 */
public class LFT_ES5 {

    public static boolean scan(String s) {
        int state = 0;
        //il caso 1 va gestito separatamente
        if(s.length()==1 && s.charAt(0)=='1')
            return true;
        int i = s.length()-1;
        while (state >= 0 && i >=0) {
            final char ch = s.charAt(i--);
            String debug="Sono nello stato "+String.valueOf(state) + "con il carattere " + ch ;
            switch (state) {
                case 0:
                    if (ch == '0') {
                        state = 1;
                    } else if (ch == '1') {
                        state = 2;
                    } else {
                        state = -1;
                    }
                    break;
                case 1:
                    if (ch == '0') {
                        state = 0;
                    } else if (ch == '1') {
                        state = 3;
                    } else {
                        state = -1;
                    }
                    break;
                case 2:
                    if (ch == '0') {
                        state = 4;
                    } else if (ch == '1') {
                        state = 0;
                    } else {
                        state = -1;
                    }
                    break;

                case 3:
                    if (ch == '0') {
                        state = 5;
                    } else if (ch == '1') {
                        state = 1;
                    } else {
                        state = -1;
                    }
                    break;

                case 4:
                    if (ch == '0') {
                        state = 2;
                    } else if (ch == '1') {
                        state = 5;
                    } else {
                        state = -1;
                    }
                    break;
                case 5:
                    if (ch == '0') {
                        state = 3;
                    } else if (ch == '1') {
                        state = 4;
                    } else {
                        state = -1;
                    }
                    break;
            }
            System.out.println(debug + " Vado Nello  stato "+state);
        }
        System.out.println("Stato "+state);
        return  state == 0 || state == 1;
    }

    public static void main(String[] args) throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        System.out.println("Type the line:");
        String line = reader.readLine();

        System.out.println(scan(line) ? "OK" : "NOPE");
    }

}
