/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LFT.A2015.Es1;

/**
 *
 * @author Giuseppe
 */
public class Comma6_Code {
	public static boolean scan(String s)
	{
		int state = 0;
		int i = 0;
		while(state >= 0 && i < s.length()) {
		final char ch = s.charAt(i++);
		switch(state) {
			case 0:
				if(ch == '/' ) 
					state = 1;
				else 
 					state = -1; 
 				break;
			case 1:
				if(ch == '*' ) 
					state = 2;
				else 
 					state = -1; 
 				break;
			case 2:
				if(ch == 'a' ) 
					state = 2;
				else if(ch == '*' ) 
					state = 3;
				else 
 					state = -1; 
 				break;
			case 3:
				if(ch == 'a' ) 
					state = 2;
				else if(ch == '*' ) 
					state = 3;
				else if(ch == '/' ) 
					state = 4;
				else 
 					state = -1; 
 				break;
			}
		}
		return state == 4;
		}
	public static void main(String[] args)
	{
		System.out.println(scan(args[0]) ? "OK" : "NOPE");
	}
}
