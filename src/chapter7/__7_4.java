package chapter7;

import java.util.Arrays;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/6/16 18:25
 */
public class __7_4 {

//    递归法  不能用f(n-1)+f(n-2)+f(n-5).....是因为这种形式是考虑顺序的  1+2与2+1不同
    public static int f(int n,int arr[],int index){
        int counter=0;
        if(index==0) return 1;

        for (int i = 0; i <=n/arr[index] ; i++) {
            counter+=f(n-i*arr[index],arr,index-1);
        }
        return counter;
    }

    public static void main(String[] args) {
//        int arr[]={1,2,5,10,20,50,100,200};
        int arr1[]={1,5,10,25};
        System.out.println(f(37,arr1,arr1.length-1));
//        for (int i = 1; i <50 ; i++) {
//            System.out.println(i+"---------"+f(i,arr,arr.length-1));
//        }

        int tmp[]={1,5,10,25};
        int arr[][]=new int[26][51];
        for (int i = 1; i <=25 ; i++) {
            for (int j = 0; j <=50 ; j++) {
                if (i==1 || i==5 || i==10 || i==25){
                    if (i==1){
                        arr[i][j]=1;
                    }else {
                        int index= Arrays.binarySearch(tmp,i);
                        for (int k = 0; k <=j/i ; k++) {
                            arr[i][j]+=arr[tmp[index-1]][j-k*i];
                        }
                    }
                }
                else{
                    continue;
                }
            }
        }
        System.out.println(arr[25][37]);
    }

//    非递归
    public static int f2(){
        for (int i = 1; i <=25 ; i++) {
            for (int j = 0; j <=50 ; j++) {

            }
        }
        return 0;
    }
}
