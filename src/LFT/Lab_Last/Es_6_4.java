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
//         new RegExpRange('1', '9').compile().dfa().toDOT("64");
//        new RegExpChoice(new RegExpChoice(new RegExpSymbol('1'),new RegExpSymbol('2')), new RegExpChoice(new RegExpSymbol('3'),new RegExpSymbol('4'))).compile().dfa().minimize().toDOT("64");
    
        new RegExpSequence(
               new RegExpSequence(
                    new RegExpSequence(
                        new RegExpChoice(
                                new RegExpSequence(new RegExpSymbol('-'), new RegExpRange('1', '9')) ,
                                new RegExpEpsilon()
                        ),
                        new RegExpStar(new RegExpRange('1', '9') )
                    ),
                    new RegExpChoice(
                        new RegExpSequence(new RegExpSymbol('.'), new RegExpRange('1', '9')),
                        new RegExpEpsilon()
                    )
               ) , 
               new RegExpStar(new RegExpRange('1', '9'))
        ).compile().dfa().minimize().toDOTAlternative("64");
    
    }
}
