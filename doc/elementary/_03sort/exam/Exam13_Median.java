package org.lanqiao.algo.elementary._03sort.exam;
import org.lanqiao.algo.util.Util;

import java.util.Scanner;

public class Exam13_Median {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(true) {
      int N = sc.nextInt();
      int[] arr = new int[N];
      // int[] arr = Util.getRandomArr(N, 1, N);
      // for (int i = 0; i < N; i++) {
      //   System.out.print(arr[i]+" ");
      // }
      // System.out.println();
      for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();
      }
      // long now = System.currentTimeMillis();
      System.out.print(arr[0] + " ");
      for (int i = 1; i < N; i++) {
        System.out.print(selectK(arr, 0, i, i / 2 + 1) + " ");
      }
      System.out.println();
      // Util.duration(now);
    }
  }
  public static int selectK(int[] A, int p, int r, int k) {
    int q = partition2(A, p, r);//主元的下标
    int qK = q - p + 1;//主元是第几个元素
    if (qK == k) return A[q];
    else if (qK > k) return selectK(A, p, q - 1, k);
    else return selectK(A, q + 1, r, k - qK);
  }
  public static int partition2(int[] A, int p, int r) {
    //优化，在p,r,mid之间，选一个中间值作为主元
    int midIndex = p + ((r - p) >> 1);//中间下标
    int midValueIndex = -1;//中值的下标
    if (A[p] <= A[midIndex] && A[p] >= A[r]) {
      midValueIndex = p;
    } else if (A[r] <= A[midIndex] && A[r] >= A[p]) {
      midValueIndex = r;
    } else {
      midValueIndex = midIndex;
    }
    swap(A, p, midValueIndex);
    int pivot = A[p];

    int left = p + 1;//扫描指针
    int right = r;//右侧指针
    while (left <= right) {
      while (left <= right && A[left] <= pivot) left++;
      while (left <= right && A[right] > pivot) right--;
      if (left < right) {
        swap(A, left, right);
      }
    }

    swap(A, p, right);
    return right;
  }
  public static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
