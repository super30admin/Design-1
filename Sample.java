// Time Complexity :
//push, pop, peek, top, getMin: O(1)

// Space Complexity : O(n) for n elements in the stack

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
  class Node {
      int data;
      int min;
      Node next;
      
      Node(int data, int min){
          this.data = data;
          this.min = min;
          this.next = null;
      }
  }

  Node head;
  
  public MinStack() {
  }
  
  public void push(int val) {
      
      if(head == null) {
          Node node = new Node(val, val);
          head = node;
      } else{
          Node node = new Node(val, Math.min(head.min, val));
          node.next = head;
          head = node;
      }
  }
  
  public void pop() {
      if(head != null) {      
          head = head.next;    
      }
  }
  
  public int top() {
      return head.data;
  }
  
  public int getMin() {
      return head.min;
  }
}