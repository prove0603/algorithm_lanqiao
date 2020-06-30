package chapter3;

import java.util.Scanner;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/5/16 18:54
 */
public class __3_9 {
    //    最快效率求出乱序数组中第k小的数
    public static void main(String[] args) {
        int arr[]={4,6,2,3,0,1,9,7,8,5};
        Scanner in=new Scanner(System.in);
        int k=in.nextInt();
        f(arr,0,arr.length-1,k);
    }

    public static void f(int arr[],int start,int end,int k){
        int index=partition(arr,start,end);
        if ((k-1)==index){
            System.out.println(arr[index]);
            return;
        }
        if ((k-1)<index) f(arr,start,index-1,k);
        else f(arr,index+1,end,k);
    }
    public static int partition(int arr[],int start,int end) {
        int pivot = arr[start];
        int left = start + 1, right = end;
        while (left <= right) {
            while (left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] > pivot) right--;
            if (left < right) utils.utils.swap(arr, left, right);
        }
        utils.utils.swap(arr,start,right);
        return right;
    }
}
