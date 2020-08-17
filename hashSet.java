
import java.util.*;
import java.lang.*;

public class hashSet {
	
	private bucket[] arr;
	private int range;
	hashSet(){
		this.range = 769;
		this.arr = new bucket[this.range];
		for(int i=0;i<this.range;++i) {
			this.arr[i] = new bucket();
		}
	}
	
	public void add(int value) {

		this.arr[value%this.range].insert(value);
	}
	public boolean contains(int value) {
		
		return this.arr[value%this.range].exists(value);
	}
	
	public void remove(int value) {
		this.arr[value%this.range].delete(value);
	}

	public static void main(String[] args) {
		
		hashSet Hasset = new hashSet();
		Hasset.add(10);
		Hasset.add(20);
		Hasset.add(40);
		Hasset.add(11);
		Hasset.add(769);
		Hasset.add(121);
		System.out.println("is the value 20 present in the Hashset? "+Hasset.contains(20));
		System.out.println("is the value 20 present in the Hashset? "+Hasset.contains(121));
		System.out.println("is the value 769 present in the Hashset? "+Hasset.contains(769));

		Hasset.remove(121);
		System.out.println("is the value 121 present in the Hashset? "+Hasset.contains(121));
		System.out.println("is the value 10 present in the Hashset? "+Hasset.contains(10));
		Hasset.remove(40);
		System.out.println("is the value 40 present in the Hashset? "+Hasset.contains(40));

	}
}

 class TreeNode{
		int value;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			value=x;
		}
 }

 class bucket {
	  private BSTree tree;
	
	  public bucket() {
	    tree = new BSTree();
	  }
	
	  public void insert(int value) {
	    this.tree.root = this.tree.insertIntoBST(this.tree.root, value);
	  }
	
	  public void delete(int value) {
	    this.tree.root = this.tree.deleteNode(this.tree.root, value);
	  }
	
	  public boolean exists(int value) {
	    TreeNode node = this.tree.searchBST(this.tree.root, value);
	    return (node != null);
	  }
 }


 class BSTree {
	  TreeNode root = null;
	
	  public TreeNode searchBST(TreeNode root, int value) {
		    if (root == null || value == root.value)
		      return root;
		
		    return value < root.value ? searchBST(root.left, value) : searchBST(root.right, value);
	  }
	
	  public TreeNode insertIntoBST(TreeNode root, int value) {
		    if (root == null)
		      return new TreeNode(value);
		
		    if (value < root.value)
		      root.left = insertIntoBST(root.left, value);
		    else if(value > root.value)
		        root.right = insertIntoBST(root.right, value);
		    else
		        return root;
		   	return root;
  }

  public int successor(TreeNode root) {
	    root = root.right;
	    while (root.left != null)
	      root = root.left;
	    return root.value;
  }

  public int predecessor(TreeNode root) {
	    root = root.left;
	    while (root.right != null)
	      root = root.right;
	    return root.value;
  }

  public TreeNode deleteNode(TreeNode root, int value) {
	    if (root == null)
	      return null;
	
	    if (value > root.value)
	    	root.right = deleteNode(root.right, value);
	    else if (value < root.value)
	    	root.left = deleteNode(root.left, value);
	    else {
		      if (root.left == null && root.right == null)
		    	  root = null;
		      else if (root.right != null) {
			        root.value = successor(root);
			        root.right = deleteNode(root.right, root.value);
		      }
		      else {
			        root.value = predecessor(root);
			        root.left = deleteNode(root.left, root.value);
		      }
	    }
	    return root;
  }
}
