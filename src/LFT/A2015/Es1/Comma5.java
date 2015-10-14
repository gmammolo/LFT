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
public class Comma5 extends DFAModel {

    @Override
    protected int NumState() {
        return 3;
    }

    @Override
    public void InitializeDFA() {
        
        SetMove(0, '0', 0);
        SetMove(0, '1', 1);
        SetMove(1, '1', 0);
        SetMove(1, '0', 2);
        SetMove(2, '0', 1);
        SetMove(2, '1', 2);
        AddFinalState(0);
    }

    public static void main(String[] args) throws Exception {

        Comma5 es = new Comma5();
        es.toJava("Comma5_Code");
        es.toDotAlternative("Comma5_Dot");
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
