/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.A2015.Es1;

import LFT.DFA.DFA;
import LFT.DFA.DFAModel;
import static LFT.Lab_24_10_2014.Es2_5.Es2_5.GenerateDFA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Giuseppe
 */
public class Comma3 extends DFAModel{
    
    @Override
    protected int NumState () {return 9; }
           
    @Override
    public void InitializeDFA()
    {
        SetMove(0, '0','9', 1);
        SetMove(0, new char[]{'+', '-'}, 6);
        SetMove(0, '-', 6);
        SetMove(0, '.', 5);
        
        SetMove(1, '0', '9', 1);
        SetMove(1, 'e', 2);
        SetMove(1, ' ', 8);
        
        SetMove(2, '0', '9', 3);
        SetMove(2, new char[]{'+', '-'}, 4);
        
        SetMove(3, '0', '9', 3);
        SetMove(3, ' ', 8);
        
        SetMove(4, '0', '9', 3);
        
        SetMove(5, '0', '9', 7);
        
        SetMove(7, '0', '9', 7);
        SetMove(7, ' ', 8);
        
        SetMove(8, ' ', 8);

        AddFinalState(1);
        AddFinalState(3);
        AddFinalState(7);
        AddFinalState(8);
    }
    

    public static void main(String[] args) throws Exception {
        //InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        //BufferedReader reader = new BufferedReader(inputStreamReader);
        //System.out.println("Type the line:");
        //String line = reader.readLine();

        //toJava("Es1_3");
        new Comma3().toDot("Es1_3");

    }
    
}
