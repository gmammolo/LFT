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
public class RegExpEmpty implements RegExp {

    public RegExpEmpty() {
    }

    @Override
    public NFA compile() {
        NFA a = new NFA(0);
        return a;
    }
}
