package chapter3;

import utils.utils;
/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/5/16 0:24
 */
public class __3_3 {
//    快排之单向扫描分区

    public static void main(String[] args) {
        int a[]={6,8,7,3,9,4,2,5};
        quickSort(a,0,a.length-1);
        utils.print(a);
    }
    public static void quickSort(int[] array,int start,int end){
        if(start<end){
            int middle=partition(array,start,end);
            quickSort(array,start,middle-1);
            quickSort(array,middle+1,end);
        }
    }
    public static Integer partition(int[] array,int start,int end){
        int pivot=array[start];
        int left=start+1;
        int right=end;
        while (left<=right ){
            if(array[left]<=pivot){
                left++;
            }else {
                utils.swap(array,left,right);
                right--;
            }
        }
        utils.swap(array,start,right);
        return right;
    }
}
