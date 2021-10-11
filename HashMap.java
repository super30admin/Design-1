// Time Complexity :O(1) for all operations
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : No


class MyHashMap {

    int size=10000;
     class Node{
        int key;
        int value;
        Node next;
         
       
        Node(int key,int value){
            this.key = key;
            this.value = value;
            this.next= null;
        }
    }
    
     Node[] hashMap;
    
    public MyHashMap() {
        hashMap = new Node[size];
    }
    
     private int index(int key){
        return (Integer.hashCode(key))%size;
    }
    
     private Node find(int key){
        int hashKey = index(key);

        Node head = hashMap[hashKey];
        Node prev = head; 
        Node curr = head; 


        while(curr!=null && curr.key!=key){
            
            prev = curr;
            curr = curr.next;
        }
        
        return prev;
    }
    public void put(int key, int value) {
       
        int hashKey = index(key);
     
        if(hashMap[hashKey] == null)
        {
            hashMap[hashKey] = new Node(-1,-1);
        }

        
        Node ptr = find(key);

      
        if(ptr.next == null){
            Node newEntry = new Node(key,value);
            ptr.next = newEntry;
        }
        
        else{
            ptr.next.value = value;
        }
    }
    
  
    
    public int get(int key) {
        int hashKey = index(key);
       
        Node ptr = find(key);
       
        if(hashMap[hashKey] == null){
            return -1;
        }
       
        if(ptr.next != null){
            return ptr.next.value;
        }
       
        else{
            return -1;
        }
    }
    
    public void remove(int key) {
          int hashKey = index(key);
       
        Node ptr = find(key);
      
        if(hashMap[hashKey] == null){
            return;
        }
        
        if(ptr.next != null){
            ptr.next = ptr.next.next;
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