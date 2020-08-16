/** LeetCode Execution: Executed without any problems, fastest among my other solutions */

/** Time Complexity: All operations -> O(1) 
 * Space Complexity: O(n)[Data] + O(n) [Storing min at each point] = O(n)
*/

/**
 * Using Linked list to store data as well as min of the chain (aka Stack here) at that time.
 * Push: Compare min from previous instant and update according for this instant.
 * Pop: just remove the top most element of the linked List
 * Top & getMin: This data is stored in "root" at any instant of the stack.
 * 
 * While writing this I realized should have used "head" instead of "root", more intutive and makes sense.
 * 
 */

class Node{
  int data;
  int min;

  Node next;

  Node(int x) {
    this.data = x;
    this.min = x;
    this.next = null;
  }
}

class MinStack {

  private Node root;

  /** initialize your data structure here. */
  public MinStack() {
      
  }
  
  public void push(int x) {
    if(root == null) {
      root = new Node(x);
      return;
    }
    Node newNode = new Node(x);
    newNode.min = Math.min(x, root.min);
    newNode.next = root;
    root = newNode;
      
  }
  
  public void pop() {
      root = root.next;
  }
  
  public int top() {
      return root.data;
  }
  
  public int getMin() {
      return root.min;
  }
}