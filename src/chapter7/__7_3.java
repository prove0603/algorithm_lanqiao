package chapter7;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/6/5 21:38
 */
public class __7_3 {

    //递归
    public static int f1(int x,int y){
        if(x==1||y==1) return 1;
        return f1(x-1,y)+f1(x,y-1);
    }

    //循环
    public static int f2(int x,int y){
        int arr[][]=new int[x+1][y+1];
        for (int i = 1; i <=x ; i++) {
            arr[i][1]=1;
        }
        for (int i = 1; i <=y ; i++) {
            arr[1][i]=1;
        }
        for (int i = 2; i <=x ; i++) {
            for (int j = 2; j <=y ; j++) {
                arr[i][j]=arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[x][y];
    }

    public static void main(String[] args) {
        System.out.println(f1(3,3));
        System.out.println(f2(3,3));
    }
}
