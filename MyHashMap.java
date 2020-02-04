/*
    Time Complexity: O(1)
    Space Complexity: O(N) where N is the size of mapArray

*/

class MyHashMap {

    //this is the actual map array 
    private int [] mapArray ;
    
    //constructor 
    public MyHashMap() {
            mapArray = new int[1000000];
        
        //setting empty values to -1 to insert 0 
        for (int i = 0 ; i < mapArray.length ; i++)
            mapArray[i] = -1 ; 
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
       mapArray[key] = value ; 
    }
               
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return mapArray[key] ; 
    }
        

    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        mapArray[key] = -1 ;
    }
}
