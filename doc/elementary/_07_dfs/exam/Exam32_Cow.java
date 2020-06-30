package org.lanqiao.algo.elementary._07_dfs.exam;

import java.util.Scanner;

/*
Exam32_Cow
-----
假设农场中成熟的母牛每年只会生一头小母牛，并且永远不会死。第一年农场有１只成熟的牛，从第二年开始，母牛开始生小母牛。每只小母牛３年之后 成熟又可以生小母牛。

给定整数Ｎ，返回Ｎ年后牛的数量

为防止溢出,请将结果结果mod 1000000007

输入
----
N(1<=N<=1000)


输出
----
N年后N的数量

样例输入
-----
6

样例输出
----
9

 */
public class Exam32_Cow {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // while (true) {
    int n = sc.nextInt();
    int res = f(n);
    System.out.println(res);
    // }
  }

  //1 2 3 4 6 9 13 19
  static int f(int N) {
    if (N == 1) return 1;
    if (N == 2) return 2;
    if (N == 3) return 3;

    int x1 = 1;
    int x2 = 2;
    int x3 = 3;
    for (int i = 4; i <= N; i++) {
      int x_1 = x1;
      x1 = x2;
      x2 = x3;
      x3 = (x2 % 1000000007 + x_1 % 1000000007) % 1000000007;
    }
    return x3;//f(N-1)+f(N-3);
  }
}
