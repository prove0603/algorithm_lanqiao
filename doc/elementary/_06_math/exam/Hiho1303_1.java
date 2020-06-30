package org.lanqiao.algo.elementary._06_math.exam;

import java.util.Scanner;

public class Hiho1303_1 {
  static long x;
  static long y;


  /**
   * 扩展欧几里得
   * 调用完成后xy是ax+by=gcd(a,b)的解*/
  public static long ext_gcd(long A, long B) {

    if (B == 0) {
      x = 1;
      y = 0;               //然后在个if语句中再加一句  gcd=A;就OK了
      return A;
    }
    long d = ext_gcd(B, A % B);
    long temp = y;
    y = x - (A / B) * y;
    x = temp;
    return d;
  }


  /**
   * x = a1(%m1)
   *   = a2(%m2)
   *   = a3(%m3)
   *  x = a1+m1k1 (1)
   *  x = a2+m2k2
   *  ==> m1k1 - m2k2 = a2 - a1这是一个线性方程,可解出k1 <--- linearEquation(m1,-m2,a2-a1)
   *  带回(1),得特解x0 = a1+m1*k1 --> 解系 x =x0 + k*lcm(m1,m2) 得一个新方程 x = x0 (mod lcm(m1,m2))
   *  */
  public static long linearEquationGroup(long[] r, long[] m) {
    int len = r.length;
    if (len == 0 && r[0] == 0) return -1;
    long R = r[0];
    long M = m[0];
    for (int i = 1; i < len; i++) {
      //这里往前看是两个方程
      long c = r[i] - R;
      long d = ext_gcd(M, m[i]);
      if (c % d != 0) return -1;
      //现在的static x是k1,用k1求得一个特解
      x = (c / d * x) % (m[i] / d);
      // //===============
      long x0 = R + M * x;//特解-》解系：X=x0+k*lcm(m1,m2)->得新方程： X 三 x0 mod lcm
      long lcm = M / d * m[i];//这是新的M
      M = lcm;
      R = x0 % M;//x0变成正数
    }
    //合并完之后,只有一个方程 : X mod M = R
    // while (R < 0)
    //   R += M;
    return (R % M + M) % M;
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    long[] m = new long[N];
    long[] r = new long[N];
    for (int i = 0; i < N; i++) {
      m[i] = sc.nextInt();
      r[i] = sc.nextInt();
    }
    long l = linearEquationGroup(r, m);
    System.out.println(l);
  }

}
