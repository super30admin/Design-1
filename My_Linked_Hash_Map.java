// Time Complexity : get O(1)
//                   put O(1)
//                   remove O(1)
// Space Complexity : O(N)
// Run on leetcode : YES 
// Hashmap with Linkedlist implementation

// public class My_Linked_Hash_Map{
public class My_Linked_Hash_Map{
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    Node[] nodes;

    public My_Linked_Hash_Map(){
        nodes = new Node[10000];
    }

    public int index(int key){
        return Integer.hashCode(key) % nodes.length;
    }

    private Node find(Node head, int key){
        Node curr =  head;
        Node prev = null;
        while( curr != null && curr.key !=  key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = index(key);
        // if there is null value at index then create new linkedlist
        if(this.nodes[index] == null){
            // initialize the empty linkedlist with New Node having key and value = -1
            this.nodes[index] =new  Node(-1,-1);
        }
        // find the location where we should put new key to hashmap 

        Node prev = find(nodes[index], key);
        // if key is not present then add it at the end of linkedlist
        if(prev.next == null){
            prev.next = new Node(key, value);
        }else{
            // otherwise update the value
            prev.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        // get the index of bucket
        int index = index(key);
        // check the location of nodes
        if(this.nodes[index] == null){
            return -1;
        }
        Node prev =  find(nodes[index], key);
        if(prev.next == null){
            return -1;
        }else{
            return prev.next.value;
        }        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        // get the index of bucket
        int index = index(key);
        // check the location of the node to be removed
        if(nodes[index] == null) return;
        Node prev = find(nodes[index], key);
        // if node is null return -1 else return by removing the reference
        if(prev.next == null){
            return;
        }else{
            prev.next = prev.next.next;
        }
    }
    // public static void main(String[] args) {
    //     My_Linked_Hash_Map map = new My_Linked_Hash_Map();
    //     map.put(1,1);
    //     map.put(2,2);
    //     System.out.println(map.get(1));
    //     System.out.println(map.get(3));
    //     map.put(2,1);
    //     System.out.println(map.get(2));
    //     map.remove(2);
    //     System.out.println(map.get(2));
               
    // }
}