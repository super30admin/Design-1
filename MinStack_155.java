import java.util.ArrayList;
import java.util.LinkedList;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MinStack_155 {

    /** initialize your data structure here. */
    
    LinkedList<Integer> list;
    ArrayList<Integer> min;
    
    
    public MinStack_155() {
        this.list = new LinkedList<>();
        this.min = new ArrayList<>();
        this.min.add(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        if(val <= this.min.get(min.size()-1)){
            this.min.add(val);
        }
        this.list.add(val);
        
    }
    
    public void pop() {
        
            int lastIndex=this.list.size()-1;
            int last=top();
            if(last== this.min.get(min.size()-1)){
                this.min.remove(min.size()-1);
            }
        this.list.remove(lastIndex);
        
        
    }

    
    public int top() {
       
             return this.list.get(list.size()-1);
 
       
    }
    
    public int getMin() {
        return this.min.get(min.size()-1);
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
