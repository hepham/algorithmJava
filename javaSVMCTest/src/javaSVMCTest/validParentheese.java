package javaSVMCTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class validParentheese {
public static boolean isValid(String s) {
	Stack<Character> stack= new Stack<>();
	for(char c:s.toCharArray()) {
		switch(c) {
		case '{':
		case '(':
		case '[':
			stack.push(c);
			break;
		case')':
			if(stack.isEmpty()||stack.pop()!='(') {
				return false;
			}
			break;
		case']':
			if(stack.isEmpty()||stack.pop()!='[') {
				return false;
	
			}
			break;
		case'}':
			if(stack.isEmpty()||stack.pop()!='{') {
				return false;
			}
			break;
			
		}
	}
	System.out.println(stack);
	return stack.isEmpty();
	
}
public static void main(String[] args) {
	File testcase=new File("./src/javaSVMCTest/testcase.txt");
	String s="";
	try {
		Scanner sc=new Scanner(testcase);
		while (sc.hasNextLine()){
			s=sc.nextLine();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(validParentheese.isValid(s));
}
}
