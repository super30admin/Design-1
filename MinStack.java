// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.PriorityQueue;
import java.util.Stack;

class MinStack {
    //Creating Two Datastructure

    //PriorityQueue is created, to store elements in ascending order
    PriorityQueue<Integer> priorityQueue;
    //Stack is created, to store elements in sequencail order that user inserted
    Stack<Integer> stack;

    //Initializing PriorityQueue and Stack
    public MinStack() {
        this.priorityQueue = new PriorityQueue<>();
        this.stack = new Stack<>();
    }
    

    //Adding Elements
    public void push(int val) {
        priorityQueue.add(val);
        stack.push(val);
    }
    
    //Deleting elemnets
    public void pop() {
        //First Deleting the top element in the queue and storing the value
        int value = stack.pop();
        //Deleting the same element in the PriorityQueue by passing value as parameter
        priorityQueue.remove(value);
    }
    
    //Retriving top element from stack
    public int top() {
        return stack.peek();
    }
    
    //Retriving top element from PriorityQueue results in getting minimum value
    public int getMin() {
        return priorityQueue.peek();
    }
}