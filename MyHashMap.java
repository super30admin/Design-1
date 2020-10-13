package Day1;

class MyHashMap {
    
   // Time Complexity : O(n)
   // Assuming if all the n elements have the same hashcode, they will all be part of a linked list of n size, for which time complexity for insertion, deletion and retrieval is O(n) in worst case scenarios.
   // If there are no collisions in the map, then time complexity should be O(1) since we can directly access the array elements using their indexes.
   
   // Space Complexity : O(n)
   // If all elements inserted using put operation have the same hashcode, they will all be placed at a common index in the fixed size array. This linked list will have the same size as the no.of insertions done, hence space complexity will be O(n).
  
   // Did this code successfully run on Leetcode : No
   
   // Any problem you faced while coding this : 
   // 1) For very large inputs, expected output is not matching the output of the code. For normal inputs, it is working as expected. 
   // 2) Unable to implement double hashing
   
   
   // Implementing Hashmap using Array 
    public Node[] map;
   
   /** Initialize your data structure here. */
   public MyHashMap() {
      map = new Node[10000];
   }
   
   /** value will always be non-negative. */
   
   
   public void put(int key, int value) {
     
       Node newNode = new Node(key,value);
       
       // get hashcode of the new object
       // use this hashcode as index in 'map' array
       int idx = hashIndex(key);
       
       // if 'map' array does not have an element at idx position
       if(map[idx] == null){
           map[idx] = newNode;
       } 
       
       // if 'map' array has an element at idx position, then iterate through the linked list         // a) if no key in linked list matches inputted key, insert the new node at the end of the list  
      // b)  if key in linked list matches inputted key, replace the node with new node
       else {
           
           Node current = map[idx];
           Node pre = null;
           while(current != null){
               if(current.equals(newNode)){
                  
               	if(pre == null){
                     map[idx] = newNode;
                     return;
                   }
                  pre.next = newNode;
                   newNode.next = current.next;
                   return;
               }
               pre = current;
               current = current.next;
           }
           pre.next = newNode;
           
       }      
   }
   
   /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
   // 
   public int get(int key) {

       // get hashcode of the object to be retrieved
       // use this hashcode as index in 'map' array
       int idx = hashIndex(key);
     
       // return -1 if the 'map' array does not have an element at idx position
       if(map[idx] == null)
           return -1;
      
       // Traverse through the linked list at idx position and compare key values of nodes in linked list with the function argument
       // If any node's key value matches, then return that node's value
       // else keep iterating till the end of linked list
       Node current = map[idx];
     
       while(current != null){
           if(current.key == key){
               return current.value;
           }
           current = current.next;
       }
       
      return -1;
   }
   
   /** Removes the mapping of the specified value key if this map contains a mapping for the key */
   
   public void remove(int key) {
     
       // get hashcode of the object to be retrieved
       // use this hashcode as index in 'map' array
        int idx = hashIndex(key);
       
       // return -1 if the 'map' array does not have an element at idx position
        if(map[idx] == null)
               return;
       
       // Traverse through the linked list at idx position and compare key values of nodes in linked list with the function argument
       // If any node's key value matches, then delete that node by resetting next pointer using prev node
       // else keep iterating till the end of linked list
         Node current = map[idx];
         Node pre = null;
       
         while(current != null) {
           if(current.key == key) {
               if(pre == null) {
                     map[idx] = null;
                   return;
               } 
               pre.next = current.next;
               return;
           }
           pre = current;
           current = current.next;
         }      
   }
   
   // function to return hashcode for a numeric input
   public int hashIndex(int num){
       return Integer.hashCode(num) % 10000;      
   }

   // Create a custom class Node to implement a linked list in case of collision
   class Node{
       int key;
       int value;
       Node next;
       
       public Node(int k,int v){
           this.key = k;
           this.value = v;
           this.next = null;
       }
       
       // override Object class equals method
       public boolean equals(Object obj) {               
           if (obj == null) {
               return false;
           }
           Node other = (Node) obj;
           if (this.key != other.key) {
               return false;
           }
           return true;
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