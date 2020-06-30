package org.lanqiao.algo.elementary._09_Linear.exam;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Exam41_IsPopOrder {
  public static void main(String[] args) {
    Exam41_IsPopOrder obj=new Exam41_IsPopOrder();
    // obj.IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2});
    int[] pushA = {1, 2, 3, 4, 5};
    int[] popA = {1, 2, 5, 4,3};
    boolean res = obj.IsPopOrder(pushA, popA);
    for (int x:pushA
         ) {
      System.out.print(x+" ");
    }
    System.out.println();
    for (int x:popA
        ) {
      System.out.print(x+" ");
    }
    System.out.println();
    System.out.println(res?"True":"False");
  }

  public boolean IsPopOrder(int [] pushA,int [] popA) {
    Stack<Integer> s1 = new Stack<>();
    int p1=0;
    int p2=0;
    while (p1<pushA.length) {
      if (pushA[p1] == popA[p2]) {
        p1++;
        p2++;
      } else {
        if(s1.isEmpty()||s1.peek() != popA[p2]) {
          s1.push(pushA[p1]);
          p1++;
        }else {
            s1.pop();
            p2++;
        }
      }
    }
    while (!s1.isEmpty()&&s1.peek()==popA[p2]){
      s1.pop();
      p2++;
    }
    if (p2<popA.length)
      return false;
    else
      return true;
  }
}
