// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :Few Silly mistakes


// Your code here along with comments explaining your approach

class MinStack {
    int min=Integer.MAX_VALUE;
    int top=-1;
    ArrayList<Integer> stack;
    static Stack<Integer> minStack;
    public MinStack() {
        stack = new ArrayList<Integer>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        top++;
        if(min>=val){
            min=val;
            minStack.push(val);
        }
        stack.add(val);
    }

    public void pop() {
        //System.out.println(stack.get(top)+" result "+minStack.peek());
        if(Objects.equals(stack.get(top), minStack.peek())){
            //System.out.println("poped");
            minStack.pop();
            if(minStack.isEmpty()){
                min=Integer.MAX_VALUE;
            }else
                min=minStack.peek();

        }

        stack.remove(top);
        top--;
    }

    public int top() {
        return stack.get(top);
    }

    public int getMin() {
        return minStack.peek();
    }

}

