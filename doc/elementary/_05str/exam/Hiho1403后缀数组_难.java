package org.lanqiao.algo.elementary._05str.exam;

import java.util.Arrays;
import java.util.Scanner;


/**
 时间限制:5000ms
 单点时限:1000ms
 内存限制:256MB
 描述
 小Hi平时的一大兴趣爱好就是演奏钢琴。我们知道一个音乐旋律被表示为长度为 N 的数构成的数列。

 小Hi在练习过很多曲子以后发现很多作品自身包含一样的旋律。旋律是一段连续的数列，相似的旋律在原数列可重叠。
 比如在1 2 3 2 3 2 1 中 2 3 2 出现了两次。

 小Hi想知道一段旋律中出现次数至少为K次的旋律最长是多少？

 解题方法提示

 输入
 第一行两个整数 N和K。1≤N≤20000 1≤K≤N

 接下来有 N 个整数，表示每个音的数字。1≤数字≤100

 输出
 一行一个整数，表示答案。
 */
public class Hiho1403后缀数组_难 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(sc.nextInt());
    }
    String src = sb.toString();
    long now = System.currentTimeMillis();
    int res = solve(src, K);
    System.out.println(res);
    System.out.println(System.currentTimeMillis()-now);
  }
  //必须重复k次以上,求重叠串的长度
  public static int solve(String src, int k) {
    Suff[] sa = SuffixArray.getSa2(src);
    int[] height = SuffixArray.getHeight(src, sa);
    // System.out.println(Arrays.toString(height));
    //找k-1个连续的
    int l = 0;int r = src.length()-1;
    int ans=0;
    while(l<=r){
      int mid = l+((r-l)>>1);
      if (check(height,k-1,mid)){
        l=mid+1;
        ans=mid;
      }else {
        r=mid-1;
      }
    }
    return ans;
  }

  private static boolean check(int[] height, int k, int len) {
    int cnt=0;
    for(int i=1;i<height.length;i++)
    {
      if(height[i]>=len)
      {
        cnt++;
        if(cnt>=k) return true;
      }
      else cnt=0;
    }
    return false;
  }

  private  static class SuffixArray {
    public static void main(String[] args) {
      String src = "abcabc";
      int[] height = getHeight(src,getSa2(src));
    }
    public static int[] getHeight(String src,Suff[] sa) {
      // Suff[] sa =getSa2(src);
      int strLength = src.length();
      int[] rk = new int[strLength];
      for (int i = 0; i < strLength; i++) {
        rk[sa[i].index] = i;
      }
      int[] height = new int[strLength];
      // 如果已经知道后缀数组中i与i+1的lcp为h，那么i代表的字符串与i+1代表的字符串去掉首字母后的lcp为h-1.
      // 根据这个我们可以发现，如果知道i与后缀数组中在它后一个的lcp为k，那么它去掉首字母后的字符串与其在后缀数组中的后一个的lcp大于等于k-1.
      // 例如对于字符串abcefabc，我们知道abcefabc与abc的lcp为3.
      //     那么bcefabc与bc的lcp大于等于3-1.
      // 利用这一点就可以O(n)求出高度数组。
      int k = 0;
      for (int i = 0; i < strLength; i++) {
        int rankOfSuffI = rk[i];//i后缀的排名
        if (rankOfSuffI==0){
          height[0]=0;
          continue;
        }
        int rankOfPre = rankOfSuffI - 1;
        int indexOfPre = sa[rankOfPre].index;//j是i串字典序靠前的串的下标
        if (k > 0) k--;
        for (; indexOfPre + k < strLength && i + k < strLength; k++) {
          if (src.charAt(indexOfPre + k) != src.charAt(i + k))
            break;
        }
        height[rankOfSuffI] = k;
      }
      return height;
    }


    /**
     * nlg²n  构建后缀数组
     * @param src
     * @return
     */
    public static Suff[] getSa2(String src) {
      int n = src.length();
      Suff[] sa = new Suff[n];
      for (int i = 0; i < n; i++) {
        sa[i] = new Suff(src.charAt(i), i);//存单个字符,接下来排序
      }
      Arrays.sort(sa);

      /**rk是下标到排名的映射*/
      int[] rk = new int[n];//suffix array
      rk[sa[0].index] = 1;
      for (int i = 1; i < n; i++) {
        rk[sa[i].index] = rk[sa[i - 1].index];
        if (sa[i].c != sa[i - 1].c) rk[sa[i].index]++;
      }

      for (int k = 2; rk[sa[n - 1].index] < n; k *= 2) {

        final int kk = k;
        Arrays.sort(sa, (o1, o2) -> {
          //不是基于字符串比较,而是利用之前的rank
          int i = o1.index;
          int j = o2.index;
          if (rk[i] == rk[j]) {//如果第一关键字相同
            if (i + kk / 2 >= n || j + kk / 2 >= n)
              return -(i - j);//如果某个后缀不具有第二关键字,那肯定较小,索引靠后的更小
            return rk[i + kk / 2] - rk[j + kk / 2];

          } else {
            return rk[i] - rk[j];
          }
        });
      /*---排序 end---*/
        // 更新rank
        rk[sa[0].index] = 1;
        for (int i = 1; i < n; i++) {
          int i1 = sa[i].index;
          int i2 = sa[i - 1].index;
          rk[i1] = rk[i2];
          try {
            if (!src.substring(i1, i1 + kk).equals(src.substring(i2, i2 + kk)))
              rk[i1]++;
          } catch (Exception e) {
            rk[i1]++;
          }
        }
      }

      return sa;
    }
  }
  private static class Suff implements Comparable<Suff> {
    public char c;//后缀内容
    public int index;//后缀的起始下标

    public Suff(char c, int index) {
      this.c = c;
      this.index = index;
    }

    @Override
    public int compareTo(Suff o2) {
      return this.c - o2.c;
    }

    @Override
    public String toString() {
      return "Suff{" +
          "char='" + c + '\'' +
          ", index=" + index +
          '}';
    }
  }

}