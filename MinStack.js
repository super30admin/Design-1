//TC: O(1)
//SC: O(N) - where N is the number of elements pushed to the stack

/*
* Approach
*   - We have a stack that would take a pair of values {val: value, min: minVal}.
*   - Push:
*       - To push we check if the length is empty we push the object to the array,
*       - if the value is not empty then we compare the current value with
*           the min of the previous value to determine the min.
*   - Pop:
*       - we check if the length is not empty we pop the element which removes the last added element
*   - Top:
*       - we check if the length is not empty we return the last value from the array else we return null.
*   - getMin-
*       - we check if the length is not empty we return the last value from the array else we return null.
* */

var MinStack = function() {
  this.stack = [];
};

/**
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(val) {

  if (this.stack.length === 0) {
    this.stack.push({val, min: val});
  } else {
    const min = Math.min(this.stack[this.stack.length - 1].min, val );
    this.stack.push({val, min});
  }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
  if (this.stack.length > 0) {
    this.stack.pop();
  }
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
  if (this.stack.length > 0) {
    return this.stack[this.stack.length - 1].val;
  }
  return null;
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
  if (this.stack.length > 0) {
    return this.stack[this.stack.length - 1].min;
  }
  return null;
};

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
