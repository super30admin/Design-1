// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No



/**
 * initialize your data structure here.
 */
var MinStack = function() {
    //acts like comstructor
    this.stack = []; //define two stacks, one for regular inputs and other for the smallest input
    this.min_stack = [];
};

/** 
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
    this.stack.push(x);
    //if smallest number, push to min_stack
    if(this.min_stack.length === 0 || x <= this.min_stack[this.min_stack.length - 1]) this.min_stack.push(x);
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    var a = this.stack.pop();
    if(a === this.min_stack[this.min_stack.length - 1]) this.min_stack.pop();
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    return this.stack[this.stack.length - 1]
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.min_stack[this.min_stack.length-1];
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */

var minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
console.log(minStack.getMin()); // return -3
minStack.pop();
console.log(minStack.top());    // return 0
console.log(minStack.getMin()); // return -2