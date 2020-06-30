package org.lanqiao.algo.elementary._06_math.exam;

import java.util.Scanner;

public class Hiho1303 {
  long gcd(long a, long b)                 //讲道理扩展欧几里德是可以求gcd的，但是呢这题分开写也没关系
  {
    if (a % b == 0)
      return b;
    return gcd(b, a % b);
  }

  long x;
  long y;

  void e_gcd(long A, long B)  //要求gcd咱可以稍稍改一下  void e_gcd(long A,long B,long &x,long &y,long gcd)
  {
    if (B == 0) {
      x = 1;
      y = 0;               //然后在个if语句中再加一句  gcd=A;就OK了
      return;
    }
    e_gcd(B, A % B);
    long temp = y;
    y = x - (A / B) * y;
    x = temp;
  }

  long china(long[] m, long[] r, int N) {
    long M = m[1], R = r[1];
    for (int i = 2; i <= N; i++) {
      long d = gcd(M, m[i]);
      long c = r[i] - R;
      if (c % d != 0)
        return -1;
      e_gcd(M / d, m[i] / d);
      x = (c / d * x) % (m[i] / d);
      R += x * M;
      M = M / d * m[i];
      R %= M;
    }
    while (R < 0)
      R += M;
    return R;

  }
  // int main()
  // {
  //   while(~scanf("%d",&N))
  //   {
  //     for(int i=1;i<=N;i++)
  //       scanf("%longd%longd",&m[i],&r[i]);
  //     printf("%longd\n",china());
  //   }
  //   return 0;
  // }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    long[] m = new long[N + 1];
    long[] r = new long[N + 1];
    for (int i = 1; i <= N; i++) {
      m[i] = sc.nextInt();
      r[i] = sc.nextInt();
    }

    long china = new Hiho1303().china(m, r, N);
    System.out.println(china);
  }

}
