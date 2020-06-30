package chapter3;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/5/17 17:49
 */
public class __3_13 {
    //    最小可用id
    public static void main(String[] args) {
        int arr[]={3,2,1,6};
        System.out.println(partition(arr,0,arr.length-1));
    }
    public static int partition(int arr[],int start,int end){
        if (start==end){
            if (arr[start]==start+1){
                return start+2;
            }else {
                return arr[start-1]+1;
            }
        }
        int pivot=arr[start];
        int left=start,right=end;
        while (left<=right){
            while (left<=right && arr[left]<=pivot) left++;
            while (left<=right && arr[right]>pivot) right--;
            if (left<right) utils.utils.swap(arr,left,right);
        }
        utils.utils.swap(arr,start,right);
        utils.utils.print(arr);
        System.out.println();
        if (right+1==arr[right]){
//            说明左侧紧密  空缺在右侧
            return partition(arr,right+1,end);
        }
        else{
//            空缺在左侧
            return partition(arr,start,right);
        }
    }
}
