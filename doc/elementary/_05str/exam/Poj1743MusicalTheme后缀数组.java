package org.lanqiao.algo.elementary._05str.exam;

import org.lanqiao.algo.elementary._05str.Match03_SuffixArray;

/**
 * 题意：有N(1 <= N <=20000)个音符的序列来表示一首乐曲，每个音符都是1..88范围内的整数，
 * 现在要找一个重复的主题。
 * “主题”是整个音符序列的一个子串，它需要满足如下条件：

 1.长度至少为5个音符。

 2.在乐曲中重复出现。(可能经过转调，“转调”的意思是主题序列中每个音符都被加上或减去了同一个整数值)

 3.重复出现的同一主题不能有公共部分。


 思路：这是论文里一道题，那么我们通过进行二分来求论文里的k值，求出height[i]大于k的时候，
 然后求出这个区间里面起始位置最大的差值，要求差值也要大于k，
 这样才保证没有重叠，这是因为height里的都是已经按照字典序排好的了
 */
public class Poj1743MusicalTheme后缀数组 {
  public static void main(String[] args) {
    String src = "1212121565678912121";
    // Match03_SuffixArray.getLcpArray(src);
    int strLength = src.length();
    int[] height = new int[strLength];
    height[0] = 0;
    Match03_SuffixArray.Suff[] sa = Match03_SuffixArray.getSa2(src);
    // for (int i = 1; i < height.length; i++) {
    //   height[i] = Match03_SuffixArray.lengthOfLcp(sa[i].str, sa[i - 1].str);
    // }
    int max = 4;
    int index1 = -1, index2 = -1;
    for (int i = 0; i < strLength; i++) {
      if (height[i] > max) {
        int indexOfI = sa[i].index;
        int indexOfI_1 = sa[i - 1].index;
        if (Math.abs(indexOfI - indexOfI_1) >= 5) {
          max = height[i];
          index1 = indexOfI;
          index2 = indexOfI_1;
        }
      }
    }
    System.out.println(max + "***" + index1 + "~" + index2);
  }

  /*变调?
  *  2.在乐曲中重复出现。(可能经过转调，“转调”的意思是主题序列中每个音符都被加上或减去了同一个整数值)
  *  */
  private static int lengthOfLcp(String s1, String s2) {
    //预处理前后字符的差值
    int[] s1Plus = new int[s1.length()];
    int[] s2Plus = new int[s2.length()];
    for (int i = 1; i < s1.length(); i++) {
      s1Plus[i] = s1.charAt(i) - s1.charAt(i - 1);
    }
    for (int i = 1; i < s2.length(); i++) {
      s2Plus[i] = s2.charAt(i) - s2.charAt(i - 1);
    }
    int p1 = 1, p2 = 1;
    int res = 0;
    while (p1 < s1Plus.length && p2 < s2Plus.length) {
      if (s1Plus[p1] == s2Plus[p2]) {
        res++;
        p1++;
        p2++;
      } else {
        break;
      }
    }
    if (res==0&&s1.charAt(0)==s2.charAt(0))return 1;
    if (res>0)return res+1;
    return 0;
  }
}
