package javaSVMCTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anagrams {
public void calculateString(String s, int[] arr) {
	for(char c:s.toCharArray()) {
		arr[c-'a']++;
	}

}
public boolean equalString(int[] s,int[] p) {
	for(int i=0;i<26;i++) {
		if(s[i]!=p[i]) {
			return false;
		}
	}
	return true;
}
 public List<Integer> findAnagram(String s,String p){
	 List<Integer> AnagramIndex=new ArrayList<>();
	int[] charInp=new int[26];
	calculateString(p, charInp);
	int len1=s.length();
	int len2=p.length();
	for(int i=0;i<len1&& i+len2<=len1;i++) {
		String sub=s.substring(i, i+len2);
		System.out.println(sub);
		int[] charIn=new int[26];
		calculateString(sub, charIn);
		if(equalString(charIn, charInp)) {
			AnagramIndex.add(i);
			System.out.println(i);
		}
		
	}
	 return AnagramIndex;
 }
 public static void main(String[] args) {
	 File test=new File("./test.txt");
	 Anagrams anagrams=new Anagrams();
	 try {
		Scanner sc=new Scanner(test);
		int testnumber=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<testnumber;i++) {
			String line=sc.nextLine();
			String[] split=line.split(" ");
			System.out.println(split[0]);
			System.out.println(split[1]);
			System.out.println("______________________________");
			List<Integer> result=anagrams.findAnagram(split[0], split[1]);
			System.out.print("# ");
			for(int j=0;j<result.size();j++) {
				System.out.print(result.get(j)+" ");
			}
			System.out.println(" ");
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}
