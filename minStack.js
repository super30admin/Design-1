// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: Is sorting allowed? 

/**
 * initialize your data structure here.
 */
var MinStack = function() {
    this.stack = [];
    this.topIndex = -1; //initialize as empty
};

/**
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
    this.stack.push(x);
    this.topIndex = this.topIndex + 1;
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    this.stack.pop();
    this.topIndex = this.topIndex - 1;
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    return this.stack[this.topIndex];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    //create a copy with slice
    let sorted = this.stack.slice().sort(function(a,b) {return a - b});
    return sorted[0];
};

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
