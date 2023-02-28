// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 



// Your code here along with comments explaining your approach
import java.util.*;;
class MyHashSet {

    /** Initialize your data structure here. */
    List [] arr;
    int h = 997;
    public MyHashSet() {  
        arr = new ArrayList  [h];
    }
    
    public void add(int key) {
        int hash = key%h;
        List <Integer>temp = arr[hash];
        if(temp!=null){
            for(int x : temp){
                if(x==key)
                    return;
            }
            temp.add(key);
        }
        else{
            List <Integer> ar = new ArrayList <>();
            ar.add(key);
            arr[hash] = ar;
        }
    }
    
    public void remove(int key) {
        int hash = key%h;
        List <Integer>temp = arr[hash];
        if(temp!=null){
            for(int i=0;i<temp.size();i++){
                if(temp.get(i)==key)
                    temp.remove(i);
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = key%h;
        List <Integer>temp = arr[hash];
        if(temp!=null){
            for(int x : temp){
                if(x==key)
                    return true;
            }
        }
        return false;
    }
}


//  Your MyHashSet object will be instantiated and called as such:
//  MyHashSet obj = new MyHashSet();
//  obj.add(3);
//  obj.remove(3);
//  boolean param_3 = obj.contains(3);
// System.out.println(param_3); 
 