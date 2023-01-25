// Time Complexity : O(1) 
// Space Complexity : O(N^2) - for the matrix of boolean type if considered, else O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

// A simple approach without using any hash function. 
// I am just using an arraylist to store the elements and everytime
// I am checking if it is present in the list before adding or removing it.
// To check if the element is present, I am using indexOf method. 
// It worked on LeetCode.
// TC: O(N) for all methods.
/*class MyHashSet { 
    ArrayList<Integer> set;
    public MyHashSet() {
        set = new ArrayList<>();
    }
    
    public void add(int key) {
        if(contains(key)) {
            return;
        }
        set.add(key);
    }
    
    public void remove(int key) {
        if(contains(key)) {
            int idx = set.indexOf(key);
            set.remove(idx);
        }
    }
    
    public boolean contains(int key) {
        return set.indexOf(key) != -1;
    }
}*/


/**
 * @author akhilreddy619
 * In this class, I am using an boolean array of arrays.
 * hash1 & hash2: (extra function added) to calculate the index in which the element has 
 * to be inserted/removed.
 * For Add: calculating the hashes (h1 & h2) and check if it has a list in that index. If so,
 * check if the key is already inserted, if not insert it else skip it. If the list
 * is not initialized, then initialize it and insert the key in [h1][h2]. Then put that list in 
 * the array. 
 * For Remove:Calcuate the hashes (h1 & h2) and check if it has a list in that index. If so, 
 * remove the element from [h1][h2] else skip it.
 * For Contains: Calculate the hashes (h1 & h2) and check if it has a list in that index. If not,
 * return false, else check if that list has this key in [h1][h2] and return boolean accordingly.
 *
 */
class MyHashSet {
    boolean[][] set;
    int buckets;
    int bucketItems;
    public MyHashSet() {
        this.buckets = 1000; // sqrt(1M)
        this.bucketItems = 1000; // sqrt(1M) buckets == bucketItems
        this.set = new boolean[buckets][];
    }
    
    public void add(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        if(set[h1] == null) {
            if(h1 == 0)
                set[h1] = new boolean[bucketItems + 1];
            else
                set[h1] = new boolean[bucketItems];
        }
        set[h1][h2] = true;
    }
    
    public void remove(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        if(set[h1] == null)
            return;
        set[h1][h2] = false;
    }
    
    public boolean contains(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        if(set[h1] == null)
            return false;
        return set[h1][h2];
    }

    public int hash1(int key) {
        return key % buckets;
    }

    public int hash2(int key) {
        return key / bucketItems;
    }
}