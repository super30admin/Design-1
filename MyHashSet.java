import java.util.ArrayList;
import java.util.List;


// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {

    /** Initialize your data structure here. */
    List<Integer> set;
    
    public MyHashSet() {
        this.set = new ArrayList<>();
    }
    
    public void add(int key) {
        if(!this.contains(key)){
            this.set.add(key);
        } else {
            return;
        }
        
    }
    
    public void remove(int key) {
        for(int i=0;i<set.size();i++){
            if(set.get(i)==key){
                set.remove(i);
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        for(int i:set){
            if(i==key){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */