package org.lanqiao.algo.elementary._07_dfs.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 今盒子里有 n个小球，A 、B两人轮流从盒中取球，每个人都可以看到另一个人取了多少个，
 也可以看到盒中还剩下多少个，并且两人都很聪明，不会做出错误的判断。
 我们约定：
 每个人从盒子中取出的球的数目必须是： 1，3 ，7或者 8个。
 轮到某一方取球时不能弃权！
 A先取球，然后双方交替取球，直到取完。
 被迫拿到最后一个球的一方为负方（输方）
 请编程确定出在双方都不判断失误的情况下，对于特定的初始球数， A是否能赢？
 程序运行时，从标准输入获得数据，其格式如下：
 先是一个整数 n(n<100)，表示接下来有n个整数。然后是 n个整数，每个占一行（整数 <10000），
 表示初始球数。
 程序则输出 n行，表示A 的输赢情况（输为 0，赢为1 ）。
 例如，用户输入：
 4
 1
 2
 10
 18
 则程序应该输出：
 0
 1
 1
 0
 */

public class Exam33_FetchBall {
  static Map<Integer, Boolean> cache = new HashMap<>();

  /**
   * @param n  代表当前所剩球的个数
   *           @return true：我方赢
   */

  static boolean pick2(int n) {
    //对方拿完了，我就赢了
    if (n == 0)
      return true;
    if (cache.get(n) != null)
      return cache.get(n);
    //大于1，我取1，剩下局面（n-1）对方输，则我方赢
    if (n >= 1 && !pick2(n - 1)) {
      cache.put(n, true);
      return true;
    }
    if (n >= 3 && !pick2(n - 3)) {
      cache.put(n, true);
      return true;
    }
    if (n >= 7 && !pick2(n - 7)) {
      cache.put(n, true);
      return true;
    }
    if (n >= 8 && !pick2(n - 8)) {
      cache.put(n, true);
      return true;
    }
    cache.put(n, false);
    return false;
  }

  public static boolean dfs(int n) {
    if (n == 0)
      return true;
    if (n >= 1 && !dfs(n - 1))
      return true;
    if (n >= 3 && !dfs(n - 3))
      return true;
    if (n >= 7 && !dfs(n - 7))
      return true;
    if (n >= 8 && !dfs(n - 8))
      return true;
    return false;
  }

  public static boolean pick(int n) {
    if (n <= 0)
      return false;
    boolean[] state = new boolean[n + 1];
    state[1] = false;

    for (int i = 2; i <= n; i++) {
      boolean flag3;
      if (i - 3 <= 0)
        flag3 = false;
      else
        flag3 = !state[i - 3];

      boolean flag7;
      if (i - 7 <= 0)
        flag7 = false;
      else
        flag7 = !state[i - 7];

      boolean flag8;
      if (i - 8 <= 0)
        flag8 = false;
      else
        flag8 = !state[i - 8];
      //这就是递推式对应的代码
      state[i] = !state[i - 1] || flag3 || flag7 || flag8;
    }
    return state[n];
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] x = new int[n];
    for (int i = 0; i < x.length; i++) {
      x[i] = scan.nextInt();
    }
    scan.close();
    for (int i = 0; i < x.length; i++) {
      System.out.println(pick(x[i]) ? 1 : 0);
    }
  }
}

