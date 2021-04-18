package com.test.week03;

import java.util.Arrays;

public class BuildTree {

    /**
     * 递归法1：根据前序得到根节点，再拆分中序。得到左/右前序和中序。再递归到下一层
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0) {
            return null;
        }
        // 根据前序数组的第一个元素确定根节点
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=0;i < preorder.length; ++i) {
            // 根据前序根节点获取中序拆分点
            if(preorder[0] == inorder[i]) {
                // 拆分得到根节点的前序左数组
                int[] pre_left = Arrays.copyOfRange(preorder, 1, i + 1);
                // 拆分得到根节点的前序右数组
                int[] pre_right = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                // 拆分得到根节点的中序左数组
                int[] in_left = Arrays.copyOfRange(inorder, 0, i);
                // 拆分得到根节点的中序右数组
                int[] in_right = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                // 左子树递归到下一层
                root.left = buildTree(pre_left, in_left);
                // 右子树递归到下一层
                root.right = buildTree(pre_right, in_right);
                break;
            }
        }
        return root;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
