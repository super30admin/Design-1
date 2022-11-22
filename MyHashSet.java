// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.

class MyHashSet {

	int buckets;
	int items;
	boolean[][] storage;
	final int MAX = 1000;
	public MyHashSet() {
		 this.buckets = MAX;
		 this.items = MAX;
		 storage = new boolean[buckets][];
	}
	
	private int hash1(int key){
		 return key%buckets;
	}
	
	private int hash2(int key){
		 return key/items;
	}
	
	public void add(int key) {
		 int hash1 = hash1(key);
		 int hash2 = hash2(key);
		 if(storage[hash1] == null){
			  if(hash1 == 0) {
					storage[hash1] = new boolean[items+1];
			  } else {
					storage[hash1] = new boolean[items];
			  }
		 }
		 storage[hash1][hash2] = true;
	}
	
	public void remove(int key) {
		 int hash1 = hash1(key);
		 int hash2 = hash2(key);
		 if(storage[hash1]!=null){
			storage[hash1][hash2] = false;
		 }
		 return;
	}
	
	public boolean contains(int key) {
		 int hash1 = hash1(key);
		 int hash2 = hash2(key);
		 if(storage[hash1]!=null)
			  return storage[hash1][hash2];
		 
		 return false;
	}
}

/**
* Your MyHashSet object will be instantiated and called as such:
* MyHashSet obj = new MyHashSet();
* obj.add(key);
* obj.remove(key);
* boolean param_3 = obj.contains(key);
*/