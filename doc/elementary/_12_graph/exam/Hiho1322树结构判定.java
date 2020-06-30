package org.lanqiao.algo.elementary._12_graph.exam;

import java.util.Scanner;

public class Hiho1322树结构判定 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      if (m != n - 1) {
        System.out.println("NO");
        continue;
      }
      int[][] graph = new int[n][n];
      visit = new int[n];
      cnt = 0;
      for (int j = 0; j < m; j++) {
        int x = sc.nextInt() - 1;
        int y = sc.nextInt() - 1;
        graph[x][y] = 1;
        graph[y][x] = 1;
      }
      boolean res = isTree(graph, n);
      if (res) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

  static int[] visit;
  static int cnt;

  private static boolean isTree(int[][] graph, int n) {
    dfs(graph, n, 0);
    visit[0] = 1;
    for (int v : visit
        ) {
      if (v == 0) return false;
    }
    return true;
  }

  private static void dfs(int[][] graph, int n, int k) {
    for (int j = 0; j < n; j++) {
      if (graph[k][j] == 1 && visit[j] == 0) {
        visit[j] = 1;
        dfs(graph, n, j);
      }
    }
  }

}

