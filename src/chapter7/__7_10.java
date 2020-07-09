package chapter7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/9 10:26
 */
public class __7_10 {
//    全排列之前缀法
    public static int arr[]=new int[128];
    public static void f1(String a,String prefix,int arr[]){
        if (prefix.length()==a.length()){
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i <a.length(); i++) {
            //判断是否用完了
            if (arr[a.charAt(i)]!=0){
//                prefix.append(a.charAt(i));
                arr[a.charAt(i)]--;
                f1(a,prefix+a.charAt(i),arr);
                arr[a.charAt(i)]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        char[] arr2=str.toCharArray();
        for (int i = 0; i <arr2.length ; i++) {
            arr[arr2[i]]++;
        }
        Arrays.sort(arr2);
        str=String.valueOf(arr2);
        f1(str,"",arr);
    }
}
