package chapter7;

import javax.script.ScriptContext;
import java.util.Scanner;

/**
 * @author ZhuangJIe
 * @version 1.0
 * @date 2020/7/9 16:38
 */

/*
你一定听说过“数独”游戏。
如下图所示，玩家需要根据9×9盘面上的已知数字，推理出所有剩余空格的数字，并满足每一行、每一列、每一个同色九宫内的数字均含1-9，不重复。
数独的答案都是唯一的，所以，多个解也称为无解。
本图的数字据说是芬兰数学家花了3个月的时间设计出来的较难的题目。但对会使用计算机编程的你来说，恐怕易如反掌了。
本题的要求就是输入数独题目，程序输出数独的唯一解。我们保证所有已知数据的格式都是合法的，并且题目有唯一的解。
格式要求，输入9行，每行9个数字，0代表未知，其它数字为已知。
输出9行，每行9个数字表示数独的解。
输入：

0 0 5 3 0 0 0 0 0
8 0 0 0 0 0 0 2 0
0 7 0 0 1 0 5 0 0
4 0 0 0 0 5 3 0 0
0 1 0 0 7 0 0 0 6
0 0 3 2 0 0 0 8 0
0 6 0 5 0 0 0 0 9
0 0 4 0 0 0 0 3 0
0 0 0 0 0 9 7 0 0

程序应该输出：

145327698
839654127
672918543
496185372
218473956
753296481
367542819
984761235
521839764

再例如，输入：

800000000
003600000
070090200
050007000
000045700
000100030
001000068
008500010
090000400

程序应该输出：

812753649
943682175
675491283
154237896
369845721
287169534
521974368
438526917
796318452
*/

public class __7_12 {

    public static void dfs(int arr[][],int x,int y){
        if (x==9) {
            for (int i = 0; i <9 ; i++) {
                for (int j = 0; j <9 ; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.exit(0);

        }
        if (arr[x][y]==0){
            for (int i = 1; i <10 ; i++) {
                boolean result=check(arr,x,y,i);
                if (result){
                    arr[x][y]=i;
                    dfs(arr,x+(y+1)/9,(y+1)%9);
                    arr[x][y]=0;
                }
            }
        }
        else dfs(arr,x+(y+1)/9,(y+1)%9);
    }

    public static boolean check(int arr[][],int x,int y,int k){
        //全部行
        for (int i = 0; i <9 ; i++) {
            if (arr[x][i]==k)
                return false;
        }
        //全部列
        for (int i = 0; i <9 ; i++) {
            if (arr[i][y]==k)
                return false;
        }
//        他所处的小九宫格
        for (int i = (x/3)*3; i <(x/3)*3+3 ; i++) {
            for (int j = (y/3)*3; j <(y/3)*3+3 ; j++) {
                if (arr[i][j]==k){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int arr[][]=new int[9][9];
        Scanner in=new Scanner(System.in);
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                arr[i][j]=in.nextInt();
            }
        }
        in.close();
        dfs(arr,0,0);

    }
}
