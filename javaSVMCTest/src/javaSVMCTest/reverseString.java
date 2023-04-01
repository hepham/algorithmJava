package javaSVMCTest;

import java.util.Scanner;
import java.util.Stack;

public class reverseString {
public String reverse(String s) {
	StringBuilder result=new StringBuilder();
	Stack<Character> stack=new Stack<Character>();
	for(int i=0;i<s.length();i++) {
		stack.push(s.charAt(i));
	}
	while (!stack.empty()) {
		result.append(stack.pop());
	}
	return result.toString();
}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String s=sc.nextLine();
	reverseString r=new reverseString();
	System.out.print(r.reverse(s));
	
}
}
