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
public class RegExpChoice implements RegExp {

    private RegExp e1;
    private RegExp e2;

    public RegExpChoice(RegExp e1, RegExp e2) {
	this.e1 = e1;
	this.e2 = e2;
    }
    
    
    @Override
    public NFA compile() {
        NFA a = new NFA(2);
       final int n = a.append(e1.compile());
       final int m = a.append(e2.compile());
       a.addMove(0, NFA.EPSILON, n);
       a.addMove(0, NFA.EPSILON, m);
       a.addMove(n + 1, NFA.EPSILON, 1);
       a.addMove(m + 1, NFA.EPSILON, 1);
       a.addFinalState(1);
       return a;
    }

    
}
