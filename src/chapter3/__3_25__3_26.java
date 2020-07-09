package chapter3;

import java.util.Scanner;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/5/19 19:45
 */
public class __3_25__3_26 {
//    经典题目TopK
    //    前k个数   利用小顶堆
    public static int arr[];
    public static int index=0;
    public static int k;

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        k=in.nextInt();
        arr=new int[k];
        int number=in.nextInt();
        while (number!=-1){
            deal(number);
            number=in.nextInt();
        }
    }

    public static void deal(int number){
        if (index<k){
            arr[index]=number;
            index++;
            if (index==k){
//                将数组堆化
                minHeap(arr);
            }
            return;
        }
        if (number>arr[0]){
            arr[0]=number;
            minHeapFloat(arr,0,arr.length);
        }
        utils.utils.print(arr);
        System.out.println();
    }
    public static void minHeap(int arr[]){
        for (int i = (arr.length/2)-1; i >=0 ; i--) {
            minHeapFloat(arr,i,arr.length);
        }
    }

    public static void minHeapFloat(int arr[],int n,int len){
        int leftChild=2*n+1,rightChild=2*n+2,min=-1;
        if (leftChild>len-1){
            return;
        }
        if (rightChild>len-1){
            min=leftChild;
        }else {
            min=arr[leftChild]>arr[rightChild]?rightChild:leftChild;
        }
        if (arr[n]>arr[min]){
            int tmp=arr[min];
            arr[min]=arr[n];
            arr[n]=tmp;
            minHeapFloat(arr,min,len);
        }
    }
}
