package org.lanqiao.algo.elementary._07_dfs.exam;

import java.util.Scanner;

public class Exam31LDL {
  private static int f(String str) {
    //如果打头数字是0后缀能转换的次数肯定为0
    if(str.startsWith("0"))return 0;
    int length = str.length();
    //长度为1
    if(length==1){
      if(str.equals("0")){
        return 0;
      }else{
        return 1;
      }
    }
    if(length==2){
      int value = Integer.parseInt(str);
      if(value>0&&value<27&&!str.endsWith("0")){
        return 2;
      }else{
        return 1;
      }
    }
    //第一个数组打头，求后缀的转换次数
    int sum = f(str.substring(1));
    String sub = str.substring(0, 2);
    int a =  Integer.parseInt(sub);
    //前两个数字 如果在字符集以内求后缀能转的次数
    if(a>0&&a<27){
      sum+=f(str.substring(2));
    }
    return sum;
  }
  public static void main(String[] args) {
    // long now = System.currentTimeMillis();
    // int res = dfs("121214531213", 0);
    // System.out.println(res);
    // System.out.println(System.currentTimeMillis()-now);
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    System.out.println(f(s));
  }
}
