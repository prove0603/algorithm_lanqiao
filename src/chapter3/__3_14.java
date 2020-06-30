package chapter3;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/5/17 19:28
 */
public class __3_14 {
    //    两道有关逆序对的题目
//    合并有序数组

    public static void main(String[] args) {
        int arr1[]={1,3,5,7,9,100,0,0,0,0,0,0,0,0,0};
        int arr2[]={2,4,6,8,10};
        int a[]={37,40,48,90,32,5,12,3,44,13};
//        f1(arr1,arr2,6,5);
        mergeSort(a,0,a.length-1);
        utils.utils.print(a);
        System.out.println("\n"+nixu);
    }

    public static void f1(int arr1[], int arr2[], int sizea, int sizeb) {
        int total = sizea + sizeb;
        int indexA = sizea - 1, indexB = sizeb - 1, right = total - 1;
        int current = -1;
        for (int i = total - 1; i >= 0; i--) {
            current = i;
            if (indexA == -1 || indexB == -1) break;
            if (arr1[indexA] <= arr2[indexB]) {
                arr1[i] = arr2[indexB];
                indexB--;
            } else {
                arr1[i] = arr1[indexA];
                indexA--;
            }
        }
        if (indexA == -1 && indexB != -1) {
            while (indexB != -1) {
                arr1[current] = arr2[indexB];
                current--;
                indexB--;
            }
        }
        utils.utils.print(arr1);
    }

//    逆序对
    public static int nixu=0;
    public static int helper[]=new int[1000];
    public static void merge(int arr[],int start,int middle,int end){
        System.arraycopy(arr,start,helper,start,end-start+1);
        int current=start,left=start,right=middle+1;
        while (left<=middle && right<=end){
            if (helper[left]<=helper[right]){
                arr[current]=helper[left];
                left++;
                current++;
            }else {
                nixu+=middle-left+1;
                arr[current]=helper[right];
                right++;
                current++;
            }
        }
        while (left<=middle){
            arr[current]=helper[left];
            left++;
            current++;
        }
    }

    public static void mergeSort(int arr[],int start,int end){
        if(start<end){
            int middle=start+((end-start)>>1);
            mergeSort(arr,start,middle);
            mergeSort(arr,middle+1,end);
            merge(arr,start,middle,end);
        }
    }
}
