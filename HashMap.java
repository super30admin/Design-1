// Time Complexity : O(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {

    class Node{
        int key;
        int value;
        Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Node [] nodes;
    int buckets;
    
    public MyHashMap() {
        buckets = 10000;
        nodes = new Node [buckets]; //Primary array
    }
    
    //Hash function
    private int index(int key){
        return (Integer.hashCode(key) % buckets); //key can be anything i.e string
    }
    
    //To find previous pointer in the form of node
    private Node find(int key, Node node){
        Node prev = null;
        Node curr = node; //find is done in a linked list
        
        //Traverse the linked list until we have reached the last node or we have found the key
        while(curr !=null && curr.key != key){ 
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    public void put(int key, int value) {
        int index = index(key);
        
        //If there's no linked list present, then create one
        if(nodes[index] == null){       
            nodes[index] = new Node(-1,-1);
        }
        
        //Linked list is present
         Node prev = find(key, nodes[index]); //To find if key is already in linked list 
             
        //Previous at the end
        if(prev.next == null){
            prev.next = new Node(key, value);
        }    
        //Previous not at the end
        else{
            prev.next.value = value;
        }
    }
    
    
    public int get(int key) {
        int index = index(key);
        
        //If there's no linked list present, then create one
        if(nodes[index] == null) return -1;
        Node prev = find(key, nodes[index]);
        //Previous at the end
        if(prev.next == null) return -1;
        return prev.next.value;
        
        
    }
    
    public void remove(int key) {
        int index = index(key);
        
        //If there's no linked list present, then create one
        if(nodes[index] == null) return;
        Node prev = find(key, nodes[index]);
        
        //Previous at the end
        if(prev.next == null) return;
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