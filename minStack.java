// Time Complexity : O(1) for each operation
// Space Complexity : O(n) where n is the size of queue. I am using 2 queues
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MinStack {

    /** initialize your data structure here. */

    //Create 2 stacks, one to store normal number other to store the smallest ammount in decreasing order
    ArrayList<Integer> minStack = new ArrayList<Integer>();
    ArrayList<Integer> minElements = new ArrayList<Integer>();
    int currentMin = Integer.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int val) {
        minStack.add(val);
        //Only add the value to the second stack if it's smaller than the previous
        if(val<=getMin()) {
            minElements.add(val);
            currentMin = val;            
        }
    }
    
    public void pop() {
        int lastValue = top();
        minStack.remove(minStack.size()-1);
        //If the element in the first stack is the same as the second stack then remove from second stack
        if(lastValue == getMin()) {
            minElements.remove(minElements.size()-1);
            currentMin = getMin();
        }
        
        
        if(minStack.size()==0)
            currentMin=Integer.MAX_VALUE;        
    }
    
    public int top() {
        return minStack.get(minStack.size()-1);
    }
    
    public int getMin() {
        //Just return the top value of the seecond stack as we have the smallest numbers in descending order
        if (minElements.size() == 0) return Integer.MAX_VALUE;
        return minElements.get(minElements.size()-1);
    }
    
}