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
public class RegExpRange implements RegExp {

    private char s1;
    private char s2;

    public RegExpRange(char from, char to) {
        this.s1 = from;
        this.s2 = to;
    }

    @Override
    public NFA compile() {
        if (s1 > s2) {
            char tmp = s1;
            s1 = s2;
            s2 = tmp;
        } else if (s1 == s2) { //se from e to sono lo stesso simbolo
            return new RegExpSymbol(s2).compile();
        }
        
        return new RegExpChoice(
                new RegExpSymbol((char) s1),
                new RegExpRange((char)(s1 + 1), (char) s2)
        ).compile();
    }

}
