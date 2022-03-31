//Time Complexity : O(1)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class MyHashMap {
    class Node{
        int key, value;
        Node next;
        //constructor for key and value
        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    int primaryArray=10000;//indices in the primary Array
    Node[] nodes;//primary array is of type node
    public MyHashMap() {
       nodes=new Node[primaryArray];        
    }
    
    //find method, returns a node
    private Node find(Node head, int key){
        Node previousNode= head;
        Node currentNode=head.next;
        while(currentNode != null && currentNode.key != key){
            previousNode=currentNode;
            currentNode=currentNode.next;
        }
        return previousNode;
    }
    
    //hash function, give a key and returns index of the primary array
    private int hashFunction(int key){
        return Integer.hashCode(key)%primaryArray;
        //return key%primaryArray;
    }
    public void put(int key, int value) {
       int arrayIndex=hashFunction(key);
        //will check nodes index, if it is null create a dummy node with key value(-1,-1)
        if(nodes[arrayIndex]==null)
            nodes[arrayIndex]=new Node(-1, -1);
        //we will call the find method
        Node previousNode=find(nodes[arrayIndex],key);
        //if key exists, check if next node of the previous node is null or not
        if(previousNode.next==null)
            //will insert the new key and value
            previousNode.next=new Node(key, value);
        else
            previousNode.next.value=value;           
    }
    
    public int get(int key) {
        int arrayIndex=hashFunction(key);
        if(nodes[arrayIndex]==null)
            return -1;
        Node previousNode=find(nodes[arrayIndex],key);
        if(previousNode.next==null)
            return -1;
        return previousNode.next.value;
    }
    
    public void remove(int key) {
        int arrayIndex=hashFunction(key);
        if(nodes[arrayIndex]==null)
            return;
        Node previousNode=find(nodes[arrayIndex],key);
        if(previousNode.next==null)
            return;
        previousNode.next=previousNode.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */