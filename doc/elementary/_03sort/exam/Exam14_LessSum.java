package org.lanqiao.algo.elementary._03sort.exam;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exam14_LessSum {
  private static int[] helper;
  private static int sum = 0;

  public static void sort(int[] arr) {
    helper = new int[arr.length];
    sort(arr, 0, arr.length - 1);
  }

  /*
  分成两段分别排序，然后再合并
  */
  private static void sort(int[] arr, int low, int high) {
    if (low < high) {
      int middle = low + ((high - low) >> 1);
      sort(arr, low, middle);
      sort(arr, middle + 1, high);
      merge(arr, low, middle, high);
    }
  }


  /**
   *假设数组的两段分别有序，借助一个辅助数组来缓存原数组，用归并的思路将元素从辅助数组中拷贝回原数组
   *@param A 原数组
   *@param p 低位
   *@param mid 中间位
   *@param r 高位
   **/
  private static void merge(int[] A, int p, int mid, int r) {
    //拷贝到辅助空间的相同位置
    System.arraycopy(A, p, helper, p, r - p + 1);
    //辅助数组的两个指针
    int left = p, right = mid + 1;
    //原始数组的指针
    int current = p;
    while (left <= mid && right <= r) {
      int leftV = helper[left];
      if (leftV <= helper[right]) {
        A[current++] = helper[left++];
        sum += leftV * (r - right + 1);
      } else { //右边小
        A[current++] = helper[right++];
      }
    }
    //  这样做完后，左边指针可能没到头;右边的没到头也没关系，想想为什么？
    while (left <= mid) {
      A[current] = helper[left];
      current++;
      left++;
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }
    sort(arr);
    System.out.print(sum);
  }
}
