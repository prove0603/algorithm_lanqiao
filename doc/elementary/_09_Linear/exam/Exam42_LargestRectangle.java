package org.lanqiao.algo.elementary._09_Linear.exam;

import java.util.Scanner;
import java.util.Stack;

public class Exam42_LargestRectangle {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num;
    while ((num = sc.nextInt()) != 0) {
      int[]arr=new int[num];
      for (int i = 0; i < num; i++) {
        arr[i]  = sc.nextInt();
      }
      deal(arr);
    }
  }

  //7 2 1 4 5 1 3 3
  private static void deal(int[] nums) {
    Stack<Rectangle> s = new Stack<Rectangle>();
    long area = 0;
    for (int i = 0; i < nums.length; i++) {
      int x = nums[i];
      if (s.isEmpty() || x > s.peek().height) {//栈顶更大
        s.push(new Rectangle(x));
      } else {
        long width = 0;
        while (!s.isEmpty() && s.peek().height >= x) {
          Rectangle pop = s.pop();
          long height = pop.height;//高度
          width += pop.width;
          long _area = height * width;
          if (_area > area) {
            area = _area;
          }
        }
        s.push(new Rectangle(x, width + 1));
      }
    }
    long width = 0;
    while (!s.isEmpty()){
      Rectangle pop = s.pop();
      long height = pop.height;//高度
      width += pop.width;
      long _area = height * width;
      if (_area > area) {
        area = _area;
      }
    }
    System.out.println(area);
  }

  private static class Rectangle {
    long height;
    long width = 1;

    public Rectangle(int height) {
      this.height = height;
    }

    public Rectangle(long height, long width) {
      this.height = height;
      this.width = width;
    }
  }
}
