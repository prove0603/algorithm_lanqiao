package chapter3;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/5/17 1:57
 */
public class __3_11 {
    //    寻找发帖水王
//    思路：两种情况：最后一个数字是刚好一半的数字    最后一个数字不是刚好一半的数字
//    前者的话可以通过每个数字跟最后一个数字比较  出现次数肯定等于数组的一半
//    后者的话   count刚好被消减为0  所以就是number
    public static void main(String[] args) {
        int arr[]={3,5,4,5,2,5,5,1};
        int number=-1,count=0,lastCount=0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==arr[arr.length-1]) lastCount++;
            if (number!=arr[i] && count==0){
                number=arr[i];
                count++;
            }
            if (number!=arr[i] && count!=0){
                count--;
            }
            if (number==arr[i] ){
                count++;
            }
        }
        if (lastCount==arr.length/2) System.out.println(arr[arr.length-1]);
        else System.out.println(number+"abc");
    }
}
