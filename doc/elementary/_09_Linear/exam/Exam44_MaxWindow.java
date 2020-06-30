package org.lanqiao.algo.elementary._09_Linear.exam;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Exam44_MaxWindow
 -----
 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右滑动一个位置。

 例如，数组为[4,3,5,4,3,3,6,7]，窗口大小为3时：依次出现的窗口为[4,3,5], [3,5,4], [5,4,3], [4,3,3], [3,3,6], [3,6,7]。

 如果数组长度是n，窗口大小是w，则一共产生n-w+1个窗口。

 输入
 ----
 第一行 n 和 w，空格隔开，n为数组长度，w为窗口宽度
 第二行为n个整数，作为数组元素，空格隔开

 输出
 ----
 n-w+1个数，每个数是对应窗口中的最大值。

 例如上面的例子，应该返回[5,5,5,4,6,7]。

 样例输入
 -----
 8 3
 4 3 5 4 3 3 6 7

 样例输出
 ----
 5 5 5 4 6 7
 */
public class Exam44_MaxWindow {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      int n = sc.nextInt();
      int w = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      deal(n, w, arr);
    }
  }

  private static void deal(int n, int w, int[] arr) {
    Deque<Integer> q = new LinkedList<Integer>();
    for (int i = 0; i < n; i++) {
      int x = arr[i];
      if (q.isEmpty()) {
        q.addLast(i);
      } else {
        if (arr[q.getLast()] > x) {//队尾较大，直接放入
          q.addLast(i);
        } else {
          while (!q.isEmpty() && arr[q.getLast()] <= x) {
            q.removeLast();
          }
          q.addLast(i);
        }
      }
      if (i >= w - 1) {
        Integer fIndex = q.getFirst();
        // System.out.println(fIndex);
        if (fIndex >= i - (w - 1)) {
          System.out.print(arr[fIndex] + " ");
        } else {
          while (fIndex < i - (w - 1)) {
            q.removeFirst();
            fIndex = q.getFirst();
          }
          System.out.print(arr[fIndex] + " ");

        }
      }
    }
  }
}
