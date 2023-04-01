package javaSVMCTest;

import java.util.Scanner;

public class zigzag {
	public String convert(String s,int numRows) {
		if(numRows<=1)return  s;
		StringBuilder result=new StringBuilder();
		int k=2*(numRows-1);
		for(int i=0;i<numRows;i++) {
			int index=i;
			while(index<s.length()) {
				result.append(s.charAt(index));
				if(i!=0&& i!=numRows-1) {
					int k1=k-2*i;
					int k2=k1+index;
					if(k2<s.length()) {
						result.append(s.charAt(k2));
					}
					
				}
				index=index+k;
			}
			
		}
		
		
		return result.toString();
	}
	public static void main(String[]args) {
		Scanner scanner=new Scanner(System.in);
		String s=scanner.nextLine();
		int numRows=scanner.nextInt();
		scanner.close();
		zigzag zig=new zigzag();
		System.out.print(zig.convert(s,numRows));
	}

}
