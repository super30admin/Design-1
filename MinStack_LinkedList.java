/*Time Complexity for push, pop and top operations: O(1)
 *Space Complexity : O(N)
 *Did this code successfully run on Leetcode :Yes
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class MinStack {
	
	private List<Integer> data; 
    private int min;
    private int indexOfLast;
    private int indexOfMin;

    public MinStack() { 	
    	data = new LinkedList<>(); 
        min = Integer.MAX_VALUE;
        indexOfLast = -1;
        indexOfMin = -1;   
    }
    
    public void push(int val) {
    	indexOfLast++;
        if(val < min){
            min = val;
            indexOfMin = indexOfLast;
        }
        data.add(val);
    }
    
    public void pop() {
    	data.remove(data.size()-1);
        
        int newMin = Integer.MAX_VALUE;
        int indexOfNewMin = -1;
        for(int i = 0; i < data.size(); i++){
            if(data.get(i) < newMin){
                newMin = data.get(i);
                indexOfNewMin = i;
            }
        }

        min = newMin;
        indexOfMin = indexOfNewMin;
    }
    
    public int top() {
    	return data.get(data.size()-1);
    }
    
    public int getMin() {
    	return min;
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