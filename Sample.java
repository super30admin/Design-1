// Time Complexity :O(N/1889)
// Space Complexity :(B+K) where B is the Number of Buckets(1889) and K is number of inserted keys
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :
//Is there an optimal prime number that we can pick for the number of buckets based on the max input size constraints?
// Your code here along with comments explaining your approach
//Defining the Key value pair data structure
class Pair<U, V> {
  public U first;
  public V second;

  public Pair(U first, V second) {
    this.first = first;
    this.second = second;
  }
}
//Defining the Bucket structure and what operations can be performed on a bucket
class Bucket {
  private List<Pair<Integer, Integer>> bucket;

  public Bucket() {
    this.bucket = new LinkedList();
  }

  public Integer get(Integer key) {
	  //Iterator is used to find the key in the bucket and in case of collioson we will need to iterate through the bucket to find key
    for (Pair<Integer, Integer> pair : bucket) {
      if (pair.first.equals(key))
        return pair.second;
    }
    return -1;
  }

  public void update(Integer key, Integer value) {
    boolean found = false;
    for (Pair<Integer, Integer> pair : this.bucket) {
      if (pair.first.equals(key)) {
        pair.second = value;
        found = true;
      }
    }
    if (!found)
      this.bucket.add(new Pair<Integer, Integer>(key, value));
  }

  public void remove(Integer key) {
    for (Pair<Integer, Integer> pair : bucket) {
      if (pair.first.equals(key)) {
        bucket.remove(pair);
        break;
      }
    }
  }
}

class MyHashMap {
  private int key_space;
  private List<Bucket> hash_table;

//We define a Hashtable as an Array list of buckets and add 1889(Prime Number) buckets to this Array List
  public MyHashMap() {
    this.key_space = 1889;
    this.hash_table = new ArrayList<Bucket>();
    for (int i = 0; i < this.key_space; ++i) {
      this.hash_table.add(new Bucket());
    }
  }

  
  public void put(int key, int value) {
	  //A Hashkey is generated to find which bucket the value will fall into
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

