// Time Complexity : O(1)
// Space Complexity : O(1) -- not sure about this
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : Didn't think of directly using stack data structure readily available in java. 
Hence tried doing it with arraylist to store data and a linkedlist to store all the previous minimum values as when we remove the top,
our current min may be the top value so we need to update this with our previous min value which could be done using linkedlist as 
stack in O(1) Time Complexity i.e. using the getLast and removeLast feature and also using a top pointer variable. */


// Your code here along with comments explaining your approach


import java.util.*;
class MinStack {
    ArrayList<Integer> arr;
    LinkedList<Integer> ll;
    int top;
    Integer min;
    Integer prevMin;
    public MinStack() {
        arr = new ArrayList<Integer>();
        top = -1;
        ll = new LinkedList<Integer>();
    }
    
    public void push(int val) {
        arr.add(val);
        top++;
        
        if(min==null){ // adds element for the first time
            min = val;
            ll.add(min);
            
        }
        else if(val<=min){ // updates the min
            min = val;
            ll.add(min);
            
        }
    }
    
    public void pop() {
        
            if(top>-1){
                if(arr.get(top).equals(min)){ // didn't knew when Integer type .equals() and for int == works correctly
                    //update min
                    ll.removeLast();
                    if(ll.isEmpty()){
                        min = null;
                    }else{
                        min = ll.getLast();
                    }
                }
                arr.remove(top);   
                top--;
           }
    }
    
    public int top() {
        return arr.get(top);
    }

    
    public int getMin() {
        return ll.getLast();
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