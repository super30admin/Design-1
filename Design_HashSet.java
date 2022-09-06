// Time Complexity : I am guessing O(N/K) where N is number of values 
//                   and K is max keyrange
// Space Complexity : I am guessing O(K + U) where K is keyRange 
//                   and U is number of unique values in hashset
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, it took a lot of time to understand the question itself and figure out an approach.Initially planned to use hashmap but it didn't work so experimented with Linked List.

// Your code here along with comments explaining your approach
class MyHashSet {
  private B[] array;
  private int keyRange;

  /** Initialize your data structure here. */
  public MyHashSet() {
    this.keyRange = 653;
    this.array = new B[this.keyRange];
    for (int i = 0; i < this.keyRange; ++i)
      this.array[i] = new B();
  }

  protected int hashValue(int key) {
    return (key % this.keyRange);
  }

  public void add(int key) {
    int bIndex = this.hashValue(key);
    this.array[bIndex].insert(key);
  }

  public void remove(int key) {
    int bIndex = this.hashValue(key);
    this.array[bIndex].delete(key);
  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    int bIndex = this.hashValue(key);
    return this.array[bIndex].exists(key);
  }
}


class B {
  private LinkedList<Integer> c;

  public B() {
    c = new LinkedList<Integer>();
  }

  public void insert(Integer key) {
    int index = this.c.indexOf(key);
    if (index == -1) {
      this.c.addFirst(key);
    }
  }

  public void delete(Integer key) {
    this.c.remove(key);
  }

  public boolean exists(Integer key) {
    int index = this.c.indexOf(key);
    return (index != -1);
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

