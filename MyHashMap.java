
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Time Complexity : O(N/K) where k - bucket size, N - total input keys
// Space Complexity : O(N+K)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class MyHashMap {

    List<LinkedList<int[]>> l;
    int capacity;
    
    public MyHashMap() {
        
        l = new ArrayList<>();
        capacity = 2999;
        
        for(int i=0;i< 2999;i++)
        {
            l.add(new LinkedList<int[]>());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        //generate key
        int hashkey = key % capacity;
        
        LinkedList<int[]> bucket = l.get(hashkey);
        
        for(int[] element : bucket)
        {
            if(element[0] == key)
            {
                 element[1] = value;
                 return;
            }
               
        }
        bucket.add(new int[]{key, value});
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        //generate hash key, iterate till you find
        
        int hashkey = key % capacity;
        
        LinkedList<int[]> bucket = l.get(hashkey);
        
        for(int[] element : bucket)
        {
            if(element[0] == key)
                return element[1];
        }
      return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
        int hashkey = key % capacity;
        
        LinkedList<int[]> bucket = l.get(hashkey);
        
        for(int[] element : bucket)
        { 
            if(element[0] == key)
            {
             bucket.remove(element);  
              break;  
            }
               
        }
      
        
    }
} 
