package javaSVMCTest;

import java.util.HashMap;
import java.util.Scanner;

public class hashMap {
	public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map=new HashMap<Character,Integer>();
        int result=-1;
        for(char c:s.toCharArray()){
            if(!map.containsKey(c)){
                 map.put(c,1);
            }
            else{
            	map.put(c,map.get(c) +1);
            	}
           
        }
        for(char c:s.toCharArray()) {
        	if(map.get(c)==1) {
        		result=s.indexOf(c);
        		break;
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		System.out.println(hashMap.firstUniqChar(s));
	}
}
