package org.lanqiao.algo.elementary._07_dfs.exam;
/*
Exam30_Change
-----
公园票价为5角。假设每位游客只持有两种币值的货币：5角、1元。

再假设持有5角的有m人，持有1元的有n人。

由于特殊情况，开始的时候，售票员没有零钱可找。

我们想知道这m+n名游客以什么样的顺序购票则可以顺利完成购票过程。

显然，m < n的时候，无论如何都不能完成； m>=n的时候，有些情况也不行。

比如，第一个购票的乘客就持有1元。

请计算出这m+n名游客所有可能顺利完成购票的不同情况的组合数目。

注意：只关心5角和1元交替出现的次序的不同排列，持有同样币值的两名游客交换位置并不算做一种新的情况来计数。

输入
----
一行:整数m和n,空格隔开。(m+n<=20)


输出
----
组合数目

样例输入
-----
5 5

样例输出
----
42
*/

import java.util.Scanner;

public class Exam30_Change {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      //long now = System.currentTimeMillis();
      final int i = f(m, n);
      System.out.println(i);
      //System.out.println(System.currentTimeMillis() - now);
    }
  }


  /**
   * 分解为在当前选5毛或者一元*/
  private static int f(int m, int n) {
    if (m < n) return 0;
    if (n == 0) return 1;
    return f(m - 1, n) + f(m, n - 1);
  }




}
