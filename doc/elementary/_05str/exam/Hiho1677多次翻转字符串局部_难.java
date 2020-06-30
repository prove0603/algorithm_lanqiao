package org.lanqiao.algo.elementary._05str.exam;

import java.util.Scanner;

/**
 * 多次翻转字符串局部
 */
public class Hiho1677多次翻转字符串局部_难 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String src = sc.nextLine();
    StringBuilder ssb = new StringBuilder(src);
    int k = sc.nextInt();
    for (int i = 0; i < k; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      reverse(ssb,x,y);
    }
    System.out.println(ssb.toString());
  }

  private static void reverse(StringBuilder src, int x, int y) {
    while (x<=y){
      char tmp = src.charAt(x);
      src.setCharAt(x,src.charAt(y));
      src.setCharAt(y,tmp);
      x++;
      y--;
    }
  }

}
