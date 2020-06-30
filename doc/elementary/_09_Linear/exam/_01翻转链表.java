package org.lanqiao.algo.elementary._09_Linear.exam;

import java.util.Scanner;

class Node {
  int value;
  Node next;
}

public class _01翻转链表 {

  private static Node head;


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int n = sc.nextInt();
      if (n == -1) return;
      head = null;
      Node p = null;
      for (int i = 0; i < n; i++) {
        if (head == null) {
          head = new Node();
          p = head;
          head.value = sc.nextInt();
        } else {
          p.next = new Node();
          p.next.value = sc.nextInt();
          p = p.next;
        }
      }
      f(head);
    }
  }

  private static void f(Node p) {
    if (p == null) {
      return;
    }
    f(p.next);
    System.out.print(p.value + " ");
    if (p == head)
      System.out.println();
  }
}
