/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.RegExp;

import LFT.NFA.NFA;

/**
 *
 * @author Giuseppe
 */
public class RegExpEpsilon  implements RegExp {
    private char ch;
    
    RegExpEpsilon() {
	this.ch = NFA.EPSILON;
    }

    public NFA compile() {
	NFA a = new NFA(2);
	a.addMove(0, ch, 1);
	a.addFinalState(1);
	return a;
    }
}

