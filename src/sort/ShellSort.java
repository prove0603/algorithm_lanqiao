package sort;
//希尔排序
/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/3/18 23:58
 */
public class ShellSort {
    public static void shellSort(int a[]){
        for (int interval = a.length/2; interval >0 ; interval=interval/2) {
            for (int j = interval; j < a.length; j++) {
                int tmp=a[j];
                int index=j-interval;//index为需要比较的元素
                int left=j;//j为应该在的位置
                while(index>=0 && a[index]>tmp){
                    a[left]=a[index];
                    left=index;
                    index=index-interval;
                }
                a[left]=tmp;
            }
        }
    }

    public static void main(String[] args) {
        int a[]={9,9,6,7,5,4,2,2,1};
        shellSort(a);
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }
}
