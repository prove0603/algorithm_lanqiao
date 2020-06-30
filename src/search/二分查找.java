package search;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/3/18 22:56
 */
public class 二分查找 {

    public static int search(int a[],int low,int high,int key){
        if(low>high){
            return -1;
        }
        int mid=(low+high)>>>1;
        if (key>a[mid]){ //在右边
            return search(a,mid+1,high,key);
        }
        if (key<a[mid]){
            return search(a,low,mid-1,key);
        }
        return mid;
    }

    public static void main(String[] args) {
        int a[]={1,2,3,4,6,8,9};
        int p=search(a,0,a.length-1,8);
        System.out.println(p);
    }
}
