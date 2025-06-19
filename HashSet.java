// Time Complexity : O(1)
// Space Complexity : O(10^6)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//I used a 2D boolean array to track the presence of keys without using built-in hash table libraries.
//I split the key space using two functions: one for the bucket (key % 1000) and one for the position inside that bucket (key / 1000).
//I allocated each bucket only when needed (lazy initialization) to save memory.
//For the edge case where key = 10^6 I made sure to allocate one extra slot in bucket 0 to avoid going out of bounds.
//My add, remove, and contains methods just update or check the corresponding boolean flag in the storage array.



public class HashSet {

    int bkts;
    int bkt_items;
    boolean[][] storage;

    public HashSet(){
        this.bkts = 1000;
        this.bkt_items = 1000;
        storage = new boolean[this.bkts][];
        

    }

    int getBkt(int key){
        return key % this.bkts;
    }

    int getBktItms(int key){
        return key / this.bkt_items;
    }

    public void add(int key){
          int bkt = getBkt(key);
        int bkt_item = getBktItms(key);
        if (storage[bkt] == null) {
            if (bkt == 0) {
                storage[bkt] = new boolean[this.bkt_items + 1];
            } else {
                storage[bkt] = new boolean[this.bkt_items];
            }
        }

        storage[bkt][bkt_item] = true;


    }

    public void remove(int key){
        int bkt = getBkt(key);
        int bkt_item = getBktItms(key);
        if (storage[bkt] != null) {
            storage[bkt][bkt_item] = false;
        }


    }

    public boolean contains(int key){
        int bkt = getBkt(key);
        int bkt_item = getBktItms(key);
        return storage[bkt] != null && storage[bkt][bkt_item];

    }

    public static void main(String[]args){

    HashSet obj = new HashSet();
    obj.add(1);
    obj.add(2);
    System.out.println(obj.contains(1)); 
    System.out.println(obj.contains(3)); 
    obj.add(2);
    System.out.println(obj.contains(2)); 
    obj.remove(2);
    System.out.println(obj.contains(2)); 
    }

    
}
