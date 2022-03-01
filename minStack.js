// Time Complexity : Time complexity is provided after each functions

// Did this code successfully run on Leetcode : Yes code ran successfully on Leetcode

// Any problem you faced while coding this : Not an issue exactly but I couldn't figure out the way of having O(1) 
// time complexity for getMin function

var MinStack = function() {
    this.stack = []
    this.currentIndex = 0    
}; //O(1)

/** 
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(val) {
    this.stack[this.currentIndex] = val;
    this.currentIndex++;
}; //O(1)

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    this.currentIndex -= 1;
}; //O(1)

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    return this.stack[this.currentIndex-1]
}; //O(1)

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    let min = 99999999999999999999;
    for (let i = this.currentIndex - 1; i >= 0; i--) {
        min = this.stack[i] <= min ? this.stack[i] : min
    }
    return min;
}; //O(n)

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */