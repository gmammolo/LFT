/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.Lab_17_10_2014.lft_es2;

import LFT.DFA.DFA;
import static LFT.Lab_17_10_2014.lft_es2.LFT_ES2.scan;
import java.io.BufferedReader;
import java.io.InputStreamReader;



/**
 *
 * @author Giuseppe
 */
public class LFT_ES2_DFA {
    
    public static DFA dfa ; 
    
    public static boolean scan(String s)
    {
        dfa= new DFA(7);
        
        return false;
        
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
