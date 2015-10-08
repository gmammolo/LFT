/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.Lab_Last;

import LFT.NFA.NFA;
import LFT.RegExp.*;

/**
 *
 * @author Giuseppe
 */
public class Es_6_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new RegExpStar(new RegExpChoice(new RegExpSymbol('a'), new RegExpSymbol('b'))).compile().ToDOT("Esercizio");
        
        //new RegExpStar(new RegExpChoice(new RegExpSymbol('a'), new RegExpSymbol('b'))).compile().lineToDOT("Esercizio");
        
    }
    
}
