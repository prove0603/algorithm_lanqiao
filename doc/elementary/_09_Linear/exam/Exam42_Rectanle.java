package org.lanqiao.algo.elementary._09_Linear.exam;

import java.util.Scanner;
import java.util.Stack;

public class Exam42_Rectanle {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] arr = sc.nextLine().split(" ");
    int b[] = new int[Integer.valueOf(arr[0])];
    for (int i = 1, j = 0; j < b.length; i++, j++) {
      b[j] = Integer.valueOf(arr[i]);
    }

    System.out.println(f(b));
  }


  static long f(int[] height) {
    if (height == null || height.length == 0)
      return 0;
    long max = 0;
    //栈-由小到大排
    Stack<Integer> st = new Stack();
    //遍历数组，当发现比前一个元素小的弹出
    for (int i = 0; i < height.length; i++) {
      while (!st.isEmpty() && height[i] <= height[st.peek()]) {
        //弹出栈顶元素，开始计算
        int j = st.pop();
        long k = st.isEmpty() ? -1 : st.peek();
        long cutArea = (i - k - 1) * height[j];
        //max保持最大值
        max = Math.max(max, cutArea);
      }
      st.push(i);//加入栈，保证栈由小到大排
    }
    //数组遍历完，栈从顶弹出
    while (!st.isEmpty()) {
      int j = st.pop();
      long k = st.isEmpty() ? -1 : st.peek();
      long cutArea = (height.length - k - 1) * height[j];
      max = Math.max(max, cutArea);
    }

    return max;
  }

}