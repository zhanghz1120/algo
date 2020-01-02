package tree;

import common.TreeNode;

import java.util.*;

public class _09_path_sum_ii {
    ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> buffer = new ArrayList<Integer>();

    ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int target){
        inOrder(root, buffer, target);
        return ret;
    }

    void inOrder(TreeNode root, ArrayList<Integer> buffer, int target){
        if(root == null){
            return;
        }
        buffer.add(root.val);
        if(isLeaf(root) && target == root.val){
            ArrayList<Integer> tmp = new ArrayList<Integer>(buffer);
            ret.add(tmp);
        }
        inOrder(root.left, buffer, target - root.val);
        inOrder(root.right, buffer, target - root.val);
        buffer.remove(buffer.size() - 1);
    }

    boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null){
            return true;
        }else{
            return false;
        }
    }

}
