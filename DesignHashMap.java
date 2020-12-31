
public class DesignHashMap {
	Node[] nodes;
    class Node{
        int key;
        int value;
        Node previous;
        Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        
    }
    
    private int indexHashing(int key){
        return Integer.hashCode(key) % nodes.length;
    }

    /** Initialize your data structure here. */
    public DesignHashMap() {
        nodes = new Node[10000];
    }
    
    private Node find(Node head, int key){
        Node current = head;
        Node previous = null;
        while(current != null && current.key != key){
            previous = current;
            current = current.next;
        }
        return previous;
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = indexHashing(key);
        //To create the head node with -1,-1 as the key, value
        if(nodes[i] == null){
            nodes[i] = new Node(-1, -1);
        }
        Node previous = find(nodes[i], key);
        //When key is not present add the node with the new key, value
        if(previous.next == null){
            previous.next = new Node(key, value);
        }
        //When key is present update the node with the new value
        else{
            previous.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = indexHashing(key);
        //To check whether the linked list is present
        if(nodes[i] == null) return -1;
        //If link list is present then findthe node with the key
        Node previous = find(nodes[i], key);
        //To check when the linkedlist is present but not able to find the node
        if(previous.next == null) return -1;
        return previous.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = indexHashing(key);
        //To check whether the linked list is present
        if(nodes[i] == null) return;
        //If link list is present then findthe node with the key
        Node previous = find(nodes[i], key);
        //To check when the linkedlist is present but not able to find the node
        if(previous.next == null) return;
        previous.next = previous.next.next; 
    }
    
    public static void main(String[] args) {
    	DesignHashMap hashMap = new DesignHashMap();
    	hashMap.put(1, 1);          
    	hashMap.put(2, 2);         
    	int param_2 = hashMap.get(1);            // returns 1
    	int param_3 = hashMap.get(3);            // returns -1 (not found)
    	hashMap.put(2, 1);          // update the existing value
    	int param_4 = hashMap.get(2);            // returns 1 
    	hashMap.remove(2);          // remove the mapping for 2
    	int param_5 = hashMap.get(2);            // returns -1 (not found) 

    	System.out.println(param_2);
    	System.out.println(param_3);
    	System.out.println(param_4);
    	System.out.println(param_5);
	}
}
