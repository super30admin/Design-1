import java.util.Stack;
/*
Pushing into the other stack only if current element is lesser than the minstack top element
Popping whenever the tops of both the elements are equal
time complexity
push pop top peek O(1)
Space Complexity
average case: The number of new minimum values got are only upto half of the size of the stack log base2 (n)
*/
class MinStack {
Stack<Integer> a;
Stack<Integer> b=new Stack<Integer>();
    public MinStack() {
        a = new Stack<Integer>();
        b= new Stack<Integer>();
    }
    
    public void push(int val) {
        if(a.isEmpty()) {
        	a.push(val);
        	b.push(val);
        }
        else {
        	if(b.peek()>=val) {
        		a.push(val);
        		b.push(val);
        		
        	}
        	else {
        	a.push(val);
        	}
        }
    }
    
    public void pop() {
        if(a.peek().equals(b.peek())) {
        	a.pop();
        	b.pop();
        }
        else {
        	a.pop();
        }
    }
    
    public int top() {
        return a.peek();
    }
    
    public int getMin() {
        return b.peek();
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