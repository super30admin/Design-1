class MyHashMap {

  final listNode[] nodes = new ListNode[1000];    
                                                    //Alternate Can Have ArrayList as well
  class ListNode {
      int key;
      int val;
      ListNode next;
      ListNode(int key, int val) {
          this.key = key;
          this.val = val;
      }
  }

  int getHash(int key) {
      return Integer.hashCode(key) % nodes.length;
  }
  /** Initialize your data structure here. */
  public MyHashMap() {
      map = new int[Integer.MAX_VALUE];
      Arrays.fill(map, -1);
  }
  
  /** value will always be non-negative. */
  public void put(int key, int value) {
      int hash = getHash(key);
      if (nodes[hash] == null) {
          nodes[hash] = new ListNode(-1, -1); // To avoid null pointer exception
      }

      ListNode node = findElement(node, key);                           
      if (node.next == null) {
          node.next = new ListNode(key, value);
      } else {
          prev.next.val = value;
      }
  }
  
  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  public int get(int key) {
      int hash = getHash(key);
      if(nodes[hash] == null) return -1;

      ListNode prev = findElement(nodes[hash], key);  // Will return the prev node of thenode where value was found
      if (prev.next == null) return -1;

      return prev.next.val;
  }
  
  ListNode findElement(ListNode head, int key) {
      ListNode node = head, prev = null;
      while (node != null && node.key!=key) {
          prev = node;
          node = node.next;
      }
      return prev;
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
      int hash = getHash(key);
      
      if (nodes[hash] == null) return;

      ListNode prev = findElement(nodes[hash], key);
      if(prev.next == null) {
          return;
      }

    prev.next = prev.next.next;
    
      
  }
}

/**
* Your MyHashMap object will be instantiated and called as such:
* MyHashMap obj = new MyHashMap();
* obj.put(key,value);
* int param_2 = obj.get(key);
* obj.remove(key);
*/