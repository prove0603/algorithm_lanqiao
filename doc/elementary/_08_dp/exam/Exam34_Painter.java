package org.lanqiao.algo.elementary._08_dp.exam;

import java.util.Arrays;
import java.util.Scanner;

/*
杂货店出售一种由N（3<=N<=12）种不同颜色的颜料，每种一瓶（50ML），组成的颜料套装。

你现在需要使用这N种颜料；不但如此，你还需要一定数量的灰色颜料。

杂货店从来不出售灰色颜料——也就是它不属于这N种之一。幸运的是，灰色颜料是比较好配置的，如果你取出三种不同颜色的颜料各x ml，
混合起来就可以得到xml的灰色颜料（注意不是3x）。

现在，你知道每种颜料各需要多少ml。你决定买尽可能少的“颜料套装”，来满足你需要的这N+1种颜料。

那么你最少需要买多少个套装呢？

Input

输入包含若干组测试数据。每组数据一行：第一个数N, 3<=N<=12, 含义如上；

接下来N+1个数，分别表示你需要的N+1种颜料的毫升数。最后一种是灰色。所有输入的毫升数<=1000.

注意：输入中不存在每个颜料套装的毫升数。由题意可知，每种各50ml，即一共50N ml

Output

每组数据输出一行，最少需要的套装数。

Sample Input

3 40 95 21 0
7 25 60 400 250 0 60 0 500
4 90 95 75 95 10
5 0 0 0 0 0 333
0

Sample Output

2
8
2
4
 */
public class Exam34_Painter {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int N = sc.nextInt();
      if (N==0)break;
      int[] req = new int[N + 1];
      for (int i = 0; i < N + 1; i++) {
        req[i] = sc.nextInt();
      }
      int res = f(req, N + 1);
      System.out.println(res);
    }
  }

  static int f(int[] req, final int N) {
    Arrays.sort(req, 0, N - 1);
    int x = req[N - 2] % 50 == 0 ? req[N - 2] / 50 : req[N - 2] / 50 + 1;//需求最大的颜料量/50,是我们起码需要的套数
    if (req[N - 1] == 0) {//如果不需要灰色的,直接返回即可
      return x;
    }else{//多出的颜料能凑出灰色颜料  或者 凑不出来
      int[] b = new int[N-1];
      for (int i = 0; i < N-1; i++) {
        b[N-2-i] = x*50-req[i];
      }
      return x+f1(b,req[N-1]);
    }
  }
  static int f1(int[] b, int k){//b保持升序
    int res = 0;
    int last_1 = b.length - 1;
    int last_2 = b.length - 2;
    int last_3 = b.length - 3;
    //余额最大的三个,每个扣1,k扣1,重新排序
    while(b[last_1]>0&&b[last_2]>0&&b[last_3]>0){
      b[last_1]--;
      b[last_2]--;
      b[last_3]--;
      k--;
      if (k==0)break;
      Arrays.sort(b);
    }
    if (k>0){//k还大于0,就必须再采购一套
      res++;
      for (int i = 0; i < b.length; i++) {//每种颜色+50ml
        b[i]+=50;
      }
      res+=f1(b,k);
    }
    return res;
  }


}
