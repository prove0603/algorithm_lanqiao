package chapter3;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/5/19 17:56
 */
public class __3_24 {
//    需要排序的子数组
//    思路：一个排好序的数组（假设升序）  最大的在右侧   最小的在左侧
//    所以找到不符合顺序的左右端点就能找到需要排序的子数组
    public static int[] find(int arr[]){
        int left1=-1,right1=-1,max=arr[0],min=arr[arr.length-1];
//        假设升序的情况下
        for (int i = 0; i <arr.length ; i++) { //找右端点

            if (arr[i]<max){
                right1=i;
            }
            if (arr[i]>max){
                max=arr[i];
            }
        }
        for (int i = arr.length-1; i >=0 ; i--) { //找左端点
            if (arr[i]>min){
                left1=i;
            }
            if (arr[i]<min){
                min=arr[i];
            }
        }

        int left2=-1,right2=-1;
        max=arr[arr.length-1];min=arr[0];
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]>min){
                right2=i;
            }
            if (arr[i]<min){
                min=arr[i];
            }
        }
        for (int i = arr.length-1; i >=0 ; i--) {
            if (arr[i]<max){
                left2=i;
            }
            if (arr[i]>max){
                max=arr[i];
            }
        }

        int result[]=new int[2];
//        找谁最短
        if (right1-left1+1<right2-left2+1){
            result[0]=left1;
            result[1]=right1;
        }else {
            result[0]=left2;
            result[1]=right2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 6, 5, 9, 10};

        utils.utils.print(find(A));
        System.out.println();

        A = new int[]{1, 2, 3, 4, 5, 6};
        utils.utils.print(find(A));
        System.out.println();

        A = new int[]{1, 5, 3, 4, 2, 6, 7};
        utils.utils.print(find(A));
        System.out.println();

        A = new int[]{2, 3, 7, 5, 4, 6};
        utils.utils.print(find(A));
        System.out.println();

        A = new int[]{3, 2, 5, 6, 7, 8};
        utils.utils.print(find(A));
        System.out.println();

        A = new int[]{2, 8, 7, 10, 9};
        utils.utils.print(find(A));
        System.out.println();

        A = new int[]{2, 3, 7, 4, 1, 5, 6};
        utils.utils.print(find(A));
        System.out.println();

        A = new int[]{8,7,6,5,4,3,2,1};
        utils.utils.print(find(A));
        System.out.println();

        A = new int[]{8,7,6,5,4,3,1,2};
        utils.utils.print(find(A));
        System.out.println();
    }
}
