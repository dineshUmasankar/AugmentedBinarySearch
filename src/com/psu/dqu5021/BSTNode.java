package com.psu.dqu5021;

public class BSTNode {
	private int data;      // the key value stored at this node
	private int dataCount; // the number of keys with value equal to data stored at this node
	private int treeSize;  // the number of keys stored in the subtree rooted at this node
	private BSTNode leftChild;
	private BSTNode rightChild;

	/**
	 * Constructor - create a node with no children
	 * 
	 * @param data the data value stored at this node
	 */
	public BSTNode(int data) { 
		this.data = data; 
	}

	// Getter methods
	public int data() { return data; }
	public int dataCount() { return dataCount; }
	public int treeSize() { return treeSize; }
	public BSTNode LC() { return leftChild; }
	public BSTNode RC() { return rightChild; }

	/**
	 * Return the nth largest data value in the subtree rooted at this node.
	 * Imagine that the data values were stored in a sorted, 0-based array, with duplicate
	 * values allowed.  The return values would be the one stored in the array at 
	 * index n.
	 * 
	 * Note that this method must run in O(h) where h = height of the tree.
	 * 
	 * @return the nth data value, from a sorted list  
	 */
	public static int get(BSTNode node, int n) {

		// TODO: Implement this method 
		return 0; 
	}

	/**
	 * Search for a value
	 * 
	 * @param node the root
	 * @param x the target data value
	 * 
	 * @return true if the binary search tree contains the target value, and false otherwise
	 */
	public static boolean search(BSTNode node, int x) {
		if (node == null) {
			return false;
		}

		if (x == node.data) {
			return true;
		}
		else if (x < node.data) {
			return search(node.leftChild, x);
		}
		else {
			return search(node.rightChild, x);
		}
	}

	public static BSTNode find(BSTNode root, int x) {
		BSTNode traversal = root;

		while (traversal != null) {
			if (traversal.data > x)
				traversal = traversal.LC();
			else if (traversal.data < x)
				traversal = traversal.RC();
			else // When traversal.data == x aka found node's existence
				return traversal;
		}

		// Node does not exist
		return null;
	}

	public static void updateTreeSizeInsert(BSTNode root, BSTNode upToThisNode)
	{
		BSTNode traversal = root;
		while (traversal != upToThisNode)
		{
			if (traversal.data > upToThisNode.data) {
				traversal.treeSize++;
				traversal = traversal.LC();
			}
			else {
				traversal.treeSize++;
				traversal = traversal.RC();
			}
		}
	}

	/**
	 * Insert a new value into the collection
	 *  
	 * @param root the root of the tree
	 * @param data the new value
	 * 
	 * @return the root of the tree after the insertion
	 */
	public static BSTNode insert(BSTNode root, int data) {
		// TODO: Change this method, as follows:
		// A) Allow duplicate data values in the tree. If the data value already exists in 
		//    the tree, increment the dataCount value.
		// B) Increment the treeSize for all ancestors of the node,
		//    to reflect the fact that a new data value was added to these subtrees

		if (root == null) {
			root = new BSTNode(data);
			root.dataCount = 1;
			root.treeSize = 1;
			root.leftChild = null;
			root.rightChild = null;
		}
		else {
			BSTNode checkNodeExists = find(root, data);
			if (checkNodeExists != null) {
				checkNodeExists.dataCount++;
				checkNodeExists.treeSize++;
				updateTreeSizeInsert(root, checkNodeExists);
			}
			else {
				// Do regular insert algorithm for unique node insert
				BSTNode traversal = root;
				while (data != traversal.data) {
					if (data < traversal.data) {
						if (traversal.leftChild == null) {
							traversal.leftChild = new BSTNode(data);
							traversal.leftChild.dataCount++;
							traversal.leftChild.treeSize++;
							updateTreeSizeInsert(root, traversal.leftChild);
						}
						traversal = traversal.leftChild;
					}
					else {
						if (traversal.rightChild == null) {
							traversal.rightChild = new BSTNode(data);
							traversal.rightChild.dataCount++;
							traversal.rightChild.treeSize++;
							updateTreeSizeInsert(root, traversal.rightChild);
						}
						traversal = traversal.rightChild;
					}
				}
			}
		}
		return root;
	}

	/**
	 * Remove a value x from a binary search tree
	 * 
	 * @precondition the value must be present in the tree
	 * 
	 * @param root the root of the binary search tree
	 * @param x the value, which must be in the tree
	 * 
	 * @return the root of the tree
	 */
	public static BSTNode delete(BSTNode root, int x) {
		// TODO: Change this method, as follows:
		// A) Find the node, and decrement the dataCount value.
		// B) Only remove the node from the tree if the dataCount value is 0.
		// C) Decrement the treeSize for all ancestors of the node,
		//    to reflect the fact that a data value was removed from these subtrees

		BSTNode checkNodeExists = find(root, x);

		BSTNode node = root;
		BSTNode parent = null;
		while (node != null && node.data != x) {
			parent = node;
			if (x < node.data) {
				node = node.leftChild;
			}
			else {
				node = node.rightChild;
			}
		}

		if (node == null) {
			throw new IllegalArgumentException("Key " + x + " was not present in the tree.");
		}

		if (node.leftChild == null && node.rightChild == null) {
			// Case 1: the node containing x is a leaf
			if (parent == null) root = null;
			else if (node == parent.leftChild) parent.leftChild = null;
			else parent.rightChild = null;
		}
		else if (node.leftChild == null || node.rightChild == null) {
			// Case 2: the node containing x has one child
			BSTNode child = (node.leftChild != null) ? node.leftChild : node.rightChild;
			if (parent == null) root = child;
			else if (node == parent.leftChild) parent.leftChild = child;
			else parent.rightChild = child;
		}
		else {
			// Case 3: node has two children
			BSTNode predecessor = getLargestNode(node.leftChild);
			node.data = predecessor.data;
			node.leftChild = delete(node.leftChild, predecessor.data);
		}
		return root;
	}


	/**
	 * Get the node with the largest value in a BST
	 * 
	 * @param node the root of the tree
	 * @return the node with the largest value
	 */
	public static BSTNode getLargestNode(BSTNode node) {
		while (node.rightChild != null) {
			node = node.rightChild;
		}
		return node;
	}
}