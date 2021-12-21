package design1;

import java.util.LinkedList;

//Time Complexity : O(1)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : Was a tricky problem. Designing HashSet logic helped a
// lot over here. Taking care of collision using separate collision.
public class DesignHashMap {
	class Node {
        int key;
        int val;
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    LinkedList<Node>[] bucket;
    int SIZE = 769; // Any arbitrary large prime number
    public DesignHashMap() {
        bucket = new LinkedList[SIZE];
    }
    
    private int hashingFunction(int key) {
        return key % SIZE;
    }
    
    public void put(int key, int value) {
        int idx = hashingFunction(key);
        if(bucket[idx] == null) {
            bucket[idx] = new LinkedList<>();
            bucket[idx].add(new Node(key, value));
        } else {
            LinkedList<Node> lList = bucket[idx];
            for(Node n: lList) {
                if(n.key == key) {
                    n.val = value;
                    return;
                }
            }
            
            bucket[idx].add(new Node(key, value));
        }
    }
    
    public int get(int key) {
        int idx = hashingFunction(key);
        LinkedList<Node> lList = bucket[idx];
        if(lList == null)
            return -1;
        for(Node n: lList) {
            if(n.key == key)
                return n.val;
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = hashingFunction(key);
        if(bucket[idx] == null)
            return;
        LinkedList<Node> lList = bucket[idx];
        Node toRemove = null;
        for(Node n: lList) {
            if(n.key == key)
                toRemove = n;
        }
        
        if(toRemove != null)
            bucket[idx].remove(toRemove);
    }
}
