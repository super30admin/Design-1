// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import java.lang.Math;
import java.util.*;

class MinStack {
    ArrayList<Integer> arr;
    /** initialize your data structure here. */
    public MinStack() {
        arr = new ArrayList<Integer>();
    }

    public void push(int val) {
        arr.add(val); //appends to the end of arr
    }

    public void pop() {
        arr.remove(arr.size() - 1);
    }

    public int top() {
        int len = arr.size() - 1;
        return arr.get(len);
    }

    public int getMin() {
        int min = (int)Math.pow(2,31);
        for (Integer num: arr){
            min = (min > num) ? num : min;
        }
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