/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.A2015.Es1;

import LFT.DFA.DFAModel;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author Giuseppe
 */
public class Comma6 extends DFAModel{
    
    @Override
    protected int NumState () {return 9; }
           
    @Override
    public void InitializeDFA()
    {
        SetMove(0, '/', 1);        
        SetMove(1, '*', 2);
        SetMove(2, 'a', 2);   
        SetMove(2, '*', 3);
        SetMove(3, 'a', 2);
        SetMove(3, '*', 3);
        SetMove(3, '/', 4);
        
        AddFinalState(4);

    }
    

    public static void main(String[] args) throws Exception {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        System.out.println("Type the line:");
        String line = reader.readLine();
        if(line==null) {
            System.out.println("Input non Accettabile");
        }
        else
        System.out.println("Result: "+ new Comma6().Scan(line));  
//        new Comma6().toJava("Comma6_Code");
//        new Comma6().toDot("Comma6_Dot");

    }
    
}
