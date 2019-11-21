// Complexity:  hashmap has O(1) complexity for seraching, insertion and remove operation, Space complexity is O(n) where n is the bucket size.

class MyHashMap {
    
    //I am using array as of now, will improve it using linkedlist later
    int[] buckets;

    /** Initialize your data structure here. */
    public MyHashMap() {
        //initialize 1000000 length of buckets, this also can be improved further by dynamically assigning size using arraylist, as of now I wanted to understand array, would submit using linkedlist tomorrow
        buckets = new int[1000000];
        Arrays.fill(buckets, -1);
    }
    
   
    public void put(int key, int value) {
        //get the keys bucket number using hashcode which is index of the key and put the key at that index
        buckets[getBucketIndex(key)] = value;
    }
    
    //hashcode function to provide index to keys
    private int getBucketIndex(int key) 
    {
        //I have randomely designed hashcode function here, This can be improved 
        return key*2 % buckets.length;
    }
    
// returns -1 if key is not found 
    public int get(int key) {
        //if key is not positive and more than the size of the array and not inserted before
        if (key < 0 || key > 1000000 || buckets[getBucketIndex(key)] == -1) {
            return -1;
        } else {
            return buckets[getBucketIndex(key)];
        }
    }
    
   
    public void remove(int key) {
        //removing is just making it -1
        buckets[getBucketIndex(key)] = -1;
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
