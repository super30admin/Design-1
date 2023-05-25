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
    
    
    public class Node {
        int key;
        Node next;

        public Node (int data) {
            key = data;
        }
    }

    // we iterate thru linkedlist multiple time, so lets make a function
    private Node findNode(Node head, int key) {
        // will return 1 node prev
        Node prev = null;
        Node cur = head;
        while (cur!=null && cur.key!= key){
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }

    // get hash 
    private int hash(int key) {
        return key % 1000;
    }
    

    
    private int size;
    Node[] arr;
        
    public MyHashSet() {
        size = 1000;// set imperical size of the base data structure 
        arr = new Node[size];
    }
    
    public void add(int key) {
        int _hash = hash(key);

        if (arr[_hash] == null) {
            arr[_hash] = new Node(-1); // dummy node
        } 

        //find the node
        Node prev = findNode(arr[_hash], key);
        if (prev.next == null) {
            prev.next = new Node(key);
        } 
    }
    
    public void remove(int key) {
        int _hash = hash(key);
        if (arr[_hash] == null) return;

        Node prev = findNode(arr[_hash],key);

        if (prev.next != null) {
            // found the node to remove
            prev.next = prev.next.next;
        }
    }
    
    public boolean contains(int key) {
        int _hash = hash(key);
        if (arr[_hash] == null) return false;

        Node prev = findNode(arr[_hash], key);

        return prev.next != null;
    }       
}