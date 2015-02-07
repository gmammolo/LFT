/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.Lab_Last;

import LFT.RegExp.*;

/**
 *
 * @author Giuseppe
 */
public class Es_6_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
          new RegExpSequence( 
                new RegExpSequence(
                    new RegExpSequence(
                        new RegExpSymbol('/'),
                        new RegExpSymbol('*')  
                    ),
                    new RegExpChoice(
                            new RegExpChoice(
                                    new RegExpStar( new RegExpSymbol('/')),
                                    new RegExpStar( new RegExpSymbol('*'))
                            ),
                            new RegExpStar( new RegExpSymbol('c'))
                    )
                  ),
                new RegExpSequence(
                    new RegExpSymbol('*'),
                    new RegExpSymbol('/')    
                )    
          ).compile().ToDOT("Esercizio");
    }
    
}
