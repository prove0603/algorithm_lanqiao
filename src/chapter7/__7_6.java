package chapter7;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashSet;
import java.util.Set;

public class __7_6 {
// 关键在于分清楚浅拷贝与深拷贝
//    非递归
    public static HashSet<HashSet<Integer>>f1(int arr[]){
        HashSet<HashSet<Integer>> oldSet=new HashSet<>();
        HashSet<HashSet<Integer>> newSet=new HashSet<>();
        HashSet<Integer> tmp1=new HashSet<>(); HashSet<Integer> tmp2=new HashSet<>();
        HashSet<Integer> tmp3=new HashSet<>(); HashSet<Integer> tmp4=new HashSet<>();
        tmp1.add(arr[0]);tmp3.add(arr[0]);
        oldSet.add(tmp1);oldSet.add(tmp2);newSet.add(tmp3);newSet.add(tmp4);
        for (int i = 1; i <arr.length ; i++) {
            for (HashSet<Integer> e:oldSet) {
                HashSet<Integer> tmp=(HashSet<Integer>) e.clone();
                tmp.add(arr[i]);
                newSet.add(tmp);
            }
            oldSet=(HashSet<HashSet<Integer>>)newSet.clone();
        }
        return newSet;
    }

    public static HashSet<HashSet<Integer>>f2(int arr[],int n){
        if (n==0){
            HashSet<HashSet<Integer>> newSet=new HashSet<>();
            newSet.add(new HashSet<>());
            HashSet<Integer> tmp=new HashSet<>();
            tmp.add(arr[0]);
            newSet.add(tmp);
            return newSet;
        }
        HashSet<HashSet<Integer>> oldSet=(HashSet<HashSet<Integer>>)f2(arr,n-1).clone();
        HashSet<HashSet<Integer>> newSet=(HashSet<HashSet<Integer>>)oldSet.clone();
        for (HashSet<Integer> e:oldSet) {
            HashSet<Integer> tmp=(HashSet<Integer>) e.clone();
            tmp.add(arr[n]);
            newSet.add(tmp);
        }
        return newSet;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3};
        System.out.println(f1(arr));
        int arr1[]={1,2,3};
        System.out.println(f2(arr1,arr.length-1));
//        HashSet<HashSet<Integer>> oldSet=new HashSet<>();
//        HashSet<Integer> tmp=new HashSet<>();
//        tmp.add(1);
//        oldSet.add(tmp);
//        HashSet<HashSet<Integer>> newSet=(HashSet<HashSet<Integer>>)oldSet.clone();
//        tmp.add(2);
//        System.out.println(oldSet);
//        System.out.println(newSet);
    }
}
