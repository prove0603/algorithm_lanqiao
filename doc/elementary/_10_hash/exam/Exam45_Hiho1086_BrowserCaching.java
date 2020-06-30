package org.lanqiao.algo.elementary._10_hash.exam;

import java.util.*;

public class Exam45_Hiho1086_BrowserCaching {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();
    Set<String> set = new HashSet<String>();
    Queue<String> q = new LinkedList<String>();
    sc.nextLine();
    for (int i = 0; i < n; i++) {
      String url = sc.nextLine();
      if (set.size()==0) {
        set.add(url);
        q.add(url);
        System.out.println("Internet");
      }
      else{

        if (set.contains(url)){
          //准备新增，移除最久未使用
          // if (set.size()==m){
            q.remove(url);
            q.add(url);
            //set.remove(url);
          // }
          System.out.println("Cache");
        }else{
          //准备新增，移除最久未使用
          if (set.size()==m){
            set.remove(q.poll());
            q.add(url);
            set.add(url);
          }else{
            set.add(url);
            q.add(url);
          }
          System.out.println("Internet");
        }

      }
      // System.out.println(q);
    }
  }
}
