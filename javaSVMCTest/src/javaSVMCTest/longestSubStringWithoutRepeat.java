package javaSVMCTest;

import java.util.Scanner;

public class longestSubStringWithoutRepeat {
	public static int lengthOfLogestSubString(String s) {
		String t="";
		int count=0;
		int max=0;
		for(int j=0;j<s.length();j++) {
			count=0;
			t="";
			for(int i=j;i<s.length();i++) {
				if(!t.contains(String.valueOf(s.charAt(i)) )) {
					count=count+1;
					t+=String.valueOf(s.charAt(i));
					System.out.println(t);
					if(max<count) {
						max=count;
					}
				}else {
					count=0;
					t="";
				}
			}
		}
		
		return max;
	}
	public static void main(String[] agrs) {
		Scanner scanner=new Scanner(System.in);
		String s=scanner.nextLine();
		
		int max=longestSubStringWithoutRepeat.lengthOfLogestSubString(s);
		System.out.print(max);
	}
}
