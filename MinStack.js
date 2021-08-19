// Time Complexity : O(1) for all 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes


var MinStack = function () {
    this.stack = [];
    this.minStack = [];
};

MinStack.prototype.push = function (val) {
    this.stack.push(val)
    if (this.minStack.length === 0 || val <= this.minStack[this.minStack.length - 1]) {
        this.minStack.push(val);
    }
};


MinStack.prototype.pop = function () {
    let poppedVal = this.stack.pop();
    if (poppedVal === this.minStack[this.minStack.length - 1]) {
        this.minStack.pop()
    }
};


MinStack.prototype.top = function () {
    return this.stack[this.stack.length - 1];
};


MinStack.prototype.getMin = function () {
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