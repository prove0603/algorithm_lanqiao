package sort;
//插入排序
//二分查找
/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/3/18 21:57
 */
public class InsertSort {

    public static void insertSort(int array[]){
        for (int i = 1; i <array.length ; i++) {
            int index=i-1;
            int right=i;
            int tmp=array[i];
            //right代表应该在的位置  index代表要比较的元素
            while(index>=0 && tmp<array[index]){
                array[right]=array[index];
                right--;
                index--;
            }
            array[right]=tmp;
        }
    }

    public static void main(String[] args) {
        int a[]={8,7,3,9,3,2,6,5,1,4};
//        int a[]={5,4,6,9};
        insertSort(a);
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }
}
