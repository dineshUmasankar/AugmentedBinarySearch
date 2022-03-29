package com.psu.dqu5021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		if (!testTreeInsertions()) {
			System.err.println("Would you like to continue (y|n)?");
			String choice = sc.next().toLowerCase();
			if (choice.equals("n")) return;
		}
		if (!testTreeDeletions()) {
			System.err.println("Would you like to continue (y|n)?");
			String choice = sc.next().toLowerCase();
			if (choice.equals("n")) return;
		}
		testGet();
	}

	private static boolean testTreeInsertions() {
		System.err.println("Testing tree insertions");
		int[] keys = { 7, 3, 1, 10, 14, 12, 19, 10, 3, 14, 10, 7, 12, 1 };
		String[] expectedTrees = { "data: 7 dataCount: 1 treeSize: 1\n  null\n  null\n",
				"data: 7 dataCount: 1 treeSize: 2\n  data: 3 dataCount: 1 treeSize: 1\n    null\n    null\n  null\n",
				"data: 7 dataCount: 1 treeSize: 3\n  data: 3 dataCount: 1 treeSize: 2\n    data: 1 dataCount: 1 treeSize: 1\n      null\n      null\n    null\n  null\n",
				"data: 7 dataCount: 1 treeSize: 4\n  data: 3 dataCount: 1 treeSize: 2\n    data: 1 dataCount: 1 treeSize: 1\n      null\n      null\n    null\n  data: 10 dataCount: 1 treeSize: 1\n    null\n    null\n",
				"data: 7 dataCount: 1 treeSize: 5\n  data: 3 dataCount: 1 treeSize: 2\n    data: 1 dataCount: 1 treeSize: 1\n      null\n      null\n    null\n  data: 10 dataCount: 1 treeSize: 2\n    null\n    data: 14 dataCount: 1 treeSize: 1\n      null\n      null\n",
				"data: 7 dataCount: 1 treeSize: 6\n  data: 3 dataCount: 1 treeSize: 2\n    data: 1 dataCount: 1 treeSize: 1\n      null\n      null\n    null\n  data: 10 dataCount: 1 treeSize: 3\n    null\n    data: 14 dataCount: 1 treeSize: 2\n      data: 12 dataCount: 1 treeSize: 1\n        null\n        null\n      null\n",
				"data: 7 dataCount: 1 treeSize: 7\n  data: 3 dataCount: 1 treeSize: 2\n    data: 1 dataCount: 1 treeSize: 1\n      null\n      null\n    null\n  data: 10 dataCount: 1 treeSize: 4\n    null\n    data: 14 dataCount: 1 treeSize: 3\n      data: 12 dataCount: 1 treeSize: 1\n        null\n        null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n",
				"data: 7 dataCount: 1 treeSize: 8\n  data: 3 dataCount: 1 treeSize: 2\n    data: 1 dataCount: 1 treeSize: 1\n      null\n      null\n    null\n  data: 10 dataCount: 2 treeSize: 5\n    null\n    data: 14 dataCount: 1 treeSize: 3\n      data: 12 dataCount: 1 treeSize: 1\n        null\n        null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n",
				"data: 7 dataCount: 1 treeSize: 9\n  data: 3 dataCount: 2 treeSize: 3\n    data: 1 dataCount: 1 treeSize: 1\n      null\n      null\n    null\n  data: 10 dataCount: 2 treeSize: 5\n    null\n    data: 14 dataCount: 1 treeSize: 3\n      data: 12 dataCount: 1 treeSize: 1\n        null\n        null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n",
				"data: 7 dataCount: 1 treeSize: 10\n  data: 3 dataCount: 2 treeSize: 3\n    data: 1 dataCount: 1 treeSize: 1\n      null\n      null\n    null\n  data: 10 dataCount: 2 treeSize: 6\n    null\n    data: 14 dataCount: 2 treeSize: 4\n      data: 12 dataCount: 1 treeSize: 1\n        null\n        null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n",
				"data: 7 dataCount: 1 treeSize: 11\n  data: 3 dataCount: 2 treeSize: 3\n    data: 1 dataCount: 1 treeSize: 1\n      null\n      null\n    null\n  data: 10 dataCount: 3 treeSize: 7\n    null\n    data: 14 dataCount: 2 treeSize: 4\n      data: 12 dataCount: 1 treeSize: 1\n        null\n        null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n",
				"data: 7 dataCount: 2 treeSize: 12\n  data: 3 dataCount: 2 treeSize: 3\n    data: 1 dataCount: 1 treeSize: 1\n      null\n      null\n    null\n  data: 10 dataCount: 3 treeSize: 7\n    null\n    data: 14 dataCount: 2 treeSize: 4\n      data: 12 dataCount: 1 treeSize: 1\n        null\n        null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n",
				"data: 7 dataCount: 2 treeSize: 13\n  data: 3 dataCount: 2 treeSize: 3\n    data: 1 dataCount: 1 treeSize: 1\n      null\n      null\n    null\n  data: 10 dataCount: 3 treeSize: 8\n    null\n    data: 14 dataCount: 2 treeSize: 5\n      data: 12 dataCount: 2 treeSize: 2\n        null\n        null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n",
				"data: 7 dataCount: 2 treeSize: 14\n  data: 3 dataCount: 2 treeSize: 4\n    data: 1 dataCount: 2 treeSize: 2\n      null\n      null\n    null\n  data: 10 dataCount: 3 treeSize: 8\n    null\n    data: 14 dataCount: 2 treeSize: 5\n      data: 12 dataCount: 2 treeSize: 2\n        null\n        null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n"};
		try {
			BSTNode root = null;
			for (int i = 0; i < keys.length; i++) {
				root = BSTNode.insert(root,  keys[i]);
				String tree = traversal(root, "");
				if (!tree.equals(expectedTrees[i])) {
					System.err.println("Mismatched tree after " + (i+1) + " insertions.");
					System.err.println("EXPECTED TREE:");
					System.err.println(expectedTrees[i]);
					System.err.println("ACTUAL TREE:");
					System.err.println(tree);
					return false;
				}					
			}
		}
		catch (Exception e) {
			System.err.println("Exception occurred during tree insertions: " + e);
			return false;
		}
		System.err.println("Passed tree insertion tests");
		return true;
	}

	
	private static boolean testTreeDeletions() {
		System.err.println("Testing tree deletions");
		int[] insert_keys = { 7, 3, 1, 10, 14, 12, 19, 10, 3, 14, 10, 7, 12, 1, 13 };
		int[] delete_keys = { 14, 14, 7, 7, 3, 1, 10, 12, 12, 19, 10, 3, 10, 1, 13 };
		String startTree = "data: 7 dataCount: 2 treeSize: 15\n  data: 3 dataCount: 2 treeSize: 4\n    data: 1 dataCount: 2 treeSize: 2\n      null\n      null\n    null\n  data: 10 dataCount: 3 treeSize: 9\n    null\n    data: 14 dataCount: 2 treeSize: 6\n      data: 12 dataCount: 2 treeSize: 3\n        null\n        data: 13 dataCount: 1 treeSize: 1\n          null\n          null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n";
		String[] expectedTrees = { "data: 7 dataCount: 2 treeSize: 14\n  data: 3 dataCount: 2 treeSize: 4\n    data: 1 dataCount: 2 treeSize: 2\n      null\n      null\n    null\n  data: 10 dataCount: 3 treeSize: 8\n    null\n    data: 14 dataCount: 1 treeSize: 5\n      data: 12 dataCount: 2 treeSize: 3\n        null\n        data: 13 dataCount: 1 treeSize: 1\n          null\n          null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n",
								"data: 7 dataCount: 2 treeSize: 13\n  data: 3 dataCount: 2 treeSize: 4\n    data: 1 dataCount: 2 treeSize: 2\n      null\n      null\n    null\n  data: 10 dataCount: 3 treeSize: 7\n    null\n    data: 13 dataCount: 1 treeSize: 4\n      data: 12 dataCount: 2 treeSize: 2\n        null\n        null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n",
								"data: 7 dataCount: 1 treeSize: 12\n  data: 3 dataCount: 2 treeSize: 4\n    data: 1 dataCount: 2 treeSize: 2\n      null\n      null\n    null\n  data: 10 dataCount: 3 treeSize: 7\n    null\n    data: 13 dataCount: 1 treeSize: 4\n      data: 12 dataCount: 2 treeSize: 2\n        null\n        null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n",
								"data: 3 dataCount: 2 treeSize: 11\n  data: 1 dataCount: 2 treeSize: 2\n    null\n    null\n  data: 10 dataCount: 3 treeSize: 7\n    null\n    data: 13 dataCount: 1 treeSize: 4\n      data: 12 dataCount: 2 treeSize: 2\n        null\n        null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n",
								"data: 3 dataCount: 1 treeSize: 10\n  data: 1 dataCount: 2 treeSize: 2\n    null\n    null\n  data: 10 dataCount: 3 treeSize: 7\n    null\n    data: 13 dataCount: 1 treeSize: 4\n      data: 12 dataCount: 2 treeSize: 2\n        null\n        null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n",
								"data: 3 dataCount: 1 treeSize: 9\n  data: 1 dataCount: 1 treeSize: 1\n    null\n    null\n  data: 10 dataCount: 3 treeSize: 7\n    null\n    data: 13 dataCount: 1 treeSize: 4\n      data: 12 dataCount: 2 treeSize: 2\n        null\n        null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n",
								"data: 3 dataCount: 1 treeSize: 8\n  data: 1 dataCount: 1 treeSize: 1\n    null\n    null\n  data: 10 dataCount: 2 treeSize: 6\n    null\n    data: 13 dataCount: 1 treeSize: 4\n      data: 12 dataCount: 2 treeSize: 2\n        null\n        null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n",
								"data: 3 dataCount: 1 treeSize: 7\n  data: 1 dataCount: 1 treeSize: 1\n    null\n    null\n  data: 10 dataCount: 2 treeSize: 5\n    null\n    data: 13 dataCount: 1 treeSize: 3\n      data: 12 dataCount: 1 treeSize: 1\n        null\n        null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n",
								"data: 3 dataCount: 1 treeSize: 6\n  data: 1 dataCount: 1 treeSize: 1\n    null\n    null\n  data: 10 dataCount: 2 treeSize: 4\n    null\n    data: 13 dataCount: 1 treeSize: 2\n      null\n      data: 19 dataCount: 1 treeSize: 1\n        null\n        null\n",
								"data: 3 dataCount: 1 treeSize: 5\n  data: 1 dataCount: 1 treeSize: 1\n    null\n    null\n  data: 10 dataCount: 2 treeSize: 3\n    null\n    data: 13 dataCount: 1 treeSize: 1\n      null\n      null\n",
								"data: 3 dataCount: 1 treeSize: 4\n  data: 1 dataCount: 1 treeSize: 1\n    null\n    null\n  data: 10 dataCount: 1 treeSize: 2\n    null\n    data: 13 dataCount: 1 treeSize: 1\n      null\n      null\n",
								"data: 1 dataCount: 1 treeSize: 3\n  null\n  data: 10 dataCount: 1 treeSize: 2\n    null\n    data: 13 dataCount: 1 treeSize: 1\n      null\n      null\n",
								"data: 1 dataCount: 1 treeSize: 2\n  null\n  data: 13 dataCount: 1 treeSize: 1\n    null\n    null\n",
								"data: 13 dataCount: 1 treeSize: 1\n  null\n  null\n",
								"null\n"};
		try {
			BSTNode root = null;
			for (int i = 0; i < insert_keys.length; i++) {
				root = BSTNode.insert(root,  insert_keys[i]);
			}
			String tree = traversal(root, "");
			if (!tree.equals(startTree)) {
				System.err.println("Could not run delete tests. Mismatched tree prior to starting the deletions.");
				System.err.println("EXPECTED TREE:");
				System.err.println(startTree);
				System.err.println("ACTUAL TREE:");
				System.err.println(tree);
				return false;
			}
			String lastTree = startTree;
			for (int i = 0; i < delete_keys.length; i++) {
				root = BSTNode.delete(root,  delete_keys[i]);
				tree = traversal(root, "");
				if (!tree.equals(expectedTrees[i])) {
					System.err.println("Mismatched tree after " + (i+1) + " deletions.");
					System.err.println("INITIAL TREE:");
					System.err.println(lastTree);
					System.err.println("EXPECTED TREE after deleting " + delete_keys[i] + ":");
					System.err.println(expectedTrees[i]);
					System.err.println("ACTUAL TREE:");
					System.err.println(tree);
					return false;
				}
				lastTree = expectedTrees[i];
			}
			
		}
		catch (Exception e) {
			System.err.println("Exception occurred during tree insertions: " + e.getMessage());
			return false;
		}
		System.err.println("Passed tree deletion tests");
		return true;
	}

	private static boolean testGet() {
		System.err.println("Testing get(root, n)");
		int[] insert_keys = { 7, 3, 1, 10, 14, 12, 19, 10, 3, 14, 10, 7, 12, 1, 13 };
		int[] delete_keys = { 14, 14, 7, 7, 3, 1, 10, 12, 12, 19, 10, 3, 10, 1, 13 };
		ArrayList<Integer> keys = new ArrayList<>();
		
		BSTNode root = null;
		for (int i = 0; i < insert_keys.length; i++) {
			root = BSTNode.insert(root, insert_keys[i]);
			keys.add(insert_keys[i]);
			Collections.sort(keys);
			for (int j = 0; j < keys.size(); j++) {
				if (BSTNode.get(root, j) != keys.get(j)) {
					System.err.println("Error on get(" + j + ") during insertions.  Expected "+ keys.get(j) + " but received " + BSTNode.get(root, j));
					System.err.println("Tree:");
					System.err.println(traversal(root, ""));
					return false;
				}
			}
		}
		for (int i = 0; i < delete_keys.length; i++) {
			root = BSTNode.delete(root, delete_keys[i]);
			keys.remove(new Integer(delete_keys[i]));
			Collections.sort(keys);
			for (int j = 0; j < keys.size(); j++) {
				if (BSTNode.get(root, j) != keys.get(j)) {
					System.err.println("Error on get(root," + j + ") during deletions.  Expected "+ keys.get(j) + " but received " + BSTNode.get(root,j));
					System.err.print("Keys: <");
					for (int k: keys) System.err.print(" " + k + " ");
					System.err.println(">");
					System.err.println("Tree:");
					System.err.println(traversal(root, ""));
					return false;
				}
			}
		}
		System.err.println("Passed get(root,n) tests");
		return true;
	}

	private static String traversal(BSTNode root, String indent) {
		if (root == null) return indent + "null\n";
		StringBuffer sb = new StringBuffer();
		sb.append(indent);
		sb.append("data: ");
		sb.append(root.data());
		sb.append(" dataCount: ");
		sb.append(root.dataCount());
		sb.append(" treeSize: ");
		sb.append(root.treeSize());
		sb.append("\n");
		sb.append(traversal(root.LC(), indent + "  "));
		sb.append(traversal(root.RC(), indent + "  "));
		return sb.toString();
	}
}
