package com.blackteam.tictactoextrem;

public class Utils {

	
	public static String  getpositionSquare(String name){
		
		String returnString ;
		//square_0_0
		returnString = name .substring(6);
		System.out.println(returnString);
		return returnString;
	}
}
