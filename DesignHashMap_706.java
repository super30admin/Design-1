// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class DesignHashMap_706 {

    class Node {
        int key;
        int val;
        Node next;
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
    
    Node[] nodes;
    /** Initialize your data structure here. */
    public DesignHashMap_706() {
        nodes= new Node[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
      
        int index = getIndex(key);
        
        if(nodes[index]!=null){
            Node curr =nodes[index];
            while(curr.next != null){
               curr  = curr.next;
            }
            
            if(curr.key == key){
                curr.val = value;
            } 
        } else {
             nodes[index] = new Node(-1,-1);
             nodes[index].next = new Node(key, value);
        }
    }
    
    public Node findPrev(int key){
        
        int index = getIndex(key);
        
        if(nodes[index]==null){
            nodes[index] = new Node(-1,-1);
            return nodes[index];
        }  else {
            Node curr= nodes[index];
            while(curr.next != null){
                curr = curr.next;
            }
            return curr;
        }
        
       
    }
    
    public int getIndex(int key){
        return Integer.hashCode(key) % 10000;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        
        if(nodes[index]==null){
            return -1;
        }  else {
            Node curr= nodes[index];
            while(curr != null){
               if(curr.key == key){
                    return curr.val;
                 }
                curr = curr.next;
            }
            return -1;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key); 
        if(nodes[index]!=null){
            Node prev = nodes[index];
            Node curr =prev.next;
            while(curr != null){              
               if(curr.key == key){
                   prev.next = curr.next != null ? curr.next : null;  
                   curr = curr.next;           
                 } else {
                   prev = curr;
                   curr = curr.next != null ? curr.next : null; 
               }
                
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */