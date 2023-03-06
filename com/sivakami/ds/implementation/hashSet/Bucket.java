package com.sivakami.ds.implementation.hashSet;

public class Bucket {
	
	  private BSTTree tree;

	  public Bucket() {
	    tree = new BSTTree();
	  }

	  public void insert(Integer key) {
	    this.tree.root = this.tree.insertIntoBST(this.tree.root, key);
	  }

	  public void delete(Integer key) {
	    this.tree.root = this.tree.deleteNode(this.tree.root, key);
	  }

	  public boolean exists(Integer key) {
	    TreeNode node = this.tree.searchBST(this.tree.root, key);
	    return (node != null);
	  }
}