package tree;


import common.TreeLinkNode;
import common.TreeNode;

import java.util.*;


public class TreeAlgo {

    boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 是否是对称二叉树
     *
     * @param root
     * @return
     */
    boolean isSymmetrical(TreeNode root){
        if(root == null){
            return true;
        }
        return isSymmetrical(root.left, root.right);
    }

    boolean isSymmetrical(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }else if(root1 == null && root2 != null){
            return false;
        }else if(root1 != null && root2 == null){
            return false;
        }else{
            if(root1.val != root2.val){
                return false;
            }else{
                return isSymmetrical(root1.left, root2.right)
                        && isSymmetrical(root1.right, root2.left);
            }
        }
    }

    /**
     * 二叉树是否相等
     *
     */
    boolean isEqual(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }else if(root1 == null && root2 != null){
            return false;
        }else if(root1 != null && root2 == null){
            return false;
        }else{
            if(root1.val != root2.val){
                return false;
            }else{
                return isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
            }

        }
    }

    // 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
    // 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
    // 题目没读懂？？？
    public TreeLinkNode GetNext(TreeLinkNode root) {
        return null;
    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        return null;
    }

    // 判断一棵二叉树是否平衡
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }else{
            //return depth(root.left) - depth(root.right) ;
        }
        return false;
    }

    // 计算一棵二叉树的最大高度
    int depth(TreeNode root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }else if(root.left != null && root.right == null){
            return 1 + depth(root.left);
        }else if(root.left == null && root.right != null){
            return 1 + depth(root.right);
        }else{
            return 1 + Math.max(depth(root.left), depth(root.right));
        }
    }


}
