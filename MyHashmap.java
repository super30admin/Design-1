// Time Complexity : O(n) for all operations. Since all operations call the find function whose worst case Time complexity is O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


class MyHashMap { 
    Node[] nodes = new Node[10000];  //array of type singly linkedlist
    class Node{ //linkedlist data structure. Every node is associated with a key and value along with a next pointer
        int key;
        int val;
        Node next;
        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    private Node find(Node head, int key)
    { //Routine to find prev element in the singly list. 
        Node curr = head;
        Node prev = null;
        while(curr!= null && curr.key!= key)
        { //iterate until previous is at the end of the linked list or next of previous is the key
            prev= curr;
            curr = curr.next;
            
        }
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) { 
        int index = Integer.hashCode(key) % nodes.length;   //generate hash code
        if(nodes[index] == null)
        {   //insert dummy node if there is no linkedlist initialized at that particular index in the array
            nodes[index] = new Node(-1, -1);
        }
        Node prev = find(nodes[index], key);  //from the find function we now have the previous
        if(prev.next == null)  
        {
            prev.next = new Node(key, value); //if previous is end of the list, put the key, value pair after it.
        }
        else{ //prev.next == key          // key already exists
              prev.next.val = value;      //if the next of previous is the key, then just overwrite it with the new value      
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) { 
        int index = Integer.hashCode(key) % nodes.length;
        if(nodes[index] == null)
        {
            nodes[index] = new Node(-1, -1);
        }
        Node prev = find(nodes[index], key);
        if(prev.next == null)
        {  // if previous is at the end of the linkedlist, return -1 because element does not exist
            return -1;
        }
        else{
            return prev.next.val; //if key is found, return the value 
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = Integer.hashCode(key) % nodes.length;
        if(nodes[index] == null) return ; //if linkedlist at array index is null, just return
        Node prev = find(nodes[index], key);
        if(prev.next == null) return ; //if previous reaches end of list, just return since element to remove does not exist
        else{
            prev.next = prev.next.next; //else, just let previous point to the node next to the node with the key. garbage collector will handle the rest
        }
        
    }
}

// Class with main function
class Main
{
    public static void main(String[] args)
    {
    MyHashMap hashMap = new MyHashMap();
    System.out.println("Putting 1,1\n");
    hashMap.put(1, 1);          
    System.out.println("Putting 2,2\n"); 
    hashMap.put(2, 2);         
    System.out.println("Value at key 1 is " + hashMap.get(1));            // returns 1
    System.out.println("\nValue at key 3 is " + hashMap.get(3));            // returns -1 (not found)
    System.out.println("Putting 2,1\n"); 
    hashMap.put(2, 1);                                                    // update the existing value
    System.out.println("Value at key 2 is " + hashMap.get(2));            // returns 1 
    System.out.println("\nRemoving 2");
     hashMap.remove(2);          // remove the mapping for 2
    System.out.println("\nValue at key 2 is " + hashMap.get(2));            // returns -1 (not found) 
    
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */