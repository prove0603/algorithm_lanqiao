package org.lanqiao.algo.elementary._03sort.exam;

import java.util.Arrays;
import java.util.Scanner;

public class Exam16_CombineString {
  public static void main(String[] args) {
    System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    String[] arr = new String[N];
    for (int i = 0; i < N; i++) {
      arr[i] = sc.next();
    }
    solve(arr, N);
  }

  public static void solve(String[] arr, int n) {
    //自定义比较规则
    Arrays.sort(arr, (o1, o2) -> {
          int res = (o2 + o1).compareTo(o1 + o2);
      return res;
        }
    );
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      sb.append(arr[i]);
    }
    System.out.println(sb);
  }
}
