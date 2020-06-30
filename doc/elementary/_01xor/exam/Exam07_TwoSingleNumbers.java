package org.lanqiao.algo.elementary._01xor.exam;

import java.util.Scanner;

public class Exam07_TwoSingleNumbers {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int[] arr = new int[N];
    int xorOfResult = 0;
    for (int i = 0; i < N; i++) {
      arr[i] = scanner.nextInt();
      xorOfResult ^= arr[i];
    }

    int indexOf1 = 0;
    while (true) {
      if ((xorOfResult & (1 << indexOf1)) == (1 << indexOf1)) {
        break;
      }
      indexOf1++;
    }
    int res1 = 0;
    int res2 = 0;
    for (int i = 0; i < N; i++) {
      if ((arr[i] & (1 << indexOf1)) == (1 << indexOf1)) {
        res1 ^= arr[i];
      } else
        res2 ^= arr[i];
    }
    System.out.println(Math.min(res1, res2) + " " + Math.max(res1, res2));
  }
}
