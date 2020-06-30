package org.lanqiao.algo.elementary._03sort.exam;

import java.awt.image.Kernel;
import java.util.Arrays;
import java.util.Scanner;

public class Exam15_MaxHeap {
  static int[] heap;
  static int index ;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int k = sc.nextInt();
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }



    solve(N, k, arr);
  }

  public static void solve(int n, int k, int[] arr) {
    heap = new int[k];
    index=0;
    for (int i = 0; i < n; i++) {
      int x = arr[i];
      deal(x,k);
    }
    Arrays.sort(heap);
    for (int i = 0; i < k; i++) {
      System.out.print(heap[i]+" ");
    }
  }

  private static void deal(int x,int k) {
    if (index < k) {
      heap[index++] = x;
      if (index == k) {
        makeMaxHeap(heap);
      }
    } else if (heap[0] > x) {
        heap[0] = x;
        maxHeapFixDown(heap, 0, k);
      }

  }

  private static void maxHeapFixDown(int[] heap, int i, int N) {
    // 找到左右孩子
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    //左孩子已经越界，i就是叶子节点
    if (left >= N) {
      return;
    }
    int bigger = left;
    if (right >= N) {
      bigger = left;
    } else {
      if (heap[right] > heap[left]) {
        bigger = right;
      }
    }

    if (heap[i] >= heap[bigger]) {
      return;
    }
    int temp = heap[i];
    heap[i] = heap[bigger];
    heap[bigger] = temp;

    maxHeapFixDown(heap, bigger, N);

  }

  private static void makeMaxHeap(int[] A) {
    int n = A.length;
    for (int i = n / 2 - 1; i >= 0; i--) {
      maxHeapFixDown(A, i, n);
    }
  }
}
