package chapter3;

import utils.utils;

import java.util.Arrays;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/5/16 17:17
 */

public class __3_7 {
//    归并排序
    public static int tmp[]=new int[1000];

    public static void main(String[] args) {
        int a[]={3,2,1};
        mergeSort(a,0,a.length-1);
        utils.print(a);
    }

    public static void mergeSort(int arr[],int start,int end){
        if(start<end){
            int middle=start+((end-start)>>1);
//            是middle 不是middle-1
            mergeSort(arr,start,middle);
            mergeSort(arr,middle+1,end);
            merge(arr,start,middle,end);
        }
    }

    public static void merge(int arr[],int start,int middle,int end){
        //拷贝数组
//       copy(arr,start,end);
        System.arraycopy(arr,start,tmp,start,end-start+1);
       int current=start,left=start,right=middle+1;
       while (left<=middle &&right<=end){
           if (tmp[left]<=tmp[right]){
               arr[current]=tmp[left];
               current++;
               left++;
           }else {
               arr[current]=tmp[right];
               current++;
               right++;
           }
       }
        while (left<=middle){
            arr[current]=tmp[left];
            left++;
            current++;
        }
    }

    public static void copy(int arr[],int start,int end){
        for (int i = 0; i <end-start+1 ; i++) {
            tmp[start+i]=arr[start+i];
        }
    }
}
