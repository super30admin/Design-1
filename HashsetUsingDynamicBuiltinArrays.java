/*
Time Complexity
O(1) add remove contains
Space Complexity
O(n*2) add remove//not sure exactly it is my doubt
O(1) contains
O(n) add remove//not sure exactly it is my doubt
*/
import java.util.ArrayList;
import java.util.LinkedList;
class MyHashSet {
	ArrayList<LinkedList<Integer>> a;
    public MyHashSet() {
       int bucketsize=1000;
    	a=new ArrayList<LinkedList<Integer>>();
    	for(int i=0;i<1000;i++) {
    		a.add(new LinkedList<Integer>());
    	}
    }
    
    public void add(int key) {
        int hash=key%1000;
        if(a.get(hash).contains(key)) {
        	return;
        }
        else {
        	a.get(hash).add(key);
        }
        
    }
    
    public void remove(int key) {
        int hash=key%1000;
        if(a.get(hash).contains(key)) {
        	a.get(hash).remove(Integer.valueOf(key));        }
        else {
        	return;
        }
    }
    
    public boolean contains(int key) {
        int hash=key%1000;
        if(a.get(hash).contains(key)) {
        	return true;
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