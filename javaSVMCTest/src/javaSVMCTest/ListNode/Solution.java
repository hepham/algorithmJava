package javaSVMCTest.ListNode;

import java.io.*;
import java.util.Scanner;

public class Solution {

  public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
    ListNode pre = new ListNode(-1);
    ListNode result = pre;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        result.next = l1;
        l1 = l1.next;
      } else {
        result.next = l2;
        l2 = l2.next;
      }
      result = result.next;
    }

    if (l1 != null) {
      result.next = l1;
    }
    if (l2 != null) {
      result.next = l2;
    }

    return pre.next;
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
        result = mergeTwoList(t.next, u.next);
        s = result.toString();
        System.out.println("#" + i + ": " + s);
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
