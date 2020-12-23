// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * I followed Professor's approach for this problem leveraging two stacks.
 * Stack1 will be used to push and pop
 * Stack2 will be used to maintain the minimum element
 * On a push operation we can push the element on Stack1 and compare that element with the top element(minimum) on Stack2
 * If current element < top element on Stack2, we can push new minimum to stack2 else we can push same minimum to Stack2 again
 * While popping we can remove element from Stack1 and Stack2
 * **/
class MinStack {

    /** initialize your data structure here. */
    /**
     We can create two stacks here
     In first stack we will push everything
     While pushing a new element to stack 1 we will compare it withe the top element           of stack 2which will be the minimum element
     Stack1 - All inputs
     Stack2 - Minimum data
     **/
    Stack<Integer> s1;
    Stack<Integer> s2;
    int min;
    public MinStack() {
        s1 = new Stack();
        s2 = new Stack();
        this.min = Integer.MAX_VALUE;
        s2.push(min);
    }

    public void push(int x) {
        s1.push(x);
        if(s2.peek()>x)
            s2.push(x);
        else
            s2.push(s2.peek());
    }

    public void pop() {
        if(!s1.isEmpty())
        {
            s1.pop();
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
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