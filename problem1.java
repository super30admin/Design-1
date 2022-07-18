// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// below approch is using array and simple hash function. To add, get the index using hash function, and add key on that index. I am using 137 as size 
// buckets because its a prime number. To remove, calculate the index and get bucket , if key exists then remove it. For contains function, get index
// and check if key exists or not.

//Question -  I tried a simpler approch (below commented) is it slower because of just size of boolean array or any other reason ?

import java.util.*;

class MyHashSet {
    
    int size;
    LinkedList<Integer>[] set;

    public MyHashSet() {
        size = 137;
        set = new LinkedList[size];
    }
    
    public int hash(int key){
        return key % size;
    }
    
    public void add(int key) {
        int index = hash(key);
        LinkedList<Integer> elements = set[index];
        if (elements == null) {
            elements = new LinkedList<Integer>();
            elements.add(key);
            set[index] = elements;
        } else {
            if (elements.indexOf(key) == -1) {
                elements.add(key);
            }
        }
        
    }
    
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Integer> elements = set[index];
        if (elements != null) {
            int keyIndex = elements.indexOf(key);
            if (keyIndex != -1) {
                elements.remove(keyIndex);
            }
        }
    }
    
    public boolean contains(int key) {
        int index = hash(key);
        LinkedList<Integer> elements = set[index];
        if (elements != null) {
            if (elements.indexOf(key) != -1) return true;
        }
        return false;
    }
    
    /*boolean[] set;
    public MyHashSet() {
        set = new boolean[10000001];
        Arrays.fill(set,false);
    }
    
    public void add(int key) {
        set[key]=true;
    }
    
    public void remove(int key) {
        set[key]=false;
    }
    
    public boolean contains(int key) {
        return set[key];
    }*/
}
