class MyHashMap {
    
    // HashMap is implemented using array of linkedlist 
    // here each array of element act as has head of linklist 
    //we used hash funcion to find that block if the block is present we update the value or we insert a new node
    // we used hash function to find index of the key and traverse till previous node so to delete we make reference to its next node.
    // Space Complexity : O(n)
    ListNode[] nodes;

    private class ListNode{
        int key;
        int val;
        ListNode next;
        ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private int getIndex(int key){
        
        return Integer.hashCode(key) % nodes.length;
    }
    
    private ListNode findElement(int index, int key){
          if(nodes[index] == null)
             return nodes[index] = new ListNode(-1, -1);
        
            ListNode prev = nodes[index];
  
             while(prev.next != null && prev.next.key != key)
                {
                     prev = prev.next;
                }
            return prev;
    }
    
    public MyHashMap() {
    nodes = new ListNode[10000];
        
    }
    
    public void put(int key, int value) {
       int index = getIndex(key);
          ListNode prev = findElement(index, key);
          if(prev.next != null){
              prev.next.val = value;
          }
          else{
              prev.next = new ListNode(key, value);
          }
          
      }
    
     public int get(int key){
            int index = getIndex(key);
            ListNode prev = findElement(index, key);
            if(prev.next != null){
                return prev.next.val;
            }
            else{
                return -1;
            }
      }
    
    
    public void remove(int key) {
         int index = getIndex(key);
         ListNode prev = findElement(index, key);
        
        if(prev.next != null){
            prev.next = prev.next.next;
        }
        
    }
    
}

