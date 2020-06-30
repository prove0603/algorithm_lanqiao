package org.lanqiao.algo.elementary._01xor.exam;

import java.util.Scanner;

public class Exam08_ChangeBit {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
    System.out.println(numOf1(A ^ B));
  }

  private static int numOf1(int x) {
    int count = 0;
    while (x != 0) {
      x = (x - 1) & x;
      count++;
    }
    return count;
  }
}
