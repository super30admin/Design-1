// Time Complexity : O(N)
 // Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
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
    
    Node[] nodes;
    int buckets=10000;

    private Node findNode(Node node,int key){
        Node prev = node;
        Node curr = node.next;
        while(curr!=null && prev.next.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev; 
    }
    
    public MyHashMap() {
        int buckets =10000;
        nodes= new Node[buckets];
    }
    
    private int getHash(int key){
        return key % buckets;
    }
    
    public void put(int key, int value) {
        // int i= getHash(key);
        int i= key % buckets;
        if(nodes[i] == null){
            nodes[i]= new Node(-1,-1);
        }
        Node prev = findNode(nodes[i],key);
        if(prev.next == null){
            prev.next = new Node(key,value);
        }
        else{
            prev.next.value=value;
        }
    }
    
    public int get(int key) {
        int index = getHash(key);
        if(nodes[index]==null){
            return -1;
        }
        Node prev = findNode(nodes[index],key);
        if(prev.next == null){
            return -1;
        }
        else{
            return prev.next.value;    
        }
    }
    
    public void remove(int key) {
        int index = getHash(key);
        if(nodes[index]==null){
            return;
        }
        Node prev = findNode(nodes[index],key);
        if(prev.next == null){
            return;
        }
        else{
            prev.next=prev.next.next;
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