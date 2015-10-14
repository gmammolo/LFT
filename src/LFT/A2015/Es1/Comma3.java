/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.A2015.Es1;

import LFT.DFA.DFAModel;
import LFT.DFA.Gen;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Giuseppe
 */
public class Comma3 extends DFAModel{
    
    @Override
    protected int NumState() {
        return 8;
    }

    @Override
    public void InitializeDFA() {
        SetMove(0, Gen.getDigits(), 1);
        SetMove(0, Gen.getPlusMinus(), 2);
        SetMove(0, '.' , 3);
        
        SetMove(1, Gen.getDigits(), 1);
        SetMove(1, '.' , 3);
        SetMove(1, 'e' , 4);
        
        SetMove(2, '.' , 3);
        SetMove(2, Gen.getDigits(), 1);
        
        SetMove(3, Gen.getDigits() , 5);
        
        SetMove(4, Gen.getPlusMinus() , 6);
        SetMove(4, Gen.getDigits() , 7);
        
        SetMove(5, Gen.getDigits(), 5);
        SetMove(5, 'e', 4);
        
        SetMove(6, Gen.getDigits(), 7);
        
        
        AddFinalState(1);
        AddFinalState(5);
        AddFinalState(7);
    }
 
    
        public static void main(String[] args) throws Exception {

        Comma3 es = new Comma3();
        es.toJava("Comma3_Code");
        es.toDotAlternative("Comma3_Dot");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        System.out.println("Type the line:");
        String line = reader.readLine();
        if (line == null) {
            System.out.println("Input non Accettabile");
        } else {
            System.out.println("Result: " + new Comma6().Scan(line));
        }

    }
}
