// Time Complexity : O(1) for each function
// Space Complexity : O(n) where n is the number of values in the stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class MinStack
{
  private class Node
  {
    int val;
    int min;
    Node next;

    private Node(int val, int min, Node next)
    {
      this.val = val;
      this.min = min;
      this.next = next;
    }
  }

  private Node head;

  public MinStack()
  {

  }

  public void push(int val)
  {
    if(head == null)
      head = new Node(val, val, null);
    else
    {
      head = new Node(val, Math.min(val, head.min), head);
    }
  }

  public void pop()
  {
    head = head.next;
  }

  public int top()
  {
    return head.val;
  }

  public int getMin()
  {
    return head.min;
  }
}
