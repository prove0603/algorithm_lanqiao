package chapter7;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/9 10:14
 */
public class __7_9 {
//    全排列之回溯法
    public static void f(char str[],int n){
        if (n==str.length){
            System.out.println(str);
        }
        for (int i = n; i <str.length ; i++) {
            swap(str,n,i);
            f(str,n+1);
            swap(str,n,i);
        }
    }

    public static void swap(char a[],int x,int y){
        char tmp=a[x];
        a[x]=a[y];
        a[y]=tmp;
    }

    public static void main(String[] args) {
        f("ABC".toCharArray(),0);
    }
}
