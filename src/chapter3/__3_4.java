package chapter3;

import utils.utils;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/5/16 16:17
 */
public class __3_4 {
//    快排之双向扫描法

    public static void main(String[] args) {
        int a[]={6,8,7,3,9,4,2,5};
        quickSort(a,0,a.length-1);
        utils.print(a);
    }

    public static void quickSort(int arr[],int start,int end){
        if (start<end){
            int middle=partition(arr,start,end);
            quickSort(arr,start,middle-1);
            quickSort(arr,middle+1,end);
        }
    }

    public static int partition(int arr[],int start,int end){
        int pivot=arr[start];
        int left=start+1;
        int right=end;
        while (left<=right){
            while (left<=right && arr[left]<=pivot){
                left++;
            }
            while (left<=right && arr[right]>pivot){
                right--;
            }
//            注意要left<right
            if(left<right) utils.swap(arr,left,right);
        }
        utils.swap(arr,start,right);
        return right;
    }
}

