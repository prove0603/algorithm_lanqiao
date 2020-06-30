package org.lanqiao.algo.elementary._05str.exam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * fjxmlhx每天都在被沼跃鱼刷屏，因此他急切的找到了你希望你写一个程序屏蔽所有句子中的沼跃鱼(“marshtomp”，不区分大小写)。
 * 为了使句子不缺少成分，统一换成 “fjxmlhx” 。
 */
public class Exam22Hiho1082字符串替换 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Pattern pattern = Pattern.compile("Marshtomp", Pattern.CASE_INSENSITIVE);
    // StringBuilder res=new StringBuilder();
    while(sc.hasNext()){
      String line = sc.nextLine();
      Matcher m = pattern.matcher(line);
      System.out.println(m.replaceAll("fjxmlhx"));
    }
  }
}
