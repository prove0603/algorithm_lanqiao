package chapter3;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/5/18 17:24
 */
public class __3_16__3_18 {
    //    堆排序
    public static void main(String[] args) {
        int arr[] = {38, 6, 34, 11, 81, 18, 61, 47, 99, 7, 50};
        int arr2[] = {38, 6, 34, 11, 81, 18, 61, 47, 99, 7, 50};
        minHeap(arr);
        minSort(arr);
        utils.utils.print(arr);
        System.out.println();
        maxHeap(arr2);
        maxSort(arr2);
        utils.utils.print(arr2);

    }

    //变成小顶堆
    public static void minHeap(int arr[]) {
        int len = arr.length;
        for (int i = (len / 2) - 1; i >= 0; i--) {
            minHeapFloat(arr, i, len);
        }
    }

    public static void minHeapFloat(int arr[], int n, int len) {
        int leftChild = 2 * n + 1, rightChild = 2 * n + 2;
        if (leftChild > len - 1) {
//            不存在左子节点
            return;
        }
        if (rightChild > len - 1) { //不存在右子结点
            if (arr[n] > arr[leftChild]) {
                int tmp = arr[n];
                arr[n] = arr[leftChild];
                arr[leftChild] = tmp;
                minHeapFloat(arr, leftChild, len);
            }
        } else {//找最小的结点
            int min = arr[leftChild] > arr[rightChild] ? rightChild : leftChild;
            if (arr[n] > arr[min]) {
                int tmp = arr[n];
                arr[n] = arr[min];
                arr[min] = tmp;
                minHeapFloat(arr, min, len);
            }
        }
    }

    public static void minSort(int arr[]) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
//            i 而不是i-1是因为 在minHeapFloat里 第三个参数代表 剩余数组的长度
            minHeapFloat(arr, 0, i);
        }
    }

    //    变成大顶堆
    public static void maxHeap(int arr[]) {
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            maxHeapFloat(arr,i,arr.length);
        }
    }

    public static void maxHeapFloat(int arr[], int n, int len) {
        int leftChild = 2 * n + 1, rightChild = 2 * n + 2, max = -1;
        if (leftChild > len - 1) {
            return;
        }
        if (rightChild > len - 1) {
            max = leftChild;
        } else {
            max = arr[leftChild] > arr[rightChild] ? leftChild : rightChild;
        }
        if (arr[max] > arr[n]) {
            int tmp = arr[n];
            arr[n] = arr[max];
            arr[max] = tmp;
            maxHeapFloat(arr, max, len);
        }
    }

    public static void maxSort(int arr[]) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp=arr[0];
            arr[0]=arr[i];
            arr[i]=tmp;
            maxHeapFloat(arr,0,i);
        }
    }
}
