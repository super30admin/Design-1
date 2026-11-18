/*

Approach 1 :
Two stacks

TC : O(1) for all the operations
SC: O(n) where n the the number of elements

we maintain two stacks , one to push the incoming element
and the second one keeps the track of the minimum element.


Approach 2 :
One stack

TC : O(1) for all the operations
SC: O(n) where n the the number of elements , since it will be 2n in the worst case of descending incoming elements

whenever the minimum changes i.e the incoming element is lesser than or equal to min
we push previous min and the incoming value, else we just push the incoming value

on pop we pop two element if the popped element equals min. we set the min to the second popped value.

edge case : we should always check equal to while pushing as this would break if there are duplicate elements.

*/

//Approach 2
class MinStack {

    Stack<Integer> st;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int value) {
        if(value <= this.min){
            this.st.push(this.min);
            this.min = Math.min(this.min,value);
        }
        this.st.push(value);
    }

    public void pop() {
        int popped = this.st.pop();
        if( popped == this.min){
            this.min = this.st.pop();
        }
    }

    public int top() {
        return this.st.peek();
    }

    public int getMin() {
        return this.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();

 Approach 1:

 class MinStack {

 Stack<Integer> st;
 Stack<Integer> minSt;
 int min;

 public MinStack() {
 this.st = new Stack<>();
 this.minSt = new Stack<>();
 this.min = Integer.MAX_VALUE;
 this.minSt.push(this.min);
 }

 public void push(int value) {
 this.min = Math.min(this.min,value);
 this.st.push(value);
 this.minSt.push(this.min);
 }

 public void pop() {
 this.st.pop();
 this.minSt.pop();
 this.min = this.minSt.peek();
 }

 public int top() {
 return this.st.peek();
 }

 public int getMin() {
 return this.min;
 }
 }
 */