// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :took lot of time to understand still going thorough class afetr successful compilation


// Your code here along with comments explaining your approach
class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
    public Node(int key,int val){
         this.key =key;
        this.val = val;
     }
    }
    Node [] nodes;
    int buckets;
    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets]; 
    }
    public int index(int key){
        return Integer.hashCode(key)%buckets;
    }
    public Node find(int key, Node node){
        Node prev=null;
        Node cur = node;
        while(cur!=null && cur.key != key){
            prev = cur;
            cur = cur.next;
        }
            return prev;
    }
    public void put(int key, int value) {
        int index = index(key);
        if(nodes[index] == null){
        nodes[index] = new Node(-1,-1);
        }
    Node prev = find(key, nodes[index]);
        if(prev.next==null){
            prev.next = new Node(key,value);
        }else
            prev.next.val = value;
    }
    public int get(int key) {
        int index = index(key);
        if(nodes[index] == null) return -1;
         Node prev = find(key, nodes[index]);
        if(prev.next == null) return -1;
        return prev.next.val;
    }
    
    public void remove(int key) {
        int index = index(key);
        if(nodes[index] == null) return;
        Node prev = find(key, nodes[index]);
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



 /////
 //problem 2
 //Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    private Stack<Integer> st;
    private int min;
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;    
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