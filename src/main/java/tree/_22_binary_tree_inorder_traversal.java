package tree;

import common.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 给出一棵二叉树，返回这棵树的中序遍历,非递归算法
 * 例如：
 * 给出的二叉树为{1,#,2,3},
 *
 *
 */
public class _22_binary_tree_inorder_traversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (root == null){
            return ret;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        TreeNode tmp = root;

        while(stack.size() > 0 || tmp != null){
            while(tmp != null){
                stack.push(tmp);
                tmp = tmp.left;
            }

            TreeNode node = stack.pop();
            ret.add(node.val);
            tmp = node.right;
        }
        return ret;
    }

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    @Test
    public void testInorderTraversal(){
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        //ArrayList<Integer> ret = new _22_binary_tree_inorder_traversal().inorderTraversal(node1);
        //System.out.println(Arrays.toString(ret.toArray()));
        new _22_binary_tree_inorder_traversal().inorder(node1);
    }

}
