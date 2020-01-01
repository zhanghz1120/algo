package tree;


import java.util.*;


public class TreeAlgo {

    /**
     * 之字型打印二叉树
     *
     *
     * @param root
     */
    void print(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(root);

        while(queue1.size() > 0 || queue2.size() > 0){
            if(queue1.size() > 0){
                while(queue1.size() > 0){
                    TreeNode treeNode = queue1.poll();
                    System.out.print(treeNode.val + " ");
                    TreeNode left = treeNode.left;
                    TreeNode right = treeNode.right;

                    if(left != null){
                        queue2.offer(left);
                    }
                    if(right != null){
                        queue2.offer(right);
                    }
                }
            }else{
                while(queue2.size() > 0){
                    TreeNode treeNode = queue2.poll();
                    System.out.print(treeNode.val + " ");

                    TreeNode left = treeNode.left;
                    TreeNode right = treeNode.right;

                    if(left != null){
                        queue1.offer(left);
                    }
                    if(right != null){
                        queue1.offer(right);
                    }
                }
            }
            System.out.println();
        }
    }

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

    // 按层打印二叉树
    ArrayList<ArrayList<Integer> > Print(TreeNode root) {
        ArrayList<ArrayList<Integer> > ret = new ArrayList<ArrayList<Integer> >();
        if(root == null){
            return ret;
        }

        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(root);
        while(queue1.size() > 0 || queue2.size() > 0){
            if(queue1.size() > 0){
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                while(queue1.size() > 0){
                    TreeNode node = queue1.poll();
                    tmp.add(node.val);
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    if(left != null){
                        queue2.offer(left);
                    }
                    if(right != null){
                        queue2.offer(right);
                    }
                }
                ret.add(tmp);
            }else{
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                while(queue2.size() > 0){
                    TreeNode node = queue2.poll();
                    tmp.add(node.val);
                    TreeNode left = node.left;
                    TreeNode right = node.right;

                    if(left != null){
                        queue1.offer(left);
                    }
                    if(right != null){
                        queue1.offer(right);
                    }
                }
                ret.add(tmp);
            }
        }
        return ret;
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



    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode(2);
        TreeLinkNode node2 = new TreeLinkNode(1);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(0);
        TreeLinkNode node5 = new TreeLinkNode(7);
        TreeLinkNode node6 = new TreeLinkNode(9);
        TreeLinkNode node7 = new TreeLinkNode(1);
        TreeLinkNode node8 = new TreeLinkNode(2);
        TreeLinkNode node9 = new TreeLinkNode(1);
        TreeLinkNode node10 = new TreeLinkNode(0);
        TreeLinkNode node11 = new TreeLinkNode(8);
        TreeLinkNode node12 = new TreeLinkNode(8);
        TreeLinkNode node13 = new TreeLinkNode(7);

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



        //node2.left = node4;
        //node2.right = node5;

        //node2.left = node4;
        //node2.right = node5;

       // node3.left = node6;
        //node3.right = node7;

        //node4.left = node8;


        /*
        ArrayList<ArrayList<Integer>> ret = new TreeAlgo(). path(node1, 12);
        for(ArrayList<Integer> arrayList : ret){
            for(Integer i : arrayList){
                System.out.print(i + " ");
            }
            System.out.println();
        }
         */

        //boolean ret = new TreeAlgo().isSymmetrical(node1);
        //System.out.println(ret);
        TreeAlgo treeAlgo = new TreeAlgo();
        //treeAlgo.sumNumbers(node1);
       // System.out.println(treeAlgo.sumNumbers(node1));

        //System.out.println(Arrays.toString(treeAlgo.ret.toArray()));
        //treeAlgo.maxPathSum(node1);
         //treeAlgo.connect(node1);

        System.out.println(node1);
        //System.out.println(treeAlgo.maxPathSum);
    }







}
