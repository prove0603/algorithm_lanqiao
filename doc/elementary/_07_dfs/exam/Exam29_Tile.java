package org.lanqiao.algo.elementary._07_dfs.exam;

import java.util.Scanner;

/**
 * 有一长度为N(1<=Ｎ<=1000)的地板，给定两种不同瓷砖：一种长度为1，另一种长度为2，数目不限。
 * 要将这个长度为N的地板铺满，一共有多少种不同的铺法？
 *
 * 结果mod 1000000007
 */
public class Exam29_Tile {
  public static int f(int n) {
    if (n < 0) return 0;
    if (n == 0 || n == 1) return 1;
    if (n == 2) return 2;
    int x1 = 1;
    int x2 = 2;
    for (int i = 3; i <= n; i++) {
      int x_1 = x1;
      x1 = x2;
      x2 = (x1%1000000007 + x_1%1000000007)%1000000007;
    }
    return x2;
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    System.out.println(f(N));
  }
}
