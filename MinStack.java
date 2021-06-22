// Time Complexity : O(1)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : Initially it was a bit challenging to keep track of Minimum element, but I was able to solve it


import java.util.*;
class MinStack {

    /** initialize your data structure here. */
    private int top;
    private int size;
    ArrayList<int[]> list;
    public MinStack() {
        top = -1;
        size = 0;
        list = new ArrayList<int[]>();
           
    }
    
    public void push(int val) {
         int arr[] = new int[2];
        if(size==0){
           arr[0] = val;
           arr[1] = val; 
           list.add(++top,arr);
            size++;
        return;
        }
        int min = list.get(top)[1];
        arr[0] = val;
        arr[1] = Math.min(val,min);
        list.add(++top,arr);
        size++;
    }
    
    public void pop() {
        if(size>0){
            top--;
            size--;
        }
        return;
    }
    
    public int top() {
        if(size>0)
            return list.get(top)[0];
        return -1;
            
    }
    
    public int getMin() {
        if(size>0){
            return list.get(top)[1];
        }
        return -1;  
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