package chapter7;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/6/16 18:25
 */
public class __7_4 {

//    递归法  不能用f(n-1)+f(n-2)+f(n-5).....是因为这种形式是考虑顺序的  1+2与2+1不同
    public static int f(int n,int arr[],int index){
        int counter=0;
        if(index==0) return 1;

        for (int i = 0; i <=n/arr[index] ; i++) {
            counter+=f(n-i*arr[index],arr,index-1);
        }
        return counter;
    }

    public static void main(String[] args) {
//        int arr[]={1,2,5,10,20,50,100,200};
        int arr[]={1,5,10,25};
        System.out.println(f(10,arr,arr.length-1));
        for (int i = 1; i <50 ; i++) {
            System.out.println(i+"---------"+f(i,arr,arr.length-1));
        }
    }
}
