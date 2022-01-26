### 数组链表
### 栈/队列
### 数据结构设计
### 二叉树
1.二叉树的最小深度
```java
int run(TreeNode root){
	if(root == null){
	    return 0;
	}
	if(root.left == null && root.right == null){
	    return 1;
	}else if(root.left != null && root.right == null){
	    return 1 + run(root.left);
	}else if(root.left == null && root.right != null){
	    return 1 + run(root.right);
	}else {
	    return 1 + Math.min(run(root.left), run(root.right));
	}
}
```

### 二叉搜索树
### DFS
### BFS
### 回溯
### 动规
### 数学问题


