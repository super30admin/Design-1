/*
 Approach 1:
  Uses Linked List to Bucket the Objects.


  /*
      Did this code successfully run on Leetcode : Yes
      Any problem you faced while coding this : No
  */

class MyHashSet {
    
  private Bucket[] bucketArray;
  private int size;

  public MyHashSet() {
      this.size = 1000;
      this.bucketArray = new Bucket[this.size];
      for(int i = 0; i < this.size; i++){
          bucketArray[i] = new Bucket();
      }
  }
  
  private int hash(int key){
      return key % this.size;
  }
  
  /*
  Time Complexity: O(1)

  Space Complexity: O(1)

  Bucketing does take O(n) time in worst case scenario, but with a good Hash function the chances are real real low.
  */
  public void add(int key) {
      int index = this.hash(key);
      
      this.bucketArray[index].insert(key);
  }
  
  /*
  Time Complexity: O(1)

  Space Complexity: O(1)
  */
  public void remove(int key) {
      int index = this.hash(key);
      this.bucketArray[index].remove(key);
  }
  
  /*
  Time Complexity: O(1)

  Space Complexity: O(1)
  */
  public boolean contains(int key) {
      int index = this.hash(key);
      return this.bucketArray[index].contains(key);
  }
}

class Bucket {
  private LinkedList<Integer> container; //Initializing as LinkedList instead of List.
  
  Bucket(){
      this.container = new LinkedList<>();
  }
  
  /* 
  Should pass down Integer Object instead of int to add method on list.
  
  When a int is passed down, the element is added at the index.
  
  Time Complexity: O(n) since element is added towards end of the LinkedList.
  */
  public void insert(Integer key) {
      if(!this.container.contains(key)){ // Bucket checks for the uniqueness of element being inserted.
          this.container.add(key);
      }
  }
  
  /* 
  Should pass down Integer Object instead of int to the remove method on list.
  
  When a int is passed down, the element at the int index is removed.
  
  Time Complexity: O(n) since we need to iterate on the List before removing.
  */
  public void remove(Integer key) { 
      this.container.remove(key);
  }
  
  /*
  Time Complexity: O(n) since we need to iterate on the List.
  */
  public boolean contains(Integer key){
      return this.container.contains(key);
  }
}
