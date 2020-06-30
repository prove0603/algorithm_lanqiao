package chapter3;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/5/19 2:14
 */
public class __3_23 {
    //    排序数组中找和的因子  要注意题目给出的条件  有序！
    public static void main(String[] args) {
        int arr[]={-8,-3,0,2,4,5,8,9,10,18};
        f2(arr,10);
    }
    //空间换时间   不是最佳
    public static void f1(int arr[],int k){
        int a1[]=new int[arr.length];//计算差值
        int a2[]=new int[1000];//计算次数
        for (int i = 0; i <arr.length ; i++) {
            arr[i]+=100;
        }
        k+=200;
        for (int i = 0; i <arr.length ; i++) {
            a1[i]=k-arr[i];
            a2[arr[i]]++;
        }
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]==a1[i]){
                if (a2[arr[i]]==1) continue;
            }
            if(a2[a1[i]]!=0){
                System.out.println(arr[i]-100+"  "+(k-arr[i]-100));
                a2[a1[i]]--;
                a2[arr[i]]--;
            }
        }
    }

    public static void f2(int arr[],int k){

        for (int i = 0; i <arr.length ; i++) {
            int right=arr.length-1;
            while (arr[i]+arr[right]>=k){
                if (arr[i]+arr[right]==k && i!=right){
                    System.out.println(arr[i]+"   "+arr[right]);
                    break;
                }
                if (right==i) break;
                right--;
            }
        }
    }
}
