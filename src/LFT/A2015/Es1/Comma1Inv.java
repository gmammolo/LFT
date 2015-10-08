/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.A2015.Es1;

import LFT.DFA.DFAModel;

/**
 *
 * @author Giuseppe
 */
public class Comma1Inv extends DFAModel{

    @Override
    protected void InitializeDFA() {
        SetMove(0, '1', 0);
        SetMove(0, '0', 1);
        
        SetMove(1, '1', 0);
        SetMove(1, '0', 2);
        
        SetMove(2, '1', 0);
        SetMove(2, '0', 3);
        
        SetMove(3, new char[]{'0','1'}, 3);
        
        AddFinalState(0);
        AddFinalState(1);
        AddFinalState(2);
    }

    @Override
    protected int NumState() {
       return 4;
    }
    
    public static void main(String[] args) throws Exception {
        //InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        //BufferedReader reader = new BufferedReader(inputStreamReader);
        //System.out.println("Type the line:");
        //String line = reader.readLine();

        //toJava("Es1_3");
        new Comma1().toJava("Comma1Inv_Code");
        new Comma1().toDot("Comma1Inv_Dot");
    }
    
}
