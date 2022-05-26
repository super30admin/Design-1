/* Time Complexity : O(1)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
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

    Node[] nodes;

    public MyHashMap() {
    	nodes = new Node[10000];
    }
    
    public int getIndex(int key) {
        return key%10000;
    }
    
    public Node find (Node head, int key){
        Node prev = head;
        Node curr = head.next;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
    	int indx = getIndex(key);
    	if(nodes[indx] == null) {
    		nodes[indx] = new Node(-1,-1);
    	}
    	
    	Node prev = find(nodes[indx], key);
    		
        if(prev.next == null){
            // no key found
            prev.next = new Node(key, value);
        } else {
            //Key is found
            prev.next.value = value;
        }
        
    }
    
    public int get(int key) {
    	
    	int indx = getIndex(key);
    	
        if(nodes[indx] == null)
        	return -1;
        
        Node prev = find(nodes[indx], key);
        
        if(prev.next == null) 
        	return -1;
        
        return prev.next.value;
        
    }
    
    public void remove(int key) {
    	
    	int indx = getIndex(key);
    	
        if(nodes[indx] == null) 
        	return;
        
        Node prev = find(nodes[indx], key);
        
        if(prev.next == null) 
        	return;
        
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
