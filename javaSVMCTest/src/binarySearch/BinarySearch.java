package binarySearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class BinarySearch {
	public static int search(int[] arr,int target) {
		int result=-1;
		int start=0;
		int end=arr.length;
		int mid=(start+end)/2;
		if(target<arr[0]||target>arr[end-1])return -1;
		while(mid!=end||mid!=start) {

			if(arr[mid]==target)return mid;
			if(arr[mid]>target) {
				end=mid;
			}
			if(arr[mid]<target) {
				start=mid;
			}
			mid=(start+end)/2;
		}
		return result;
	}
	public static void main(String[] agrs) {
		try {
			System.setIn(new FileInputStream("test.txt"));
			Scanner sc=new Scanner(System.in);
			int T=sc.nextInt();
			int n,target;
			for(int i=0;i<T;i++) {
				n=sc.nextInt();
				target=sc.nextInt();
				int[] arr=new int[n];
				for(int j=0;j<n;j++) {
					arr[j]=sc.nextInt();
				}
				System.out.println(search(arr, target));
			}
		
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
