// Time Complexity : 4ms, faster than 97.86%
// Space Complexity : 48.4 MB, less than 90.85%
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// I created 2 stacks, 
// stack: for elements
// bank: for past min values
// Then I assumer first min value to be Integer.MAX_VALUE and pushed it in bank
// Then, all min values are pushed into bank such that min.peek() = current min value
// as, stack is poped, if popped element == current element, bank is also popped and the new min. element is bank.peek()
// This way I was able to handle minimum values and was able to get the required algorithm  



class MinStack {

    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> bank = new Stack<>();
    
    public MinStack() {
        bank.push(min); 
    }
    
    public void push(int val) {
       if (val <= min){
           min = val;
           bank.push(val);
       }
       
       stack.push(val); 
       
    }
    
    public void pop() {
        int abc = stack.pop();
        if (abc == min){
            bank.pop();
            min = bank.peek();
        }
       
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}




// approach 2:
// class MinStack {

//     private int min = 0;
//     private Stack<Integer> stack = new Stack<>();
//     private Stack<Integer> bank = new Stack<>();
    
//     public MinStack() {
         
//     }
    
//     public void push(int val) {
//        if (stack.empty()){
//            min = val;
//            bank.push(val);
//        }
//        else if(min>=val){
//            min = val;
           
//        }
       
//        stack.push(val);
//        bank.push(min); 
    
//     }
    
//     public void pop() {
        
//         int abc = stack.pop();
//         bank.pop();
//         min = bank.peek();
        
    
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int getMin() {
//         return min;
//     }
// }
