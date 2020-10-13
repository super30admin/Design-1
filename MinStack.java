// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : I am getting error in my first approach.That Code in comments at last
// Any problem you faced while coding this : Error 
// Line 34: error: constructor MinStack in class MinStack cannot be applied to given types; [in __Driver__.java]
//         return new MinStack();
//                ^
//   required: int
//   found:    no arguments
//   reason: actual and formal argument lists differ in length


// Your code here along with comments explaining your approach

class MinStack {

    private Stack<int[]> stack = new Stack<>();
    
    public MinStack() { }
    
    
    public void push(int x) {
        
        /* If the stack is empty, then the min value
         * must just be the first value we add. */
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
            return;
        }
        
        int currentMin = stack.peek()[1];
        stack.push(new int[]{x, Math.min(x, currentMin)});
    }
    
    
    public void pop() {
        stack.pop();
    }
    
    
    public int top() {
        return stack.peek()[0];
    }
    
    
    public int getMin() {
        return stack.peek()[1];
    }
}





//My original solution

// class MinStack {
//     int min = Integer.MIN_VALUE; 
//     MinStack root;
//     int data;
//     MinStack next;
//     /** initialize your data structure here. */
//     public  MinStack(int data) {
//         this.data = data;    
//     }
    
//     public boolean isEmpty() {
//         return (root == null);
//     }
    
//     public void push(int x) {
//         if(min>x){
//             min=x;
//         }
//         MinStack node = new MinStack(x);

//         if (isEmpty()) {
//             root = node;
//         } else {
//             node.next = root;
//             root = node;
//         }
//     }
    
//     public void pop() {
//         if (!isEmpty()) {
           
//             root = root.next;

//            // return val;
//         } else {
//             System.out.println("Stack Underflow");
//            // return 0;
//         }
//     }
    
//     public int top() {
//          if (!isEmpty()) {
//             return root.data;
//         } else {
//             System.out.print("Empty Stack");
//             return -1;
//         }
//     }
    
//     public int getMin() {
//         return min;
//     }
// }
