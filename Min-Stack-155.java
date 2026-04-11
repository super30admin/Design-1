

// Time Complexity : O(1) for push, pop and top, O(n) for getMin where n is the number of elements in the stack
// Space Complexity : O(n) where n is the number of elements in the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
We can use an ArrayList to implement the min stack.
When the push function is called, we will add the element to the end of the arraylist.
When the pop function is called, we will remove the last element from the arraylist.
When the top function is called, we will return the last element from the arraylist.
When the getMin function is called, we will iterate through the arraylist and find the minimum element and return it.

*/

class MinStack {
    ArrayList<Integer> al = new ArrayList<Integer>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        al.add(al.size(), val);
       
        
    }
    
    public void pop() {
        al.remove(al.size()-1);
        
        
    }
    
    public int top() {
       int result = al.get(al.size()-1);
       return result;
        
    }
    
    public int getMin() {
        int min = al.get(0);
        for(int i =1 ; i<al.size(); i++){
            if(min > al.get(i)){
                min = al.get(i);
            }

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