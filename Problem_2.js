// Time Complexity : 
// pop: O(1)
// push: O(1)
// top: O(1)
// getMin: O(1)

// Space Complexity : 
// Worst case: O(2N) where N is the number of elements added in the stack
// Best case: O(N) where N is the number of elements added in the stack

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var MinStack = function () {
    this.s = [];
    this.min = Number.MAX_VALUE;
};

/** 
* @param {number} val
* @return {void}
*/
MinStack.prototype.push = function (val) {
    if (val <= this.min) {
        this.s.push(this.min);
        this.min = val;
    }
    this.s.push(val);
};

/**
* @return {void}
*/
MinStack.prototype.pop = function () {
    if (this.min === this.s.pop()) {
        this.min = this.s.pop();
    }
};

/**
* @return {number}
*/
MinStack.prototype.top = function () {
    return this.s[this.s.length - 1];
};

/**
* @return {number}
*/
MinStack.prototype.getMin = function () {
    return this.min;
};

var obj = new MinStack();
obj.push(2)
obj.push(6)
console.log("top: ", obj.top());
obj.push(1)
obj.push(7)
console.log("top: ", obj.top());
obj.pop()
obj.pop()
console.log("top: ", obj.top());
console.log("getMin: ", obj.getMin());

console.log(obj);

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */