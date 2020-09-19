/**
 * Time Complexity for put: O(1);
 * Time Complexity for remove: O(1);
 * Space Complexity: O(1);
 * Successfully ran and submitted on LeetCode;
 */

class MyHashMap {
    
    final Node[] nodes = new Node[10000];
     
      /** data structure initialization. */
     class Node {
         int key;
         int value;
         Node next;
         Node(int key, int value) {
             this.key = key;
             this.value = value;
         }
     }
     
     /** This function is used to find if the prev ele. */
     public Node findEle(int key, Node node) {
         Node cur = node;
         Node prev = null;
         while(cur != null && cur.key != key) {
             prev = cur;
             cur = cur.next;
         }
         return prev;        
     }
     
     
     /** Function is used to insert a (k, v) into hashmap. If prev value is null (ie: (k, v) not         found, create a new node. If the prev is not found append the node to the end of list) */
     public void put(int key, int value) {
         int size = nodes.length;
         int hash = ((key)%(size));
         if(nodes[hash] == null) {
             nodes[hash] = new Node(-1, -1);
         }
         Node prev = findEle(key, nodes[hash]);
         if(prev.next == null) {
             prev.next = new Node(key, value);
         } else {
             prev.next.value = value;   
         }
     }
     
     /** Returns the value to which the specified key is mapped, or -1 if this map contains no           mapping for the key */    
     public int get(int key) {
         int size = nodes.length;
         int hash = (key % size);
         if(nodes[hash] == null) {
             return -1;
         }
         Node prev = findEle(key, nodes[hash]);
         if(prev.next == null) {
             return -1;
         }
         return prev.next.value;
     }
     
     /** Removes the mapping of the specified value key if this map contains a mapping for the key */
     public void remove(int key) {
         int size = nodes.length;
         int hash = (key % size);
         if(nodes[hash] == null) {
             return;
         }
         Node prev = findEle(key, nodes[hash]);
         if(prev.next == null) {
            return;
         }
         prev.next = prev.next.next;
     }    
 }
 