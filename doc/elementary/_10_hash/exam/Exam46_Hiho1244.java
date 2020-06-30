package org.lanqiao.algo.elementary._10_hash.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * MX正在学习哈希表的姿势。他的哈希表有m个槽，从0到m-1标号。一开始每个槽都是空的。
 * 他有n个元素需要插到槽里，元素从0到n-1编号。

 MX的哈希函数是h(x)=x2 mod m，也就是说i号元素会被插入到(i2 mod m)号槽里。

 由于MX的哈希表实现比较奇特，在一个槽中插入一个元素的花费是T，其中T是这个槽中已经有的元素数量。

 MX想知道把这n个元素依次插入表中需要的总花费是多少。

 输入
 第一行一个整数t(1≤t≤5)，表示询问数量。

 接下来t行，每行两个整数n,m(1≤n≤109,2≤m≤109)。

 输出
 输出t行，每行一个整数作为答案。
 */
public class Exam46_Hiho1244 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    long res = 0;
    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      Map<Long,Long> map = new HashMap<Long,Long>(m);

      for (long j = 0; j<n; j++) {
        long index =j*j%m;//取模
        long res1 =0;
        if (map.containsKey(index))
          res1=map.get(index);
        res += res1;
        map.put(index,res+1);
      }
    }
    System.out.println(res);
  }

}
