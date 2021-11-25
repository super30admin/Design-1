// Time Complexity : O(len of LL at given index)
// Space Complexity : O( len of buckets array + len of LL)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * we will use a class Node with key, value and next pointer to keep track of key value pairs
 * We declare a primary array of size 10000. In this array we will use LinkedList to store all key value pairs
 * for put, we will 1st get primary array index using % as out hashing function. Then in LL at this index, we will search if Node with given key exists.
 * if yes we just updted its value or if not then we will insert new node with given key value pair at the end of LL
 * for get, we will get array index and then in given LL we will search if node with given key exists.
 * if yes, we return its value or else -1
 * For remove, again we get array index and we search if node exists with given key.
 * if yes we remove it by making its previous node to point at next to next node or else we return.
 * in all operations we use search to see if node exists with given key. This we do with a separate find method which looks for given key node
 * and also it keeps a track of previous node which helps us in remove operation
 * In this approach, we know that LL will have max of 100 nodes at any given index which is fix and does not depend on input and primary array has 1000 length 
 * which again does not depend on input so thats why Time complexity and Space complexity is as mentioned above instead of O(n)
*/

class MyHashMap {
    
    
    class Node {
        int key;
        int value;
        Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        
    }

    Node[] buckets;
    private Node find(Node prev, int key){
        Node curr = prev.next;
        
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        
        return prev;
    }
    
    private int hashing(int key){
        return key % 10000;
    }
    
    public MyHashMap() {
            this.buckets = new Node[10000];
        
            for(int i = 0; i < buckets.length; i++){
                buckets[i] = new Node(-1, -1);
            }
    }
    
    public void put(int key, int value) {
        int index = hashing(key);
        Node prev = find(buckets[index], key);
        
        
        if(prev.next != null){
          prev.next.value = value;  
        }else{
            prev.next = new Node(key, value);
        }
        
    }
    
    public int get(int key) {
        int index = hashing(key);
        Node prev = find(buckets[index], key);
         
        
        if(prev.next != null){
          return prev.next.value;  
        }else{
           return -1;
        }
        
        
    }
    
    public void remove(int key) {
        int index = hashing(key);
        Node prev = find(buckets[index], key);
        
          if(prev.next != null){
          prev.next = prev.next.next;  
        }else{
           return;
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
