// Time Complexity : O(1) for all average case
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : was missing few edge cases which I fixed

import java.util.*;

class MyHashSet {
    Bucket[] b;
    
    class Bucket {
        List<Integer> l;
        
        public Bucket(){
           l = new ArrayList();
        }
    }

    public MyHashSet() {
        b = new Bucket[1000000];
    }
    
    public void add(int key) {
        int i = hash(key);
        if(b[i] == null){
            List<Integer> temp = new ArrayList();
            temp.add(key);
            b[i] = new Bucket();
            b[i].l = temp;
            return;
        }
        List<Integer> temp = b[i].l;
        if(!temp.contains(key)) {
            temp.add(key);
            b[i].l = temp;
        }
    }
    
    public void remove(int key) {
        int i = hash(key);
        if(b[i] !=null){
            List<Integer> temp = b[i].l;
            Integer no = key;
            temp.remove(no);
            b[i].l = temp;
        }
    }
    
    public boolean contains(int key) {
        int i = hash(key);
        if(b[i]!=null){
            List<Integer> temp = b[i].l;
            if(temp.contains(key))
                return true;
            else
                return false;
        }
        return false;
    }
    
    public int hash(int key) {
        return key%1000000;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
