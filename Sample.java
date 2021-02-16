import java.util.List;
import java.util.LinkedList;
// Time Complexity : //TODO: Need to understand more and update
// Space Complexity : //TODO: Need to understand more and update
// Did this code successfully run on Leetcode : Attempted few times. As without autocompleted it was difficult to write the syntax.
// Any problem you faced while coding this : 
// Confused between Array and List. Was trying to access length instead of size()
// Didn't check if the value already exist or not. 

// Your code here along with comments explaining your approach
class Pair<K,V>{
    public K key;
    public V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    List<Pair<Integer, Integer>> list;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        list =new LinkedList<Pair<Integer, Integer>>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        boolean isExist = false;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).key.equals(key)) {
                isExist = true;
                list.get(i).value = value;
            }
        }
        if(!isExist) {
            list.add(new Pair<Integer, Integer>(key,value));    
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(list!=null && list.size() >0) {
            for(int i = 0;i < list.size(); i++) {
                if(list.get(i).key.equals(key)) {
                    return list.get(i).value;
                }
            }   
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if(list.size() > 0) {
            for(int i = 0 ;i <list.size(); i++) {
                if(list.get(i).key.equals(key)) {
                    list.remove(i);
                    return;
                }           
           }  
        }
    }
}

// public class Sample {
//     public static void main(String[] args) {
//         MyHashMap obj = new MyHashMap();
//         obj.put(1, 2);
//         System.out.println(obj.list);
//         int param_2 = obj.get(1);
//         obj.remove(1); 
//         System.out.println(obj.list);
//     }
// }
