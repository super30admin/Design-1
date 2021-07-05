//Exercise_1 : Design Hashmap--Using Linked List which is Linear Chaining
// Time Complexity : O(K)  -> for all operations where K will be size of linked list
// Space Complexity : O(N+K)=>Total Elements where N is size of parent array and K is the size of child list where value is stored(Linked List)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach

//Note: Here Single Hashing is implemented. I created a class Node and initialised array of Nodes. For each index I'm storing linked list of nodes  

// While traversing the linked list always return the prev node because, then operations such as get, put and remove can be done easily.



class MyHashMapLinkedList {

    /** Initialize your data structure here. */
    
    class Node{
        int key,value;
        Node next;
        
        Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    Node[] nodes;

    public MyHashMapLinkedList() {
        nodes = new Node[10000];//because child nodes length should be 100, if we will make parent to 10000 than child list will also be of 1000 and traversing 1000 nodes is not a good option
    }
    
    private int getIndex(int key){
        return Integer.hashCode(key)%nodes.length;//for finding th indexlest than 10000
    }
    
    private Node findPrev(Node head,int key){//because it will be common for get,put and remove. Once we get the prev node we can do anything
        Node curr = head;
        Node prev = null;
        
        while(curr!=null && curr.key!=key){
            
            prev = curr;
            curr = curr.next;
        }
        
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        
        if(nodes[index]==null){
            nodes[index] = new Node(-1,-1);
        }
        
        Node prev = findPrev(nodes[index],key);
        
        if(prev.next==null){
            prev.next = new Node(key,value);
        }else{
            prev.next.value = value;
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        
        if(nodes[index]==null){
            return -1;
        }
        
        Node prev = findPrev(nodes[index],key);
        
        if(prev.next==null){
            return -1;
        }
        
        return prev.next.value;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
        int index = getIndex(key);
        
        if(nodes[index]==null){
            return ;
        }
        
        Node prev = findPrev(nodes[index],key);
        
        if(prev.next==null){
            return;
        }
        
        prev.next = prev.next.next;
    }
}
