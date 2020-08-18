class KeyValuePair<A, B>{
	public A first;
	public B second;

	public KeyValuePair(A first, B second){
		this.first = first;
		this.second = second;
	}
}

class AddressValueBucket{
	private List<KeyValuePair<Integer,Integer>> bucket;

	public AddressValueBucket(){
		this.bucket = new LinkedList<KeyValuePair<Integer,Integer>>();
	}

	public Integer get(Integer key){
		for(KeyValuePair<Integer,Integer> pair : this.bucket){
			if(pair.first.equals(key)){
				return pair.second;
			}
		}
		return -1;
	}

	public void update(Integer key, Integer value){
		boolean seen = false;
		for(KeyValuePair<Integer,Integer> pair : this.bucket){
			if(pair.first.equals(key)){
				pair.second = value;
				seen = true;
			}
		}
		if(!seen){
			this.bucket.add(new KeyValuePair<Integer,Integer>(key, value));
		}
	}

	public void remove(Integer key){
		for(KeyValuePair<Integer,Integer> pair : this.bucket){
			if(pair.first.equals(key)){
				this.bucket.remove(pair);
				break;
			}
		}
	}

}

class MyHashMap {
	private int key_space;
	private List<AddressValueBucket> hash_table;

	public MyHashMap(){
		this.key_space = 2069;
    	this.hash_table = new ArrayList<AddressValueBucket>();
    	for (int i = 0; i < this.key_space; ++i) {
      		this.hash_table.add(new AddressValueBucket());
    	}
	}

	public void put(int key, int value) {
        int hash_key = key % this.key_space;
    	this.hash_table.get(hash_key).update(key, value);
    }

    public int get(int key) {
        int hash_key = key % this.key_space;
    	return this.hash_table.get(hash_key).get(key);
    }
 
   public void remove(int key) {
        int hash_key = key % this.key_space;
    this.hash_table.get(hash_key).remove(key);
  }
}


// Time Complexity : O(N), where N is the number of keys
// Space Complexity : O(K + M), where K is the no. of buckets, M is the no. of keys
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Followed the leetcode solution to understand how to design hashmap.


// Your code here along with comments explaining your approach
