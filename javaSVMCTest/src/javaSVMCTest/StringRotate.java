package javaSVMCTest;

import java.util.Scanner;

public class StringRotate {
	public boolean  rotateString(String a,String b,int rotate) {
		char[] aArray=new char[a.length()];
		char[] bArray=new char[b.length()];
		 for (int i = 0; i < a.length(); i++) {
			 aArray[i] = a.charAt(i);
	      }
		 for (int i = 0; i < b.length(); i++) {
			 bArray[i] = b.charAt(i);
	      }
		for(int i=0;i<a.length();i++) {
			System.out.println(aArray[i]+" "+bArray[(i+rotate)%b.length()]);
			if(aArray[i]!=bArray[(i+rotate)%b.length()]) {
				return false;
			}
		}

		return true;
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String a=scanner.nextLine();
		String b=scanner.nextLine();
		scanner.close();
		boolean check=false;
		StringRotate stringrotate=new StringRotate();
		if(a.length()!=b.length()) {
			check=false;
		}else {
			for(int i =0;i<a.length();i++) {
				check=stringrotate.rotateString(a, b, i);
				if(check) {break;}
			}
		}
		System.out.print(check);
	}

}
