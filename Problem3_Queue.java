/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class MyQueue {
Stack<Integer> queue = new Stack<Integer>();
public void push(int x)
{
    Stack<Integer> temp = new Stack<Integer>();
    while(!queue.empty())
    {
        temp.push(queue.pop());
    }
    queue.push(x);
    while(!temp.empty())
    {
        queue.push(temp.pop());
    }
}

public int pop()
{
    return queue.pop();
}

public int peek() 
{
    return queue.peek();
}

public boolean empty()
{
    return queue.empty();
}
public static void main(String args[]) 
{ 
        MyQueue q = new MyQueue(); 
        q.push(10); 
        q.push(20); 
        q.push(30); 
        System.out.println(q.pop() + " Popped from queue"); 
        System.out.println(q.peek() + " at top queue"); 
    } 
}
