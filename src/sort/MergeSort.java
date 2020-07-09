package sort;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/8 11:40
 */
public class MergeSort {
    public static int helper[]=new int[100];
//    归并排序
    public static void mergeSort(int arr[],int start,int end){
        if (start<end){
            int middle=start+((end-start)>>1);
            mergeSort(arr,start,middle);
            mergeSort(arr,middle+1,end);
            merge(arr,start,middle,end);
        }
    }

    public static void merge(int arr[],int start,int middle,int end){
        System.arraycopy(arr,start,helper,start,end-start+1);
        int current=start,left=start,right=middle+1;
        while (left<=middle && right<=end){
            if (helper[left]<=helper[right]){
                arr[current]=helper[left];
                left++;
                current++;
            }else {
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

    public static void main(String[] args) {
        int arr[]=utils.utils.randomArray(15);
        utils.utils.print(arr);
        System.out.println();
        mergeSort(arr,0,arr.length-1);
        utils.utils.print(arr);
    }
}
