package tree;
import common.TreeNode;

import java.util.*;

/**
 *
 * 给定一个仅包含数字0-9的二叉树，每一条从根节点到叶子节点的路径都可以用一个数字表示。
 * 例如根节点到叶子节点的一条路径是1->2->3,那么这条路径就用123来代替。
 * 找出根节点到叶子节点的所有路径表示的数字之和
 *
 *
 */
public class _04_sum_root_to_leaf_numbers {
    ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> buffer = new ArrayList<Integer>();

    boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null){
            return true;
        }else{
            return false;
        }
    }

    public int sumNumbers(TreeNode root) {
        if(root == null /*|| root.val == 0*/){
            return 0;
        }
        inOrder(buffer, root);
        int sum = 0;
        for(List<Integer> buff : ret){
            int ele = 0;
            for(int i = 0; i<buff.size(); i++){
                int x = buff.get(i);
                int y = buff.size() - 1 - i;
                ele += x * Math.pow(10, y);
            }

            //System.out.println("ele = " + ele);
            sum += ele;
        }
        return sum;
    }

    void inOrder(List<Integer> buffer, TreeNode root){
        if(root == null){
            return;
        }
        buffer.add(root.val);
        if(isLeaf(root)){
            ret.add(new ArrayList<Integer>(buffer));
        }
        inOrder(buffer, root.left);
        inOrder(buffer, root.right);
        buffer.remove(buffer.size() - 1);
    }

}
