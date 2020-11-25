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

    public int minDeletionSize (String[] A) {
        // write code here
        int count = 0;
        int row = A[0].length();
        int column = A.length;

        int[] ret = new int[row];
        for(int i = 0; i<row; i++){
            for(int j = 0; j< column-1; j++){
                if(A[j].charAt(i) > A[j+1].charAt(i)){
                    ret[i] = 1;
                    continue;
                }
            }
        }

        int index = -1;
        for(int i = 0; i<ret.length; i++){
            if(ret[i] == 0){
                index = i;
                break;
            }
        }

        if(index == -1){
            //count = ret.length;
            return ret.length;
        }

        for(int i = 0; i<=index; i++){
            if(ret[i] == 1){
                count++;
            }
        }

        System.out.println(Arrays.toString(ret));
        System.out.println(count);
        System.out.println(index);
        return count;
    }

    /**
     *
     * @param A int整型一维数组
     * @return int整型
     */
    public int maxWidth (int[] A) {
        // write code here
        for(int width = A.length-1; width>= 1; width--){
            for(int i = 0; i<A.length-width; i++){
                if(A[i] <= A[i + width]){
                    return width;
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        String[] A = new String[]{"zyx", "wvu", "tsr"};
        String[] A2 = new String[]{"xc", "yb", "za"};
        String[] A3 = new String[]{"ca", "bb", "ac"};
        int count = new _10_print_binary_tree_each_layer().minDeletionSize(A);
        System.out.println(count );
    }



}
