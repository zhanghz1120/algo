package tree;

import common.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * 给出一棵树的中序遍历和后序遍历，请构造这颗二叉树
 * 注意：
 * 保证给出的树中不存在重复的节点
 *
 */
public class _13_construct_binary_tree_from_inorder_and_postorder_traversal {
    static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    public TreeNode build(int[] inorder, int[] post_order, int i1, int j1, int i2, int j2){
        if(i1 > j1){
            return null;
        }

        TreeNode root = new TreeNode(post_order[j2]);
        int mid = map.get(root.val);

        int leftLength = mid-i1;
        int rightLength= j1-mid;

        TreeNode left = build(inorder, post_order, i1, i1+leftLength-1, i2, i2+leftLength-1);
        TreeNode right = build(inorder, post_order, j1-rightLength+1, j1, j2-rightLength, j2-1);
        root.left = left;
        root.right = right;
        return root;
    }

    @Test
    public void testBuildTree(){
        _13_construct_binary_tree_from_inorder_and_postorder_traversal obj =
                new _13_construct_binary_tree_from_inorder_and_postorder_traversal();

        int[] inorder = {5, 0, 6, 1, 2, 8, 3};
        int[] post_order = {5, 6, 0, 1, 8, 3, 2};
        TreeNode root = obj.buildTree(inorder, post_order);

        System.out.println(Arrays.toString(TreeNode.printTree(root).toArray()));
    }

}
