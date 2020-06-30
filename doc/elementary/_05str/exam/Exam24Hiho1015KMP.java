package org.lanqiao.algo.elementary._05str.exam;

import java.util.Scanner;

public class Exam24Hiho1015KMP {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    sc.nextLine();
    String[] pArr = new String[N];
    String[] sArr = new String[N];
    for (int i = 0; i < N; i++) {
      pArr[i] = sc.nextLine();
      sArr[i] = sc.nextLine();
    }
    for (int i = 0; i < N; i++) {
      System.out.println(indexOf1(sArr[i], pArr[i]));
    }
  }

  private static int indexOf1(String s, String p) {
    if (s.length() == 0 || p.length() == 0) return 0;
    if (p.length() > s.length()) return 0;
    int[] next = next(p);
    int i = 0;//s位置
    int j = 0;//p位置
    int sLen = s.length();
    int pLen = p.length();
    int res = 0;
    while (i < sLen) {
      //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
      //j=-1，因为next[0]=-1,说明p的第一位和i这个位置无法匹配，这时i，j都增加1，i移位，j从0开始
      if (j == -1 || s.charAt(i) == p.charAt(j)) {
        i++;
        j++;
      } else {
        //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
        //next[j]即为j所对应的next值
        j = next[j];
      }
      if (j == pLen) {
        res++;
        j = next[j - 1];
        i--;
      }
    }
    return res;
  }

  private static int[] next(String ps) {
    int pLength = ps.length();
    int[] next = new int[pLength];
    char[] p = ps.toCharArray();
    next[0] = -1;
    if (ps.length() == 1) return next;
    next[1] = 0;
    int j = 1;
    int k = next[j];//看看位置j的最长匹配前缀在哪里
    while (j < pLength - 1) {
      //现在要推出next[j+1],检查j和k位置上的关系即可
      if (k < 0 || p[j] == p[k]) {
        next[++j] = ++k;
      } else {
        k = next[k];
      }
    }
    return next;
  }

}
