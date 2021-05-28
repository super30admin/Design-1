// Time Complexity : worst case O(n) (in case of collision)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


class MyHashMap {
    
     class Node {
       int key;
       int value;
       Node next;
       public Node(int key, int value) {
         this.key = key;
         this.value = value;
       }
     }

     Node [] nodes;
    /** Initialize your data structure here. */
    public MyHashMap() {
     nodes = new Node[10000];
    }
    private int index(int key) {
      return Integer.hashCode(key) % nodes.length;
    }
  
    private Node find(Node head, int key) {
      Node curr = head;
      Node prev = null;
      while(curr != null && curr.key !=key){
        prev = curr;
        curr = curr.next;
      }
      return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
      //find the hash index
      int index = index(key);
      if(nodes[index] == null) {
        nodes[index] = new Node(-1,-1);
      }
      
      Node prev = find(nodes[index], key);
      if(prev.next == null) { // node not found 
        prev.next = new Node(key, value);
      } else {
        prev.next.value = value;
      }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
      int index = index(key);
      if(nodes[index] == null) return -1;
      Node prev = find(nodes[index],key);
      if(prev.next == null) return -1;
      return prev.next.value;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = index(key);
      if(nodes[index] == null) return;
      Node prev = find(nodes[index],key);
      if(prev.next == null) return;
      prev.next =  prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */