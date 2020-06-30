package chapter3;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/5/17 1:29
 */
public class __3_10 {
    //    哪个数字超过了一半
    public static void main(String[] args) {
        int arr[]={2,2,4,5,6,75,32,4,6,8,9,7,6,5,4,6,5,5,7,7,6,6,5,5,8,9,5,5,5,0,5,5,1,3};
        int number=-1,count=0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]!=number && count==0){
                number=arr[i];
                count=1;
            }
            if (arr[i]!=number && count!=0){
                count--;
            }
            if (arr[i]==number) count++;
        }
        System.out.println(number);
    }
}
