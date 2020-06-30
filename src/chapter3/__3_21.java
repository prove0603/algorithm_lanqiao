package chapter3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/5/19 0:32
 */
public class __3_21 {
//    基数排序
    public static ArrayList[] bucker=new ArrayList[10];

    static {
        for (int i = 0; i <10 ; i++) {
            bucker[i]=new ArrayList();
        }
    }

//    求某个数字的第n位
    public static int getWeishu(int number,int n){
        if (number<=Math.pow(10,n-1) || number==0) return 0;
        int index=1,tmp=-1;
        while (index<=n && number!=0){
            tmp=number%10;
            number/=10;
            if (number==0) break;
            index++;
        }
        return tmp;
    }

    public static int getMax(int arr[]){
        int max=-1;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]>=max){
                max=arr[i];
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        int arr[]={34,54,26,78,9,65,123,45,99};
        int max=getMax(arr);
        int k=0;
        while (max!=0){
            max/=10;
            k++;
        }
        for (int i = 1; i <=k ; i++) {
            //根据最大数的位数进行k次入桶
            for (int j = 0; j <arr.length ; j++) {
                bucker[getWeishu(arr[j],i)].add(arr[j]);
            }
            //出桶
            int index=0;
            for (int j = 0; j <bucker.length ; j++) {
                for (Object tmp:bucker[j]) {
                    arr[index]=(int)tmp;
                    index++;
                }
            }

            //清空桶
            for (int j = 0; j <bucker.length ; j++) {
                bucker[j].clear();
            }
        }
        utils.utils.print(arr);
    }
}
