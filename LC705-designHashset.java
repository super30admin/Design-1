// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : NO, not able to debug because test case contains 1000's of operations
// Any problem you faced while coding this : yes, 


// Your code here along with comments explaining your approach

 /* base datastructure: 
         array of size = 1000 (since 10,000 calls will be made for add/remove/contain, so 1000 should be good enough)
         
         secondary Data structure : linked list (store values and handle collision)
        
         hash function: key % 1000 should be good 
        
         collision handelling : linkedlist
*/

class MyHashSet {
    
    // set imperical size of the base data structure 
    private int size = 1000;
    Node[] arr = new Node[size];

    public class Node {
        int key;
        Node next;
            
        public Node (int data) {
            key = data;
        }
    }
    
    public MyHashSet() {}
    
    public void add(int key) {
        if (!contains(key)) 
        {
            int _hash = hash(key);

            Node temp = arr[_hash];

            if (temp != null) {

                while(temp.next != null) temp = temp.next;
                temp.next = new Node(key);

            } else {
                arr[_hash] = new Node(key);
            }
        }
    }
    
    public void remove(int key) {
        if (contains(key)) {
            int _hash = hash(key);

            Node temp = arr[_hash];

            if (temp != null) {


                while (temp.next != null && temp.next.key != key) temp = temp.next;

                 // single value
                if (temp.next == null && temp.key == key) {
                    arr[_hash] = null;
                } else if (temp.next != null && temp.next.key == key) {
                    temp.next = temp.next.next;
                }
            }
        }
    }
    
    public boolean contains(int key) {
        int _hash = hash(key);
        
        if (arr[_hash] == null) {
            return false;
        } else {
            Node temp = arr[_hash];
            while(temp != null) {
                if (temp.key == key) return true;
                temp = temp.next;
            }
        }
        
        return false;
        
    }
    
    // get hash 
    private int hash(int key) {
        return key % 1000;
    }
}



/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */