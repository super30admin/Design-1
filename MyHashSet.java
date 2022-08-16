// Time Complexity : depends on the table size (ARRAY_SIZE)
// Space Complexity : depends on the table size (ARRAY_SIZE)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;
class MyHashSet {
  final int MAX_VALUE=1000000;
    final int ARRAY_SIZE=100; //creating fixed set of buckets
    List <List> parentList;
    public MyHashSet() {
       parentList=new ArrayList(ARRAY_SIZE);
        for(int i=0;i<ARRAY_SIZE;i++){
            parentList.add(null);
        }
       
    }
    
    public void add(int key) { //internally hash(key) returns hashcode
       int index=key % ARRAY_SIZE;
        List childList=parentList.get(index);
        if(childList==null){
            List list=new LinkedList();
            list.add(key);
            parentList.set(index,list);
        }
        else if(!childList.contains(key)){ // Handling collision
            childList.add(key);
        }
        
    }
    
    public void remove(int key) {
          int index=key % ARRAY_SIZE;
        List childList=parentList.get(index);
        if(childList!=null){
            childList.remove(Integer.valueOf(key));
      }
    }
    
    public boolean contains(int key) {
         int index=key % ARRAY_SIZE;
        List childList=parentList.get(index);
        return childList!=null && childList.contains(key);
    }


public static void main(String a[]) {
	MyHashSet myHashSet = new MyHashSet();
	myHashSet.add(1);      // set = [1]
	myHashSet.add(2);      // set = [1, 2]
	myHashSet.contains(1); // return True
	myHashSet.contains(3); // return False, (not found)
	myHashSet.add(2);      // set = [1, 2]
	myHashSet.contains(2); // return True
	myHashSet.remove(2);   // set = [1]
	System.out.println(myHashSet.contains(2)); // return False, (already removed)
}}
