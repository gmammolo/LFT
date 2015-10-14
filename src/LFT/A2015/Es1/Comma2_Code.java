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
public class Comma2_Code {
	public static boolean scan(String s)
	{
		int state = 0;
		int i = 0;
		while(state >= 0 && i < s.length()) {
		final char ch = s.charAt(i++);
		switch(state) {
			case 0:
				if(ch == '+' || ch == '-' ) 
					state = 2;
				else if(ch == '.' ) 
					state = 3;
				else if(ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9' ) 
					state = 1;
				else 
 					state = -1; 
 				break;
			case 1:
				if(ch == '.' ) 
					state = 3;
				else if(ch == '1' || ch == '0' || ch == '3' || ch == '2' || ch == '5' || ch == '4' || ch == '7' || ch == '6' || ch == '9' || ch == '8' ) 
					state = 1;
				else if(ch == 'e' ) 
					state = 4;
				else 
 					state = -1; 
 				break;
			case 2:
				if(ch == '.' ) 
					state = 3;
				else if(ch == '2' || ch == '3' || ch == '0' || ch == '1' || ch == '6' || ch == '7' || ch == '4' || ch == '5' || ch == '8' || ch == '9' ) 
					state = 1;
				else 
 					state = -1; 
 				break;
			case 3:
				if(ch == '3' || ch == '2' || ch == '1' || ch == '0' || ch == '7' || ch == '6' || ch == '5' || ch == '4' || ch == '9' || ch == '8' ) 
					state = 5;
				else 
 					state = -1; 
 				break;
			case 4:
				if(ch == '-' || ch == '+' ) 
					state = 6;
				else if(ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '8' || ch == '9' ) 
					state = 7;
				else 
 					state = -1; 
 				break;
			case 5:
				if(ch == '5' || ch == '4' || ch == '7' || ch == '6' || ch == '1' || ch == '0' || ch == '3' || ch == '2' || ch == '9' || ch == '8' ) 
					state = 5;
				else 
 					state = -1; 
 				break;
			case 6:
				if(ch == '6' || ch == '7' || ch == '4' || ch == '5' || ch == '2' || ch == '3' || ch == '0' || ch == '1' || ch == '8' || ch == '9' ) 
					state = 7;
				else 
 					state = -1; 
 				break;
			case 7:
				if(ch == '7' || ch == '6' || ch == '5' || ch == '4' || ch == '3' || ch == '2' || ch == '1' || ch == '0' || ch == '9' || ch == '8' ) 
					state = 7;
				else 
 					state = -1; 
 				break;
			}
		}
		return state == 1 && state == 5 && state == 7;
		}
	public static void main(String[] args)
	{
		System.out.println(scan(args[0]) ? "OK" : "NOPE");
	}
}
