/*
Approach :
Maintain two stacks one which stores the value and other which stores the min so far
1. Push: if the stack is empty push val to both stack1 and min stack else push val to stack and minimum of val and top of minstack
2. Pop : pop the top elements from both the stacks
3. Top :return top of the first stack
4. GetMin : return top of the minstack


TC : O(1)
SC : O(N) where N is the size of the input

*/

class MinStack {
    Stack<Integer> stk1;
    Stack<Integer> stk2;

    public MinStack() {
        stk1 = new Stack<Integer>();
        stk2 = new Stack<Integer>();
    }

    public void push(int val) {
        if(stk2.isEmpty()){
            stk2.add(val);
        }
        else{
            stk2.push(Math.min(val,stk2.peek()));
        }
        stk1.push(val);
    }

    public void pop() {
        stk1.pop();
        stk2.pop();
    }

    public int top() {
        return stk1.peek();
    }

    public int getMin() {
        return stk2.peek();
    }
}