package com.sivakami.ds.implementation.hashMap;

public class Bucket {
	private BSTTree tree;

	  public Bucket() {
	    tree = new BSTTree();
	  }

	  public void insert(int key, int val) {
	    this.tree.root = this.tree.insertIntoBST(this.tree.root, new Pair(key, val));
	  }

	  public void delete(Integer key) {
	    this.tree.root = this.tree.deleteNode(this.tree.root, key);
	  }

	  public boolean exists(Integer key) {
	    TreeNode node = this.tree.searchBST(this.tree.root, key);
	    return (node != null);
	  }
	  
	  public int fetch(Integer key) {
		TreeNode node = this.tree.searchBST(this.tree.root, key);
		return (node != null) ? node.pair.getValue() : -1;
	  }
}
