package javaSVMCTest.ListNode;

public class ListNode {
	int val;
	ListNode next;
	public ListNode(int val, ListNode next) {
		super();
		this.val = val;
		this.next = next;
	}
	public ListNode() {}
	public ListNode(int value) {
		this.val=value;
	}
	public String toString() {
		String s=val+" ";
		if(next!=null) {
			s=s+next.toString();
			
		}
		return s;
	}
}
