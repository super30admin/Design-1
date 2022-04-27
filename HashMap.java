// Time Complexity :O(1) for put, get and remoe
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
class MyHashMap {
    
    int[] hashMap;
    

    public MyHashMap() {
        /*initialize the hashMap with array of size 1000001 since
        we need to replace the value if key is present and value is also less than 10^6
        initializing the array is not so expensive
        */
        int[] hashMap = new int[1000001];
        Arrays.fill(hashMap, -1) ;
        this.hashMap = hashMap;
    }
    
    public void put(int key, int value) {
       hashMap[key] = value;

       /*
        replace the value if key matches
       */
                
    }
    
    public int get(int key) {
        return hashMap[key];
    }
    
    public void remove(int key) {
        hashMap[key] = -1;
    }
}



/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */