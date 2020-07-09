package utils;

import java.util.Random;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/5/16 0:38
 */
public class utils {
    public static void swap(int arr[],int a,int b){
        int tmp=arr[a];
        arr[a]=arr[b];
        arr[b]=tmp;
    }

    public static void print(int arr[]){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static int[] randomArray(int n){
        Random random=new Random();
        int arr[]=new int[n];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=random.nextInt(100);
        }
        return arr;
    }
}
