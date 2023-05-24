// //assumption in the constraints is that the pop(), top() and getMin() will always be called on a non-empty stack
/// Time Complexity :
    //push() : O(1) as we are pushing to the top of the stack
    //pop() : O(1) as we are popping from the top of the stack
    //top() : O(1) as we read from the top of the stack
// Space Complexity : O(n) as we are using an auxiliary linked list to store Min values
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MinStack {

    int minValue = Integer.MAX_VALUE;
    Node stackTop;
    Node minStackTop;

    static class Node
    {
        int data;
        Node next;
    }

    public MinStack()
    {

    }

    public void push(int val)
    {
        if(stackTop == null)
        {
            //initially both are empty
            stackTop = new Node();
            stackTop.data = val;

            minStackTop = new Node();
            minStackTop.data = val;
            minValue = minStackTop.data;


            return;
        }

        //push a new node
        Node newNode = new Node();
        newNode.data = val;
        newNode.next = stackTop;
        stackTop = newNode;

        if(minStackTop != null && val <= minStackTop.data)
        {
            Node newMinNode = new Node();
            newMinNode.data = val;
            newMinNode.next = minStackTop;
            minStackTop = newMinNode;
            minValue = minStackTop.data;

        }
    }

    public void pop()
    {
        //if the minValue is at the top, pop from both the stacks
        if(minStackTop != null && minStackTop.data == stackTop.data)
        {
            minStackTop = minStackTop.next;
            minValue = minStackTop !=null ? minStackTop.data : Integer.MIN_VALUE;
        }
        stackTop = stackTop.next;
    }

    public int top()
    {
        return stackTop.data;
    }

    public int getMin()
    {
        return minValue;
    }
}

class Main
{
    public static void main(String[] args)
    {
        MinStack obj = new MinStack();
        obj.push(2147483646);
        obj.push(2147483646);
        obj.push(2147483647);
        System.out.println(obj.top());
        obj.pop();

        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        obj.push(2147483647);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.push(-2147483648);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}
