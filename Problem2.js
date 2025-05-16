// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Missed out on the edge case of setting val as a initial value when minStack is empty
//!    let min = this.minStack.length === 0 ? val : Math.min(val, this.minStack[this.minStack.length - 1]);

//## Problem 2:

//Design MinStack (https://leetcode.com/problems/min-stack/)

var MinStack = function() {
    this.stack = []
    this.minStack = []

};

/** 
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(val) {
    //TC = O(1)
    //SC = O(1)
    //Push the value in stack and the min of 2 values the existing one in min stack and the val
    let min = this.minStack.length === 0 ? val : Math.min(val, this.minStack[this.minStack.length - 1]);
    this.stack.push(val)
    this.minStack.push(min)
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    //TC = O(1)
    //SC = O(1)
    //Pop from both stacks
    this.minStack.pop()
    this.stack.pop()
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    //TC = O(1)
    //SC = O(1)
    //Just return the last element 
    return this.stack[this.stack.length-1]
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    //return the last ele from the stack
     //TC = O(1)
    //SC = O(1)
    return this.minStack[this.minStack.length-1]
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */