// Time Complexity : Search O(1), Put O(1) and remove O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Forgot to use Math.Floor to avoid decimal issue


// Your code here along with comments explaining your approach
/**
 * I'm here using single stack approach and if the min value is not changed it's not getting pushed to the stack.
 * [PreMin Value, Value]
 */
var MinStack = function() {
    this.prevMin = Number.MAX_SAFE_INTEGER;
    this.stack = [];

    console.log(this.prevMin)
};

/** 
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(val) {
    
    if(this.prevMin >= val) {
        this.stack.push(this.prevMin);
        this.prevMin = val;
    }

    this.stack.push(val);
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    let temp = this.stack.pop();
    if(temp == this.prevMin) {
        this.prevMin = this.stack.pop();
    }
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
    return this.prevMin;
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */