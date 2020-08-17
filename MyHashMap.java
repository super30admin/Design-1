
import java.util.*;
class MyHashMap {
    int arr[];
    int MAX=100001;
    /** Initialize your data structure here. */
    public MyHashMap() {
        arr=new int[MAX];    
        Arrays.fill(arr,-1);
        
        
}
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
       arr[key]=value; 
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return arr[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
     arr[key]=-1;   
    }

    public static void main(String args[]){
        
         MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
System.out.println(hashMap.get(1));            // returns 1
System.out.println(hashMap.get(3));            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
System.out.println(hashMap.get(2));            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
System.out.println(hashMap.get(2)); 
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */