package com.sivakami.ds.implementation.hashSet;

public class BSTTree {
	
	  TreeNode root = null;

	  public TreeNode searchBST(TreeNode root, int val) {
	    if (root == null || val == root.val)
	      return root;

	    return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
	  }

	  public TreeNode insertIntoBST(TreeNode root, int val) {
	    if (root == null)
	      return new TreeNode(val);

	    if (val > root.val)   // insert into the right subtree
	      root.right = insertIntoBST(root.right, val);
	    else if (val == root.val)
	      return root;
	    else                 // insert into the left subtree
	      root.left = insertIntoBST(root.left, val);
	    return root;
	  }

	  //One step right and then always left
	  public int successor(TreeNode root) {
	    root = root.right;
	    while (root.left != null)
	      root = root.left;
	    return root.val;
	  }

	  //One step left and then always right
	  public int predecessor(TreeNode root) {
	    root = root.left;
	    while (root.right != null)
	      root = root.right;
	    return root.val;
	  }

	  public TreeNode deleteNode(TreeNode root, int key) {
	    if (root == null)
	      return null;

	    if (key > root.val) 		// delete from the right subtree
	      root.right = deleteNode(root.right, key);
	    else if (key < root.val)	// delete from the left subtree
	      root.left = deleteNode(root.left, key);
	    else {						// delete the current node
	      if (root.left == null && root.right == null)				// the node is a leaf
	        root = null;
	      else if (root.right != null) {							// the node is not a leaf and has a right child
	        root.val = successor(root);
	        root.right = deleteNode(root.right, root.val);
	      }else {													// the node is not a leaf, has no right child, and has a left child
	        root.val = predecessor(root);
	        root.left = deleteNode(root.left, root.val);
	      }
	    }
	    return root;
	  }
	  
}