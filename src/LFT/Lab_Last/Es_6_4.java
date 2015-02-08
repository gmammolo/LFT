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
public class Es_6_4 {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        new RegExpSequence(
            new RegExpSequence(
                new RegExpSequence(
                       new RegExpSequence(
                            new RegExpSequence(
                                new RegExpChoice(
                                        new RegExpSymbol('-') ,
                                        new RegExpEpsilon()
                                ),
                                new RegExpStar(new RegExpRange('1', '9') )
                            ),
                            new RegExpChoice(
                                new RegExpSymbol('.'),
                                new RegExpEpsilon()
                            )
                       ) , 
                       new RegExpStar(new RegExpRange('1', '9'))
                ),
                new RegExpChoice(new RegExpSequence(new RegExpSymbol('e'), new RegExpRange('1', '9')), new RegExpEpsilon())
            ),
            new RegExpStar(new RegExpRange('1', '9'))
        ).compile().dfa().minimize().toDOTAlternative("64");

        
    }
}
