package chapter7;

import java.util.HashSet;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/9 9:10
 */
public class __7_8 {
//    全排列
//    解法之直接生成  插入法
    public static HashSet<String> f1(String a){
        HashSet<String> set=new HashSet<>();
        set.add(a.charAt(0)+"");  //生成第一个
        for (int i = 1; i <a.length() ; i++) {
            HashSet<String> tmpSet=new HashSet<>();
            for (String str:set) {
                for (int j = 0; j <str.length() ; j++) {
                    String newStr1=str.substring(0,j)+a.charAt(i)+str.substring(j);  //往前插
                    String newStr2=str.substring(0,j+1)+a.charAt(i)+str.substring(j+1);  //往后插
                    tmpSet.add(newStr1);
                    tmpSet.add(newStr2);
                }
            }
            set=tmpSet;
        }
        return set;
    }

//    递归法
    public static HashSet<String> f2(String a,int n){
        if (n==0){
            HashSet<String> set=new HashSet<>();
            set.add(a.charAt(n)+"");
            return set;
        }
        HashSet<String> tmpSet=f2(a,n-1);
        HashSet<String> newSet=new HashSet<>();
        for (String str:tmpSet) {
            for (int j = 0; j <str.length() ; j++) {
                String newStr1=str.substring(0,j)+a.charAt(n)+str.substring(j);  //往前插
                String newStr2=str.substring(0,j+1)+a.charAt(n)+str.substring(j+1);  //往后插
                newSet.add(newStr1);
                newSet.add(newStr2);
            }
        }
        return newSet;
    }
    public static void main(String[] args) {
        System.out.println(f1("ABC"));
        System.out.println(f2("ABC",2));
//        HashSet<String> set=new HashSet<>();
//        HashSet<String> set1=set;
//        set.add("123132");
//        System.out.println(set);
//        System.out.println(set1);

    }
}
