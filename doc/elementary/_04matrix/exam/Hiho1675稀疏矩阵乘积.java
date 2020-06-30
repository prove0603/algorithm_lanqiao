package org.lanqiao.algo.elementary._04matrix.exam;

import java.util.Scanner;

/*时间限制:10000ms
单点时限:1000ms
内存限制:256MB
描述
给定两个N × N的稀疏矩阵A和B，其中矩阵A有P个元素非0，矩阵B有Q个元素非0。请计算两个矩阵的乘积C = A × B并且输出C中所有非0的元素。

输入
第一行包含三个整数N, P, Q

以下P行每行三个整数i, j, k表示A矩阵的一个非0元素：Aij = k

以下Q行每行三个整数i, j, k表示B矩阵的一个非0元素：Bij = k

对于80%的数据，1 ≤ N, P, Q ≤ 200

对于100%的数据, 1 ≤ N, P, Q ≤ 2000, 1 ≤ i, j ≤ N, 0 ≤ k ≤ 100

输出
输出若干行，按先行后列的顺序输出矩阵C的每一个非0元素

每行三个整数i, j, k表示C矩阵的一个非0元素：Cij = k

样例输入
2 2 4
1 1 1
2 2 1
1 1 1
1 2 2
2 1 3
2 2 4
样例输出
1 1 1
1 2 2
2 1 3
2 2 4*/
public class Hiho1675稀疏矩阵乘积 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int P = sc.nextInt();
    int Q = sc.nextInt();
    int[][] A = new int[N][N];
    int[][] res = new int[N][N];
    // int[][]B = new int[N][N];
    for (int i = 0; i < P; i++) {
      int x = sc.nextInt()-1;
      int y = sc.nextInt()-1;
      A[x][y]=sc.nextInt();
    }
    for (int i = 0; i < Q; i++) {
      int x = sc.nextInt()-1;
      int y = sc.nextInt()-1;
      int k = sc.nextInt();
      if (k!=0){
        for (int j = 0; j < N; j++) {
          if (A[j][x]!=0){
            res[j][y]+=A[j][x]*k;
          }
        }
      }

    }
    // Util.printMatrix(res);
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int v = res[i][j];
        if (v !=0){
          System.out.println((i+1)+" "+(j+1)+" "+ v);
        }
      }
    }
  }
}
