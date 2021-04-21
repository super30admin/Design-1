// Time Complexity :-
//      Push - O(1)
//      Pop - O(1)
//      Top - O(1)
//      getMin - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MinStack {

    List<Pair> stack;
    
    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.add(new Pair(val,val));               // If it is the first element of the stack, it would be (val,val)
            return;
        }
        int minVal = stack.get(stack.size()-1).min;     // For all other elements we find the last index's minimum and compare it to the current value
        stack.add(new Pair(val,Math.min(val,minVal)));
    }
    
    public void pop() {
        stack.remove(stack.size()-1);                   
    }
    
    public int top() {
        return stack.get(stack.size()-1).val;
    }
    
    public int getMin() {
        return stack.get(stack.size()-1).min;
    }
    
    /*
        We define a Pair, wherin val holds the value at that height of the stack
        And min holds the minimum value of the stack up to that height
    */
    class Pair {
        int val;
        int min;
        public Pair(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
}

