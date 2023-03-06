package com.sivakami.ds.implementation.hashMap;

public class BSTTree {
	TreeNode root;
	
	public TreeNode insertIntoBST(TreeNode root, Pair<Integer, Integer> pair) {
	    if (root == null)
	      return new TreeNode(pair);
	    if (pair.getKey() == root.pair.getKey()) {
	    	root.pair.setValue(pair.getValue());
	    	return root;
	    }
	    // insert into the right subtree
	    if (pair.getKey() > root.pair.getKey())   
	      root.right = insertIntoBST(root.right, pair);
	    // insert into the left subtree
	    else                 
	      root.left = insertIntoBST(root.left, pair);
	    return root;
	  }
	
	 
	public TreeNode deleteNode(TreeNode root, Integer key) {
	    if (root == null)
	      return null;

	    if (key > root.pair.getKey()) 		// delete from the right subtree
	      root.right = deleteNode(root.right, key);
	    else if (key < root.pair.getKey())	// delete from the left subtree
	      root.left = deleteNode(root.left, key);
	    else {						// delete the current node
	      if (root.left == null && root.right == null)				// the node is a leaf
	        root = null;
	      else if (root.right != null) {							// the node is not a leaf and has a right child
	        root.pair = successor(root);
	        root.right = deleteNode(root.right, root.pair.getKey());
	      }else {													// the node is not a leaf, has no right child, and has a left child
	        root.pair = predecessor(root);
	        root.left = deleteNode(root.left, root.pair.getKey());
	      }
	    }
	    return root;
	  }
	  
	
	
	//One step right and then always left
	  public Pair<Integer, Integer> successor(TreeNode root) {
		  
		    root = root.right;
		    while (root.left != null)
		      root = root.left;
		    return root.pair;
	  }

	  //One step left and then always right
	  public Pair<Integer, Integer> predecessor(TreeNode root) {
		  
		    root = root.left;
		    while (root.right != null)
		      root = root.right;
		    return root.pair;
	  }
	  
	  
	  public TreeNode searchBST(TreeNode root, int key) {
		  
		    if (root == null || key == root.pair.getKey())
		      return root;
	
		    return key < root.pair.getKey() ? searchBST(root.left, key) : searchBST(root.right, key);
	  }

}
