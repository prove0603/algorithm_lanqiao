package org.lanqiao.algo.elementary._05str.exam;

import java.util.Scanner;

/**
 * 描述
 如果一个字符串恰好包含2个'h'、1个'i'和1个'o'，我们就称这个字符串是hiho字符串。

 例如"oihateher"、"hugeinputhugeoutput"都是hiho字符串。

 现在给定一个只包含小写字母的字符串S，小Hi想知道S的所有子串中，最短的hiho字符串是哪个。

 输入
 字符串S

 对于80%的数据，S的长度不超过1000

 对于100%的数据，S的长度不超过100000

 输出
 找到S的所有子串中，最短的hiho字符串是哪个，输出该子串的长度。如果S的子串中没有hiho字符串，输出-1。


 */
public class Exam23_Hiho1485Hiho字符串 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // while (true) {
      String s = sc.nextLine();
      char[] w = s.toCharArray();
      solve2(w);
    // }
  }


  public static void solve2(char[] w) {
    int min = Integer.MAX_VALUE;
    int j = -1;
    for (int i = 0; i < w.length; i++) {
      char c = w[i];
      if (check(c)) {//i停下

        if (j == -1)//j的第一次定位
          j = i + 1;

        while (j < w.length) {
          char c2 = w[j];
          if (check(c2) && containsAll(w, i, j)) {//全部囊括
            if (check(w,i,j)&&j - i + 1 < min) {//更新min
              min = j - i + 1;
            }
            break;//j停下
          }
          j++;//j继续扫描
        }
      }
    }
    System.out.print(min == Integer.MAX_VALUE ? -1 : min);
  }

  /**
   * 检查字符序列是否恰好包含2个h一个i一个o
   * @param w
   * @param i
   * @param j
   * @return
   */
  private static boolean check(char[] w, int i, int j) {
    int c1 = 0, c2 = 0, c3 = 0;
    for (int k = i; k <= j; k++) {
      if (w[k] == 'h') c1++;
      if (w[k] == 'i') c2++;
      if (w[k] == 'o') c3++;
    }
    return c1 == 2 && c2 == 1 && c3 == 1;
  }

  private static boolean check(char c) {
    return c == 'h' || c == 'i' || c == 'o';
  }

  /**
   * w中是否有两个h一个i一个o
   * @param w
   * @param i
   * @param j
   * @return
   */
  private static boolean containsAll(char[] w, int i, int j) {
    int c1 = 0, c2 = 0, c3 = 0;
    for (int k = i; k <= j; k++) {
      if (w[k] == 'h') c1++;
      if (w[k] == 'i') c2++;
      if (w[k] == 'o') c3++;
    }
    return c1 >= 2 && c2 >= 1 && c3 >= 1;
  }


}
