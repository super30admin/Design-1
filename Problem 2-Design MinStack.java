// Time Complexity : O(1)
// Space Complexity : If n be the number of elements in the stack then O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

I am using custom linked list to implement this stack , the next element would be the next element pushed in the stack ,
and the next min would be storing the pointer to the next minimum when min pointer , if the min is popped then min would use this pointer to 
point to the next minimum

class MinStack {
    StackNode current; // pointer for current element on the top of the stack
    StackNode min; // pointer for min

    public MinStack() {
        
        
    }
    
    public void push(int val) {

        StackNode node = new StackNode(val);
        // Stack has no elements
        if(current == null){
            current = node;
            min = node;
            return;
        }

        // Stack has elements

        // updating the current pointer
        StackNode prev = current;
        current = node;
        node.next = prev;

        // checking for min value
        if(node.val < min.val){
            StackNode prevMin = min;
            min = node; // update the min pointer to latest min
            node.nextMin = prevMin; // store the pointer to prev min
        }

    }
    
    public void pop() {
        // removing element from top
        StackNode removedNode = current;
        // updating the min to next min after this element pops
        if(min == removedNode){
            min = removedNode.nextMin;
        }
        current = current.next;
    }
    
    public int top() {
        return current.val;
    }
    
    public int getMin() {
        
         return min.val;
    }
}
// stack node for storing next element as well as next min
class StackNode{
    public int val;
    public StackNode next;
    public StackNode nextMin;

    public StackNode(int value){
        val=value;
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