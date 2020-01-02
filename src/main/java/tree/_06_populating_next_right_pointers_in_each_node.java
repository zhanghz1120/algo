package tree;

import common.TreeLinkNode;

/**
 * 填充所有节点的next指针
 *
 * 填充所有节点的next指针，指向它右兄弟节点。如果没有右兄弟节点，则应该将next指针设置为NULL。
 * 初始时，所有的next指针都为NULL
 * 注意：
 * 你只能使用常量级的额外内存空间
 * 可以假设给出的二叉树是一个完美的二叉树(即，所有叶子节点都位于同一层，而且每个父节点都有两个孩子节点)。
 *
 *
 */
public class _06_populating_next_right_pointers_in_each_node {

    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }

        if(root.left != null){
            root.left.next = root.right;
            connect(root.left);
        }
        if(root.right != null){
            if(root.next != null){
                root.right.next = root.next.left;
            }else{
                root.right.next = null;
            }

            connect(root.right);
        }
    }
}
