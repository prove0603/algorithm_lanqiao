package org.lanqiao.algo.elementary._11_tree.exam;

import java.util.Scanner;

public class _01HiHo1049 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String pre = scanner.nextLine();
    String in = scanner.nextLine();
    TreeNode<String> node = construct(pre.split(""), in.split(""));
    post(node);
  }

  private static void post(TreeNode<String> node) {
    if (node==null)return;
    post(node.left);
    post(node.right);
    System.out.print(node.data);
  }

  private static TreeNode<String> construct(String[] preOrder, String[] inorder) {
    return construct(preOrder, 0, preOrder.length-1, inorder, 0, inorder.length-1);
  }

  /**
   * 务必搞定对应区间
   * @param preOrder 前序遍历数组
   * @param scan
   * @param e1
   * @param inOrder 中序遍历数组
   * @param b2
   * @param e2
   * @return
   */
  static TreeNode<String> construct(String[] preOrder, int scan, int e1, String[] inOrder, int b2, int e2) {
    //凡是交叉或越界，返回null
    if (scan > e1 || b2 > e2 || e1 < 0 || e2 < 0)
      return null;

    String rootValue = preOrder[scan];// 前序遍历的第一个是根节点
    int index = indexOf(inOrder, rootValue, b2, e2); // 根节点在中序遍历数组中的索引
    if (index == -1)
      return null;
    TreeNode<String> rootNode = new TreeNode<String>(rootValue); // 构建根节点
    // pre 从scan+1 取index-1-b2个元素  in 从b2 取index-1-b2个
    rootNode.left = construct(preOrder, scan + 1, scan + index - b2, inOrder, b2, index - 1);
    // pre从跳过左子树的第一个元素开始取，个数为e2-index-1  in从index+1开始，取e2-index-1个元素
    rootNode.right = construct(preOrder, scan + 1 + index - b2, scan + e2 - b2, inOrder, index + 1, e2);
    return rootNode;
  }
  static private int indexOf(String[] arr, String key, int begin, int end) {
    for (int i = begin; i <= end; i++) {
      if (arr[i] .equals(key) )
        return i;
    }
    return -1;
  }
  private static class TreeNode<T> {

    public T data;
    public TreeNode<T> left = null;
    public TreeNode<T> right = null;
    public TreeNode<T> parent = null;

    public TreeNode(T data) {
      this.data = data;
    }


  }
}
