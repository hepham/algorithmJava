package javaSVMCTest;

import java.util.Scanner;

public class RomanToInt {
public static int romanToInt(String s) {
	int result=0;
	int number=0;
	int pre=0;
	for(int i=s.length()-1;i>=0;i--) {
		switch(s.charAt(i)) {
		case 'I':
			number=1;
			break;
		case 'V':
			number=5;
			break;
		case 'X':
			number=10;
			break;
		case 'L':
			number=50;
			break;
		case 'C':
			number=100;
			break;
		case 'D':
			number=500;
			break;
		case 'M':
			number=1000;
			break;
		}
		if(number<=pre) {
			result-=number;
		}else {
			result+=number;
		}
		pre=number;
	}
	
	return result;
}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String s=sc.nextLine();
	System.out.print(RomanToInt.romanToInt(s));
}
}
