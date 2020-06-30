package org.lanqiao.algo.elementary._02searchAndSort.exam;

import org.lanqiao.algo.util.Util;

import java.util.Arrays;
import java.util.Scanner;

public class Exam12_TwoSum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] numbers = new int[N];
    for (int i = 0; i < N; i++) {
      numbers[i] = sc.nextInt();
    }
    int target = sc.nextInt();
    int[] res = twoSum(numbers,target);
    Util.print(res);
  }

  /**
   * 可处理无序，重复等
   * @param numbers
   * @param target
   * @return
   */
  public static int[] twoSum(int[] numbers, int target) {
    int[] help = new int[numbers.length];
    System.arraycopy(numbers,0,help,0,numbers.length);
    Arrays.sort(help);
    int x = -1;
    int y = -1;
    for (int i=0; i<help.length;i++ ) {
      int j = Arrays.binarySearch(help,target-help[i]);
      if(j>-1){
        x=help[i];
        y=help[j];
        break;
      }
    }
    int i=-1;
    int j=-1;
    for (
        int k=0;k<numbers.length ;k++ ){
      if(numbers[k]==x&&i==-1) i = k;
      if(numbers[k]==y&&j==-1&&k!=i) j = k;
    }
    if(i>j){
      int t = i;
      i=j;
      j=t;
    }
    return new int[]{i,j};
  }
}
