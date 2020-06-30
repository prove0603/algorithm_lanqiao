package chapter3;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/5/16 18:40
 */
public class __3_8 {
    //    调整数组顺序
    public static void main(String[] args) {
        int arr[]={1,4,2,3,5,8,9,1,5,9,4,2,7,8,9,6,3};
        int left=0,right=arr.length-1;
        while (left<=right){
            while (left<=right && arr[left]%2==1){//奇数
                left++;
            }
            while (left<=right && arr[right]%2==0){
                right--;
            }
            if (left<right) {
                utils.utils.swap(arr, left, right);
            }
        }
        utils.utils.print(arr);
    }
}
