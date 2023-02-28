// Time Complexity : 0(n) best case and O(n) worst case
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise the syntax 


// Your code here along with comments explaining your approach
/*A linkedlist within an arraylist is initialized to store keys and values. 
The arraylist is checked to see if a key is present and only if it isnt present, the key is added. 
A size variable is used to keep track of the hash set. 
The arraylist is checked to find the index of the hash key and then removed from the list.
*/
import java.util.List; 
import java.util.LinkedList; 
import java.util.ArrayList;
class MyHashSet {
private static final int defaultSize = 10; 
private List <List <Integer>> buckets;
private int size; 
    public MyHashSet() {
        this(defaultSize);
    }
    public MyHashSet(int capacity){
        this.buckets= new ArrayList<>();
        for(int i =0; i < capacity;i++){
            this.buckets.add(new LinkedList<Integer>());
        }
        this.size=0;
    }
    private int HashFunc(int key){
        return key % this.buckets.size();
    }
    public int size(int size){
        return this.size;
    }
    public void add(int key) {
        int hashIndex = HashFunc(key);
        List<Integer> bucket = this.buckets.get(hashIndex);
        if(!bucket.contains(key)){
            bucket.add(key);
            this.size++;
        }
    }
    
    public void remove(int key) {
        int hashIndex= HashFunc(key);
        List<Integer> bucket = this.buckets.get(hashIndex);
        if(bucket.contains(key)){
            bucket.remove(Integer.valueOf(key));
            this.size--;
        }
    }
    
    public boolean contains(int key) {
        int hashIndex= HashFunc(key);
        List <Integer> bucket = this.buckets.get(hashIndex);
        return bucket.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */