/*
The time complexity is O(1) and the space complexity is O(N) where N is the number of elements added to the stack.

Here, the idea for every push is to check if the min top element is less than the current push. If yes than add the same min element
again to the min stack. Else add the current element to the min stack. This ensures that for each push only the min element till
that push will be on the top of min stack

Yes, the solution passed all the test cases in leetcode
 */
class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min;


    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(min.size()==0){min.push(x);}
        else{
            int peek = min.peek();
            if(peek>x){min.push(x);}
            else{
                min.push(peek);
            }
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */