
/**
 * Time Complexity :O(1) 
 * Space Complexity : O(n) 
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 *
 */
class MinStack
{

  /** initialize your data structure here. */
  private Node topNode;

  class Node
  {
    int val;
    Node nextNode;
    int minVal;

    Node (int val)
    {
      this.val = val;
      if (topNode != null)
      {
        this.minVal = topNode.minVal > val ? val : topNode.minVal;
      }
      else
      {
        this.minVal = val;
      }
    }
  }

  public MinStack ()
  {
    topNode = null;
  }

  public void push (int val)
  {
    Node node = new Node(val);
    node.nextNode = topNode;
    topNode = node;
  }

  public void pop ()
  {
    topNode = topNode.nextNode;
  }

  public int top ()
  {
    return topNode.val;
  }

  public int getMin ()
  {
    return topNode.minVal;
  }
}

public class MinStackMain
{
  public static void main (String[] args)
  {

    MinStack obj = new MinStack();
    obj.push(-2);
    obj.push(0);
    obj.push(-3);
    System.out.println(obj.getMin());
    obj.pop();
    System.out.println(obj.top());
    System.out.println(obj.getMin());
  }
}
