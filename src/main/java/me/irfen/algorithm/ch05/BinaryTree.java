package me.irfen.algorithm.ch05;

public class BinaryTree {

	private BinaryTreeNode root;

	public BinaryTree() {
	}

	public BinaryTree(BinaryTreeNode root) {
		this.root = root;
	}
	
	/**
	 * 给某节点插入左子节点
	 * @param parent
	 * @param newNode
	 */
	public void insertLeft(BinaryTreeNode parent, BinaryTreeNode newNode) {
		parent.setLeftChild(newNode);
	}

	/**
	 * 给某节点插入右子节点
	 * @param parent
	 * @param newNode
	 */
	public void insertRight(BinaryTreeNode parent, BinaryTreeNode newNode) {
		parent.setRightChild(newNode);
	}

	
	/**
	 * 查找node节点在二叉树中的父节点
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getParent(BinaryTreeNode node) {
		return (root == null || root == node) ? null : getParent(root, node);
	}
	
	/**
	 * 递归查找node节点在subTree子树中的父节点
	 * @param subTree
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getParent(BinaryTreeNode subTree, BinaryTreeNode node) {
		if (subTree == null) {
			// 如果子树为空，则没有父节点
			return null;
		}
		if (subTree.getLeftChild() == node || subTree.getRightChild() == node) {
			// 如果子树树根的左右孩子节点之一是待查节点，那么这个子树树根即为待查节点的父节点
			return subTree;
		}
		BinaryTreeNode parent = null;
		// 先递归在左子树找
		if ((parent = getParent(subTree.getLeftChild(), node)) != null) {
			return parent;
		} else {
			// 递归在右子树找
			return getParent(subTree.getRightChild(), node);
		}
	}
	
	/**
	 * 获取某个节点的左子树
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getLeftTree(BinaryTreeNode node) {
		return node.getLeftChild();
	}
	
	/**
	 * 获取某个节点的右子树
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getRightTree(BinaryTreeNode node) {
		return node.getRightChild();
	}
	
	/**
	 * 获取二叉树的节点个数
	 * @return
	 */
	public int size() {
		return size(root);
	}
	
	/**
	 * 获取某节点为子树的节点个数
	 * @param node
	 * @return
	 */
	public int size(BinaryTreeNode node) {
		if (node == null) {
			// 如果节点为空，返回节点个数为0
			return 0;
		} else {
			// 需要计算本节点，所以加1
			// 递归获取左子树的节点个数及右子树的节点个数，最终相加
			return 1 + size(node.getLeftChild()) + size(node.getRightChild());
		}
	}
	
	/**
	 * 获取二叉树高度
	 * @return
	 */
	public int height() {
		return height(root);
	}
	
	/**
	 * 获取某节点为子树的高度
	 * @param node
	 * @return
	 */
	public int height(BinaryTreeNode node) {
		if (node == null) {
			return 0; // 递归结束，空子树高度为0
		} else {
			// 递归获取左子树高度
			int l = height(node.getLeftChild());
			// 递归获取右子树高度
			int r = height(node.getRightChild());
			// 高度应该算更高的那一边（加1是因为要加上自己这一层）
			return l < r ? r + 1 : l + 1;
		}
	}
	
	/**
	 * 判断二叉树树是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/**
	 * 清空树
	 */
	public void clear() {
		root = null;
	}
	
	/**
	 * 先根遍历
	 * @param node
	 */
	public void preOrder(BinaryTreeNode node) {
		if (node != null) {
			visted(node);
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
		}
	}
	
	/**
	 * 中根遍历
	 * @param node
	 */
	public void inOrder(BinaryTreeNode node) {
		if (node != null) {
			inOrder(node.getLeftChild());
			visted(node);
			inOrder(node.getRightChild());
		}
	}
	
	/**
	 * 后根遍历
	 * @param node
	 */
	public void postOrder(BinaryTreeNode node) {
		if (node != null) {
			postOrder(node.getLeftChild());
			postOrder(node.getRightChild());
			visted(node);
		}
	}
	
	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	
	public BinaryTreeNode getRoot() {
		return root;
	}
	
	private void visted(BinaryTreeNode node) {
        System.out.println(node.getData());
    }
}
