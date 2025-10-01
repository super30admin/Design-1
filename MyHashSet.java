/**
 * 
 */

/**
 * @author Aditya Sinha
 *
 */
// we will follow the approach of double hashing for avoiding collision - 2D array
// target is to main time complexity O(1) for all operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
public class MyHashSet {

    int primaryArray;
    int secondaryArray;
    boolean[][] storage;
    
	public MyHashSet() {
        this.primaryArray = 1000;
        this.secondaryArray = 1000;
        this.storage = new boolean[primaryArray][];
    }

    private int hash1(int key) {
        return key % primaryArray;
    }

    private int hash2(int key) {
        return key / secondaryArray;
    }
    
    public void add(int key) { // time complexity - O(1)
        int pryIdx = hash1(key);
        if(storage[pryIdx] == null) {
            if(pryIdx == 0) {
                storage[pryIdx] = new boolean[secondaryArray + 1]; // at 0 index create secarray from 0...1000, to store 1000
            } else {
                storage[pryIdx] = new boolean[secondaryArray]; // at other indexes create secarray from 0...999
            }
        }
        int secIdx = hash2(key);
        storage[pryIdx][secIdx] = true; // make the index at secondaryarray as true, means data inserted
    }
    
    public void remove(int key) { // time complexity - O(1)
        int pryIdx = hash1(key);
        if(storage[pryIdx] == null) {
            return;
        }
        int secIdx = hash2(key);
        storage[pryIdx][secIdx] = false; // make the index at secondaryarray as false, means data removed
    }
    
    public boolean contains(int key) { // time complexity - O(1)
        int pryIdx = hash1(key);
        if(storage[pryIdx] == null) {
            return false;
        }
        int secIdx = hash2(key);
        return storage[pryIdx][secIdx]; // pick the data from index of secondaryarray, will tell data is present or not
    }
}

//Driver code 
class Main { 
 public static void main(String args[]) 
 { 
	 MyHashSet obj = new MyHashSet();
	 obj.add(2001);
	 obj.remove(2001);
	 System.out.println("Is Key exist in MyHashSet - " + obj.contains(2001));
     
 } 
}
