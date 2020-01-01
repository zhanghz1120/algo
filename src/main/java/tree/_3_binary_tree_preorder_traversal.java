package tree;

import java.util.*;
/**
 * 二叉树的先序遍历,迭代算法
 *
 *
 *
 *
 */
public class _3_binary_tree_preorder_traversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null){
            return ret;
        }

        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();

            ret.add(node.val);

            // 先放右子树再放左子树
            if(node.right != null){
                stack.push(node.right);
            }

            if(node.left != null){
                stack.push(node.left);
            }

        }
        return ret;
    }

}
