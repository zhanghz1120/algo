package tree;

import common.TreeNode;

import java.util.*;

public class _10_print_binary_tree_each_layer {
    public ArrayList<ArrayList<Integer>> solution(TreeNode root){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        if(root == null){
            return ret;
        }
        ArrayList<Integer> buffer = new ArrayList<Integer>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int x = 1;
        int y = 0;
        int flag = 1;
        while(queue.size() > 0){
            TreeNode node = queue.poll();
            buffer.add(node.val);
            x--;

            if(node.left != null){
                queue.offer(node.left);
                y++;
            }
            if(node.right != null){
                queue.offer(node.right);
                y++;
            }

            if(x == 0){
                x = y;
                y = 0;
                if(flag == 1){
                    Collections.reverse(buffer);
                }
                flag = flag * (-1);
                ret.add(new ArrayList<Integer>(buffer));
                buffer.clear();
            }
        }

        return ret;
    }


}
