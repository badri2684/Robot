package com.robo.control.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String initialpos = "N 9 1";
		Pattern p = Pattern.compile("(^[NSWE])[ ]([0-9])[ ]([0-9])");
		Matcher matcher = p.matcher(initialpos);
	//	System.out.println("PRINTING THE O/P::" + matcher.matches());
		System.out.println(matcher.group(1));
		int x = Integer.parseInt(matcher.group(2));
		int y = Integer.parseInt(matcher.group(3));
		System.out.println(x);
		System.out.println(y);
		
		
	/*	String command="M1RM4L3M900";
		Pattern p1 = Pattern.compile("^[MLR][MLR[0-9]]*");
		Matcher matcher1 = p1.matcher(command);
		System.out.println("PRINTING THE O/P::" + matcher1.matches());*/

		String s="a";
		switch(s){
		case "a":
			
		}
	}
}