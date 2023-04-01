package javaSVMCTest;

import java.util.HashMap;
import java.util.Scanner;

public class HappyNumber {
	public boolean isHappy(int n) {
		HashMap<Integer, Integer> map=new HashMap<>();
		while (n!=1) {
			int current=n;
			int sum=0;
			while(current!=0) {
				int temp=current%10;
				sum=sum+temp*temp;
				current=current/10;
				
			}
			if(map.containsKey(sum)) {
				return false;
			}
			map.put(n,1);
			n=sum;
		}
		return true;
	}

	public static void main(String[] agrs) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		HappyNumber happyNumber=new HappyNumber();
		System.out.println(happyNumber.isHappy(n));
	}
}
