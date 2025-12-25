
/**
 * I am using two stacks here
 * One to track the values that we are pushing and popping, The other one is to track the minVal at that point of time.
 * Reduced more space by pushing the minVal into minStack if and only if the current val that we are pushing into stack is less than the minStack peek val.
 * 
 */

class MinStack {
    constructor(){
        this.minVal = Infinity;
        this.stack = [];
        this.minStack = [];
        this.minStack.push(this.minVal);
    }
    };
    
    /** 
     * @param {number} val
     * @return {void}
     */
    MinStack.prototype.push = function(val) {
       // compare the incoming value with the minVal and update the minVal if needed
       if(val <= this.minVal){
        this.minVal = val;
        // push the minVal on the minStack
       this.minStack.push(val);
       }
       // push the val on to stack
       this.stack.push(val);
    };
    
    /**
     * @return {void}
     */
    MinStack.prototype.pop = function() {
        const currVal = this.stack.pop();
        if(currVal === this.getMin()){
        this.minStack.pop();
        }
        this.minVal = this.minStack[this.minStack.length - 1];
        return currVal;
    };
    
    /**
     * @return {number}
     */
    MinStack.prototype.top = function() {
        return this.stack[this.stack.length - 1];
    };
    
    /**
     * @return {number}
     */
    MinStack.prototype.getMin = function() {
        return this.minStack[this.minStack.length - 1];
    };
    
    /** 
     * Your MinStack object will be instantiated and called as such:
     * var obj = new MinStack()
     * obj.push(val)
     * obj.pop()
     * var param_3 = obj.top()
     * var param_4 = obj.getMin()
     */