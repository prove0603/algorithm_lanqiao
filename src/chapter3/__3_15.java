package chapter3;

/**
 * AUTHOR: ZhuangJie
 * DATE: 2020/5/18 1:51
 */
public class __3_15 {
//    二叉树的先序遍历  中序遍历  后序遍历
    public static void xianxu(int arr[],int index){//根 左 右
        if (index>=arr.length){
            return;
        }
        System.out.println(arr[index]);
        xianxu(arr,2*index+1); //左
        xianxu(arr,2*index+2); //右
    }

    public static void zhongxu(int arr[],int index){//左 根 右
        if (index>=arr.length){
            return;
        }
        zhongxu(arr,index*2+1);
        System.out.println(arr[index]);
        zhongxu(arr,index*2+2);
    }

    public static void nixu(int arr[],int index){//左 右 根
        if (index>=arr.length){
            return;
        }
        nixu(arr,index*2+1);
        nixu(arr,index*2+2);
        System.out.println(arr[index]);

    }
    public static void main(String[] args) {
        int arr[]={78,56,34,43,4,1,15,2,23};
//        xianxu(arr,0);
        zhongxu(arr,0);
//        nixu(arr,0);
    }
}
