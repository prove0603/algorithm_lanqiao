package sort;

import java.util.Random;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/8 11:17
 */
public class QuickSort {
//    双向扫描
    public static void quickSort(int arr[],int start,int end){
        if (start>=end){
            return;
        }
        int middle=partiton(arr,start,end);
        quickSort(arr,start,middle-1);
        quickSort(arr,middle+1,end);
    }

    public static int partiton(int arr[],int start,int end){
        int pivot=arr[start];
        int left=start+1,right=end;
        while (left<=right){
            while (left<=right && arr[left]<=pivot){
                left++;
            }
            while (left<=right && arr[right]>pivot){
                right--;
            }
            if (left<right){
                utils.utils.swap(arr,left,right);
            }
        }
        utils.utils.swap(arr,start,right);
        return right;
    }

    public static void main(String[] args) {
        int arr[]=new int[15];
        Random random=new Random();
        for (int i = 0; i <15 ; i++) {
            arr[i]= random.nextInt(100);
        }
        quickSort(arr,0,arr.length-1);
        utils.utils.print(arr);
    }
}
