package chapter7;

import java.util.HashSet;
import java.util.Set;

public class __7_5 {
//    n对括号的有效组合
//    递归
    public static Set<String> f1(int n){
        Set<String> newSet=new HashSet<>();
        if(n==1){
            newSet.add("()");
            return newSet;
        }
        Set<String> oldSet=f1(n-1);
        for (String e:
             oldSet) {
            newSet.add("()"+e);
            newSet.add(e+"()");
            newSet.add("("+e+")");
        }
        return newSet;
    }

    public static void main(String[] args) {
        System.out.println(f1(5));
        System.out.println(f2(5));
    }

//    非递归
    public static Set<String> f2(int n){
        Set<String> oldSet=new HashSet<>();
        oldSet.add("()");
        if(n==1) return oldSet;
        for (int i = 2; i <= n; i++) {
            Set<String> newSet=new HashSet<>();
            for (String e:
                    oldSet) {
                newSet.add("()"+e);
                newSet.add(e+"()");
                newSet.add("("+e+")");
            }
            oldSet=newSet;
        }
        return oldSet;
    }
}
