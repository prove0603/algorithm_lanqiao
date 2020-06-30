package org.lanqiao.algo.elementary._04matrix.exam;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述
 给定一个NxN的整数矩阵，小Hi每次操作可以选择两列，将这两列中的所有数变成它的相反数。

 小Hi可以进行任意次操作，他的目标是使矩阵中所有数的和尽量大。你能求出最大可能的和吗？

 输入
 第一行一个整数N。

 以下N行，每行N个整数Aij。

 对于30%的数据，2 ≤ N ≤ 10

 对于100%的数据，2 ≤ N ≤ 200， -1000 ≤ Aij ≤ 1000

 输出
 最大可能的和
 *
 * */
public class Hiho1615矩阵游戏2 {

  private static int[] sums;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sums = new int[N];
    int[][] A = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        A[i][j] = sc.nextInt();
        sums[j] += A[i][j];
      }
      // A[i] = Util.getRandomArr(N, 1, 1000);
    }
    solve(A, N);
  }

  private static void solve(int[][] A, int N) {
    Arrays.sort(sums);
    int res = 0;
    for (int i = 0; i < N; i += 2) {
      if ((i + 1) == N) {

        res += sums[i];

        break;
      }

      if ((sums[i] + sums[i + 1]) >= 0) {
        res += (sums[i] + sums[i + 1]);
      } else {
        res -= (sums[i] + sums[i + 1]);
      }
    }
    System.out.println(res);
  }

}
