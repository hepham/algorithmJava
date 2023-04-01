package binarySearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MinMaxSub {
	public static int findMax(int arr[]) {
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		return max;
	}
	public static int findMinMaxSub(int arr[],int k,int n) {
		int low=findMax(arr);
		int high=0;
		for(int i=0;i<arr.length;i++) {
			high=high+arr[i];
		}
		int min=Integer.MAX_VALUE;
		while(low<=high) {
			int mid=(low+high)/2;
			if(checkEnoughGroup(arr, mid, k, n)) {
				if(min>mid)min=mid;
				high=mid-1;
			}
			else low=mid+1;
			
		}
		return min;
	}
	public static boolean checkEnoughGroup(int arr[],int mid,int k,int n) {
		int count=0;
		int i=0;
		while(i<arr.length) {
			int val=0;
			while(i<arr.length&&arr[i]+val<=mid)val+=arr[i++];
			count++;
		}
		return count<=k;
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("test.txt"));
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int testcase=1;testcase<=T;testcase++) {
			int m=sc.nextInt();
			int k=sc.nextInt();
			int n=sc.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
			}
			System.out.println("#"+testcase+" "+findMinMaxSub(arr,k, m));
		}
	}

}