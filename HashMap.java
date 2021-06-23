class MyHashMap {
    
    ArrayList<int[]> HM;//for the hashmap
    ArrayList<Integer> dup; //to store just the key

    /** Initialize your data structure here. */
    public MyHashMap() {
        HM =  new ArrayList<int[]>();
        dup = new ArrayList<Integer>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int[] pair = new int[2];
        pair[0] = key;
        pair[1] = value;
        if(dup.contains(key)==false){
            HM.add(pair);   
            dup.add(key);
        }
        else{
            int index = dup.indexOf(key);
            HM.set(index,pair);
        }
        
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(dup.contains(key)){
            int index = dup.indexOf(key);
            int[] val = HM.get(index);
            return val[1];
        }
        return -1;        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if(dup.contains(key)){
            int index = dup.indexOf(key);
            dup.remove(index);
            HM.remove(index);
        }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

 //RESULT

 //spacec complexity - using 2 arraylist to store n+n elements so it is O(n)
 //time complexity - the put method is O(n) runtime
 //                 - the get and remove method is O(n^2) runtime becasue i am using indexOf function inside of contains functions
 // So, the final runtime is O(n) + O(n^2) + O(n^2) = O(n^2)


 //better appraoch would be to use "Just arrays" in which we can use index as keys and value stored in that particular index as values
 //but, I think this is a better appraoch because we might not know the max size of no.of elements that can be stored in the hashmap
 //(even though the max number is provided in the leetcode).

 //I am also not sure if we can use the idea of double hashing to create a hashmap. 
            
