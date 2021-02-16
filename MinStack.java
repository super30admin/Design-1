// Using stack

class MinStack {
    
    Stack<Integer> stack;
    int minVal = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if(x <= minVal){
            stack.push(minVal);
            minVal = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        int poppedVal = stack.pop();
        if(minVal == poppedVal){
            minVal = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minVal;
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


// Using array

// class MinStack {

//     int[] arr;
//     int minVal = Integer.MAX_VALUE;
//     int ptr = -1;
//     /** initialize your data structure here. */
//     public MinStack() {
//         arr = new int[1000000];
//     }
    
//     public void push(int x) {
//         ptr++;
//         if(x <= minVal){
//             arr[ptr++] = minVal;
//             minVal = x;
//         }
//         arr[ptr] = x;
//     }
    
//     public void pop() {
//         int poppedVal = arr[ptr--];
//         if(poppedVal == minVal){
//             minVal = arr[ptr--];
//         }
//     }
    
//     public int top() {
//         return arr[ptr];
//     }
    
//     public int getMin() {
//         return minVal;
//     }
// }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */