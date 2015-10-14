/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.DFA;

/**
 *
 * @author Giuseppe
 */
public class Gen {
    public char start;
    public char end;
    
    
    public char val[];
    
    public Gen(char[] val)
    {
        this.val = val;
    }
    public Gen(char start, char end) {
        this.start = start;
        this.end = end;
    }
    
    public static Gen getDigits() {
        return new Gen('0', '9');
    }
    
    public static Gen getPlusMinus()
    {
        return new Gen(new char[]{'+', '-'});
    }
            
}
