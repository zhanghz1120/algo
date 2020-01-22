package tree;

import common.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 判断给定的二叉树是否是平衡的
 * 在这个问题中，定义平衡二叉树为每个节点的左右两个子树高度差的绝对值不超过1的二叉树
 *
 *
 */
public class _11_balanced_binary_tree {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        //System.out.println(root.val + " ");
        int left_depth = depth(root.left);
        int right_depth = depth(root.right);
        if(left_depth - right_depth < -1 || left_depth - right_depth > 1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    int depth(TreeNode root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }else{
            return 1 + Math.max(depth(root.left), depth(root.right));
        }
    }

    @Test
    public void testDepth(){
        _11_balanced_binary_tree object = new _11_balanced_binary_tree();
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(2);
        TreeNode node9 = new TreeNode(1);
        TreeNode node10 = new TreeNode(0);
        TreeNode node11 = new TreeNode(8);
        TreeNode node12 = new TreeNode(8);
        TreeNode node13 = new TreeNode(7);

        //TreeNode node8 = new TreeNode(1);
        // TreeNode node9 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;

        node5.left = node9;
        node5.right = node10;

        node7.left = node11;
        node7.right = node12;

        node10.left = node13;

        int depth = object.depth(node1);

        Assert.assertEquals(4, depth);
    }


}
