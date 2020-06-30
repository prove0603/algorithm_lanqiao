package org.lanqiao.algo.elementary._02searchAndSort.exam;

// import org.assertj.core.api.Assertions;

import java.util.Scanner;

/**
 * 输入一个递增排序的数组（元素不重复）的一个旋转（次数不详），找出某个元素.
 *
 * 考点：活用二分查找
 */
public class Exam11_FindInRotaryArr {
  /*学生代码public static int serach(int a[], int lift, int right, int k) {
    int mid = (right + lift) / 2;
    if (a[mid] == k)
      return mid;
    if (lift > right)
      return -1;
    if (a[mid] > k)
      return serach(a, lift, mid-1, k);
    else return serach(a, mid+1, right, k);
  }
  public static void main(String[] args) {
    Scanner ss = new Scanner(System.in);
    int n, k, cd , fin = -1;
    n = ss.nextInt();
    cd = n ;
    int[] arr = new int[n];
    int i;
    for(i = 0; i < n; i++) {
      arr[i] = ss.nextInt();
      if(i > 0 && arr[i] < arr[i-1])
        cd = i;
    }
    k = ss.nextInt();
    if(k >= arr[0]) {
      int serach = serach(arr, 0, cd - 1, k);
      fin = n - ( cd - serach - 1);
    }
    else {
      int serach = serach(arr, cd, n - 1, k);
      fin = serach - cd + 1;
    }
    if(fin == 0)
      System.out.println(-1);
    else System.out.println(fin);
  }*/
  // static int indexOf(int[] arr, int key) {
  //   int begin = 0;
  //   int end = arr.length - 1;
  //   while (begin  <= end) {
  //     int mid = begin + ((end - begin) >> 1);
  //
  //     if (arr[mid] == key) return mid;
  //
  //     //  要么左侧有序，要么右侧有序
  //     if (arr[mid] >= arr[begin]&&key >= arr[begin]&&key<=arr[mid] //左侧有序，且在左侧范围内
  //         || arr[mid]<=arr[end]&&key<arr[mid]) { //右侧有序，但不在右侧范围内
  //         end = mid-1;
  //     } else {//右侧有序
  //         begin = mid+1;
  //     }
  //   }
  //   return -1;
  // }
  //
  // public static void main(String[] args) {
  //   Scanner sc = new Scanner(System.in);
  //   int n = sc.nextInt();
  //   int[] arr = new int[n];
  //   for (int i = 0; i < n; i++) {
  //     arr[i] = sc.nextInt();
  //   }
  //   int key = sc.nextInt();
  //   int res = indexOf(arr,key);
  //   System.out.println(res);
  //   /*int[] arr = {6, 1, 2, 3, 4};//在左侧，左侧无序
  //   int res = indexOf(arr,1);
  //   Assertions.assertThat(res).isEqualTo(1);
  //   res = indexOf(arr,3);
  //   Assertions.assertThat(res).isEqualTo(3);
  //
  //
  //
  //   arr = new int[]{2, 3, 4, 5, 6};
  //   res = indexOf(arr,2);
  //   Assertions.assertThat(res).isEqualTo(0);
  //   res = indexOf(arr,3);
  //   Assertions.assertThat(res).isEqualTo(1); //在左侧，左侧有序
  //
  //
  //   arr = new int[]{3, 4, 5, 1, 2};
  //   res = indexOf(arr,1);
  //   Assertions.assertThat(res).isEqualTo(3);//在右侧，右侧无序
  //
  //   arr = new int[]{6, 7, 3, 4, 5};
  //   res = indexOf(arr,4);
  //   Assertions.assertThat(res).isEqualTo(3);//在右侧，右侧有序
  //
  //   arr = new int[]{1, 0, 1, 1, 1};
  //   res = indexOf(arr,0);
  //   Assertions.assertThat(res).isEqualTo(1);
  //
  //   res = indexOf(arr,1);
  //   Assertions.assertThat(res).isEqualTo(0);*/
  // }
  //
  // /*测试下{10111}:{01111}的一个旋转*/
}
