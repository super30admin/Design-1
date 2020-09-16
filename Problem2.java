// Time Complexity : O(1)
// Space Complexity : no auxillary space utilised
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    private List<Integer> stack ;
    int min;

    /** initialize stack data structure here. */
    public MinStack() {
        stack =  new ArrayList<>();
        min = Integer.MAX_VALUE;
    }

    /** push operation first checks if new value would replace min,
     * if so, it adds current min to stack and reassigns new value as current min **/
    public void push(int x) {
        if(x<=min){
            stack.add(min);
            min = x;
        }
        stack.add(x);

    }

    /** When removing an element we need to check if the element is equal to the current min
     * if so, we need to replace current min by the value under element, i.e, pop twice **/
    public void pop() {
        int index = stack.size()-1;
        if(stack.remove(index)==min){
            index = stack.size()-1;
            min = stack.remove(index);
        }

    }

    /** top function just returns the top element without removal **/
    public int top() {
        int index = stack.size()-1;
        return stack.get(index);
    }

    /** get min returns the current mininum value in the stack **/
    public int getMin() {
        return min;
    }
}
