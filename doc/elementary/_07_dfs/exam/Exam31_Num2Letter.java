package org.lanqiao.algo.elementary._07_dfs.exam;

import java.util.Scanner;

/*
Exam31_Num2Letter
-----
给定一个字符串str，str全部由数字字符组成，如果str中某一个或者某相邻两个字符组成的子串在1~26之间，则这个子串可以转换为一个字母。

规定“1”转换为“A”，“2”转换为“B”……“26”转换为“Z”。求str有多少种不同的转换结果。



输入
----
字符串str(|str|<20)


输出
----
可转换结果的数目

样例输入
-----
12345678

样例输出
----
3

样例输入
-----
1111

样例输出
----
5
 */
public class Exam31_Num2Letter {

  public static void main(String[] args) {
    // long now = System.currentTimeMillis();
    // int res = dfs("121214531213", 0);
    // System.out.println(res);
    // System.out.println(System.currentTimeMillis()-now);
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    System.out.println(dfs(s,0));
  }

  static int dfs(String A, int cur) {
    int res = 0;
    if (cur >= A.length()) {
      return 1;
    }
    if (A.charAt(cur) != '0') {
      res += (dfs(A, cur + 1));
      if (cur + 2 <= A.length() && Integer.parseInt(A.substring(cur, cur + 2)) <= 26)
        res += dfs(A, cur + 2);
    }
    return res;
  }
}
