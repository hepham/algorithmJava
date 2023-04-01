package javaSVMCTest.ListNode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class ReverseLinkedList {
	public static ListNode reverseList(ListNode head) {
		ListNode result=null;
		while(head!=null) {
			ListNode next=head.next;
	        head.next=result;
	        result=head;
	        head=next;
		}
		return result;
	}
public static void main(String[] agrs) {
	InputStream stream;
	try {
		stream = new FileInputStream("test.txt");
		System.setIn(stream);
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int i, j, k, m, n;
		String s;
		for (i = 0; i < T; i++) {
			ListNode t = new ListNode(-1);
			ListNode u = new ListNode(-1);
			ListNode l1 = t;
			ListNode l2 = u;
			m = scanner.nextInt();
			n = scanner.nextInt();
			for (j = 0; j < m; j++) {
				int val = scanner.nextInt();
				l1.next = new ListNode(val);
				l1 = l1.next;
			}
			
	
			for (j = 0; j < n; j++) {
				int val = scanner.nextInt();
				l2.next = new ListNode(val);
				l2 = l2.next;
			}
			ListNode result = new ListNode();
			result = reverseList(t.next);
			s=result.toString();
			System.out.println("#"+i+": "+s);
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
