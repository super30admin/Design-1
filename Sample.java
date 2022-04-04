// Time Complexity : O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MinStack {
    int min;
    Stack<Integer> st;

    public MinStack() {
        min = Integer.MAX_VALUE;
        st = new Stack<>();
        
    }
    
    public void push(int val) {
        if(val <= min){
            st.push(min);
            min = val;
        }
        st.push(val);
    }
    
    public void pop() {
        if(min == st.pop()){
            min = st.pop();
        }
    }
    
    public int top() {
       return st.peek(); 
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */









// Implement a HashMap

class MyHashMap {

    class Node{
        int key,value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int buckets;
    Node[] nodes;
    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }
    
    private Node find(Node head, int key) {
        Node prev = head;
         Node curr = head.next;
        while(curr != null && curr.key != key) {
           prev = curr;
           curr = curr.next;
            
        }
        return prev;
    }
    
    private int getHash(int key){
        return key % buckets;
    }
    
    public void put(int key, int value) {
       int index = getHash(key);
        if(nodes[index] == null){
            nodes[index] = new Node(-1,-1);
        }
        Node prev = find(nodes[index], key);
        if(prev.next == null){
            prev.next = new Node(key,value);
            
        }else{
            prev.next.value = value;
            
        }
    }
    
    public int get(int key) {
         int index = getHash(key);
        if(nodes[index] == null){
            return -1;
        }
        Node prev = find(nodes[index], key);
        if(prev.next == null){
            return -1;
            
        }
          return  prev.next.value;
            
        
        
    }
    
    public void remove(int key) {
       int index = getHash(key);
        if(nodes[index] == null){
            return;
        }
        Node prev = find(nodes[index], key);
        if(prev.next == null){
            return;
            
        }
           prev.next = prev.next.next ;
              
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */