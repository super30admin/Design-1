// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
var MinStack = function () {
  this.stack = [];
  this.minStack = [];
  this.minValue = null;
};

/**
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function (val) {
  this.stack.push(val);
  if (this.minValue === null) {
    this.minValue = val;
    return this.minStack.push(val);
  }
  if (val <= this.minValue || this.minValue === undefined) {
    this.minValue = val;
    return this.minStack.push(val);
  }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function () {
  const popped = this.stack.pop();
  if (popped <= this.minValue) {
    this.minStack.pop();
    this.minValue = this.minStack[this.minStack.length - 1];
  }
  return popped;
};

/**
 * @return {number}
 */
MinStack.prototype.top = function () {
  return this.stack[this.stack.length - 1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function () {
  return this.minStack[this.minStack.length - 1];
};
