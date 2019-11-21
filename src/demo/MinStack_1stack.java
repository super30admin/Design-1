package demo;

//Time complexity : O(1)
//Space Complexity: O(n)
//LeetCode : yes


import java.util.Stack;

public class MinStack_1stack {

}


class MinStack2 {

	Stack<Integer> st = new Stack<>() ;
	//    Stack <Integer> minStack = new Stack<>();
	Integer min = Integer.MAX_VALUE;
	/** initialize your data structure here. */


    public void push(int x) {
    if(x <= min){
        st.push(min);
        min = x;
    }
    st.push(x);
}

	public void pop() {
		int one = st.pop();
		if(one == min) {
			min = st.pop();
		}
		//        minStack.pop();
		//        min = minStack.peek();
	}

	public int top() {
		return st.peek();
	}

	public int getMin() {
		return min;
	}
}