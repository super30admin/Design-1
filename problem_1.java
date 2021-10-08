// Time Complexity
// put - O(k)
// get - O(k)
// remove - O(k)
// Space Complexity - O(n)
// Ran Successfully on the leetcode

class MyHashMap {

    class Node {
        int key;
        int val;
        Node next;
        
        public Node(int key,int val) {
            this.val=val;
            this.key=key;        }
    }
    
    Node [] nodeArray;
    /** Initialize your data structure here. */
        public MyHashMap() {
           nodeArray = new Node[10000];
        }
    
        private Node find(int key){
       
        int hashKey=(Integer.hashCode(key))%10000;
        Node prev = nodeArray[hashKey];
        Node current =nodeArray[hashKey];
        if(nodeArray[hashKey]==null){
            return null;
        }
        else{
            while(current.next!=null && current.key!=key){ 
                prev=current;
                current=current.next; 
            }
        }
        // if found 
        return prev;
        
        // if not fount 
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node index = find(key);
        int hashKey= Integer.hashCode(key)%10000;
        Node newNode= new Node(key,value);
        if(nodeArray[hashKey]==null){
            nodeArray[hashKey]=newNode;
            return;
        }
        if(index.next==null){
            if(index.key==key){
                index.val=value;
            }else{
                index.next=newNode;
            }
        }
        else{
            if(index.key==key){
                 index.val=value;
                 return;
             }
            if(index.next.key==key){
                index.next.val=value;
            }else{
                index.next.next=newNode;
            }
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Node index = find(key);
        if(index==null){
            return -1;
        }
        if(index.next==null){
            if(index.key==key){
                return index.val;
            }else{
                return -1;
            }
        } else{
             if(index.key==key){
                   return index.val;
               }
             if(index.next.key==key){
                    return index.next.val;
                }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Node index = find(key);
        int hashKey= Integer.hashCode(key)%10000;
        if(index==null){
            return ;
        }
        if(index.next==null){
           if(index.key==key){
               nodeArray[hashKey]=null;
           }else{
                return ;
            }
        }
        else{
             if(index.key==key){
                nodeArray[hashKey]=index.next;
                 return;
            }
            if(index.next.key==key){
                index.next = index.next.next;
            }else{
                return;
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