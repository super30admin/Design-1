//Problem 2 MinStack
// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach

class MinStack {
    
    Stack<Integer> stack = new Stack();
    Stack<Integer> minimum = new Stack();
    public MinStack() {
        
    }
    
    public void push(int val) {
        
      stack.push(val);
      if(minimum.isEmpty() || minimum.peek() >= val) {
          minimum.push(val);
      }
        
    }
    
    public void pop() {
        
        if(stack.peek().equals(minimum.peek())){
            minimum.pop();
        }
           stack.pop();
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return minimum.peek();
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


//Problem1 HashMap
// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No(Implemented based on solution provided in class)

class MyHashMap {
    
    class Node{
        
        int key;
        int value;
       
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
         Node next;
    }
     
     Node[] nodes;
     int buckets;
     
     public MyHashMap(){
         buckets = 10000;
         nodes = new Node[buckets];
     }
     
     private int index(int key){
         return Integer.hashCode(key) % buckets;
     }
     
     private Node find(int key, Node node){
         
         Node prevNode = null;
         Node currNode = node;
         while(currNode != null && currNode.key != key){
             prevNode = currNode;
             currNode = currNode.next;
         }
         return prevNode;
     }
     
     public void put(int key,int value){
         int index = index(key);
         
         if(nodes[index] == null){
             nodes[index] = new Node(-1,-1);
         }
         
         Node prevNode = find(key,nodes[index]);
         if(prevNode.next == null){
             prevNode.next = new Node(key,value);
         }
         else{
             prevNode.next.value = value;
         }
     }
     
     public int get(int key){
         int index = index(key);
         if(nodes[index] == null) return -1;
         
         Node prevNode = find(key,nodes[index]);
         if(prevNode.next == null) return -1;
         else{
             return prevNode.next.value;
         }
     }
     
     public void remove(int key){
         int index = index(key);
         if(nodes[index] == null) return ;
         
         Node prevNode = find(key,nodes[index]);
         if(prevNode.next != null){
             prevNode.next = prevNode.next.next;
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