package org.lanqiao.algo.elementary._04matrix.exam;

/**
 * Exam18_TransformMatrix
 -----
 有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。

 给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。

 **注意：不要使用缓存矩阵**

 输入
 ----
 第一行包含一个整数N。(1 <= N <= 500)

 随后的N行每一行都有N个整数（空格隔开），作为数组的元素

 输出
 ----
 按行列输出方阵（行内元素空格隔开）

 样例输入
 -----
 3
 1 2 3
 4 5 6
 7 8 9

 样例输出
 ----
 7 4 1
 8 5 2
 9 6 3
 */
public class Exam18_TransformMatrix {
  /**

   思路：

   把矩阵想成一个洋葱，一圈包着一圈，外一圈每一条边比里一圈每一条边长度多2，
   外层循环一趟旋转一圈，因此只需n/2趟
   内层循环实际控制当前这圈的每个元素的旋转，边界是从i开始到倒数i结束

   * @param mat
   * @param n
   * @return
   */
  public static int[][] transformImage(int[][] mat, int n) {
    if (mat==null)
      return null;
    for (int i = 0; i < n/2; i++) {  // 行号，层数
      for (int j = i; j < n-1-i; j++) { // 列号,层起点
        int temp = mat[i][j];
        mat[i][j] = mat[n-1-j][i];
        mat[n-1-j][i] = mat[n-1-i][n-1-j];
        mat[n-1-i][n-1-j] = mat[j][n-1-i];
        mat[j][n-1-i] = temp;
      }
    }
    return mat;
  }

}
