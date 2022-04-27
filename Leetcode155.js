// Time Complexity : 0(1) for push,pop,top,getMin()
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

Using two stack concept one to store minimum value and other to store regular value of array.


var MinStack = function() {
  this.stack = [];
  this.min = [];
};

/**
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
  this.stack.push(x);

  var min = this.getMin();
  if (min!== undefined) {
    this.min.push(Math.min(x, min));
  } else {
    this.min.push(x);
  }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
  this.stack.pop();
  this.min.pop();
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
  if (this.stack.length > 0) {
    return this.stack[this.stack.length - 1];
  }
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
  if (this.min.length > 0) {
    return this.min[this.min.length - 1];
  }
};
 
MinStack.prototype.getMin = function() {
 if (this.min.length > 0) {
    return this.min[this.min.length - 1];
  }
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */