/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.A2016.cap1;

import main.java.com.opendfa.DFAModel;

/**
 *
 * @author Giuseppe
 */
public class Comma1 extends DFAModel {

    @Override
    protected int numState() {
        return 4;
    }

    @Override
    protected void initializeDFA() {
        setMove(0, '1', 0);
        setMove(0, '0', 1);

        setMove(1, '1', 0);
        setMove(1, '0', 2);

        setMove(2, '1', 0);
        setMove(2, '0', 3);

        setMove(3, new char[]{'0', '1'}, 3);

        addFinalState(3);
    }

    public static void main(String[] args) throws Exception {

        Comma1 comma = new Comma1();

        //InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        //BufferedReader reader = new BufferedReader(inputStreamReader);
        //System.out.println("Type the line:");
        //String line = reader.readLine();
        //comma.scan(line);
        String outputDir = "/home/terasud/NetBeansProjects/LFT/src/LFT/A2016/cap1/";
        System.out.println(comma.toJava("Es1Comma1_Code"));
        comma.writeToJava("Es1Comma1_Code", outputDir);
        System.out.println(comma.toDot("Es1Comma1_Dot"));
        comma.writeToDot("Es1Comma1_Dot", outputDir);
        comma.ToPng("Es1Comma1_Png", outputDir);
    }

}
