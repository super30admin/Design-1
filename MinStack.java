// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : is time complexity right for this problem i am a bit confused.

class MinStack {

    /** initialize your data structure here. */
    static final int MAX = 1000;
    int top;
    int smallest;
    int a[] = new int[MAX]; // Maximum size of Stack

    public MinStack() {
        this.top = -1;
    }

    public void push(int x) {
        if (top > 1000) {
            System.out.println("Stack OverFLow");
        } else {
            top = top + 1;
            a[top] = x;
        }
    }

    public void pop() {

        if (top == -1) {
            System.out.print("Stack Underflow");
        } else {
            top = top - 1;

        }
    }

    public int top() {
        if (top == -1) {
            System.out.print("Stack Underflow");
            return 0;
        } else {
            return a[top];

        }

    }

    public int getMin() {
        smallest = 0;
        if (top == -1) {
            System.out.print("Stack Underflow");
            return 0;
        } else {
            for (int i =0 ; i <= top; i++) {
                if (a[i] < smallest) {
                    smallest = a[i];
                } 
            }

        }
        return smallest;
    }

    boolean isEmpty() 
    { 
        //Write your code here 
        if(top== -1){
            System.out.print("Stack Underflow");
            return true;
        }else{
            return false;
        }

    } 

    boolean isFull() 
    { 
        //Write your code here 
        if(top > 1000){
            System.out.println("Stack OverFLow");
            return true;
        }else{
            return false;
        }

    } 
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */