package org.lanqiao.algo.elementary._03sort.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Exam17_NewOrder
 -----
 一般我们在对字符串排序时，都会按照字典序排序。当字符串只包含小写字母时，相当于按字母表"abcdefghijklmnopqrstuvwxyz"的顺序排序。

 现在我们打乱字母表的顺序，得到一个26个字母的新顺序:bdceafghijklmnopqrstuvwxyz，代表'b'排在'd'前，'d'在'c'前，'c'在'e'前……

 给定N个字符串，请你按照新的字母顺序对它们排序。

 输入
 ----
 第一行：N(1<N<=100)，代表数组的长度
 第二行：N个字符串，作为数组的元素，空格分开

 输出
 ----
 字典序最大的大字符串
 */
public class Exam17_NewOrder {
  public static void main(String[] args) {
    // System.out.println(Integer.toBinaryString((-27)^(-1)));
    // String order = "bdceafghijklmnopqrstuvwxyz";
    int N = readInt();
    String order = readStr();
    String[] arr = new String[N];
    for (int i = 0; i < N; i++) {
      arr[i] = readStr();
    }
    solve(arr, order);
  }

  public static void solve(String[] arr, String order) {
    int[] orderTable = new int[26];
    for (int i = 0; i < order.length(); i++) {
      int i1 = order.charAt(i) - 'a';
      orderTable[i1] = i;
    }
    Arrays.sort(arr, (o1, o2) -> {
      if (o1.equals(o2)) return 0;
      // char[]a1 = o1.toCharArray();
      // char[]a2 = o2.toCharArray();
      int p1 = 0;
      int p2 = 0;
      while (p1 < o1.length() && p2 < o2.length()) {
        if (orderTable[o1.charAt(p1) - 'a'] < orderTable[o2.charAt(p2) - 'a']) return -1;
        else if (orderTable[o1.charAt(p1) - 'a'] == orderTable[o2.charAt(p2) - 'a']) {
          p1++;
          p2++;
        } else return 1;
      }
      if (p1 == o1.length()) return -1;
      if (p2 == o2.length()) return 1;

      return 0;
    });
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  private static String readStr() {
    return sc.next();
  }

  static Scanner sc = new Scanner(System.in);

  private static int readInt() {
    return sc.nextInt();
  }
}
