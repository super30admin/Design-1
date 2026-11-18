/**
TC: O(1)
SC: O(n)
 */
var MinStack = function() {
    this.stack = new Array();
    this.minHelperStack = new Array();
    this.min = Infinity;

};

/** 
 * @param {number} value
 * @return {void}
 */
MinStack.prototype.push = function(value) {
    // simply push the value to stack
    this.stack.push(value);
    // check what is the min correspoinding to the value in stack;
    let newMin = Math.min(value, this.min);
    this.minHelperStack.push(newMin);
    this.min=newMin;
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    this.stack.pop();
    this.minHelperStack.pop();
    if(this.minHelperStack.length>0) {
        this.min = this.minHelperStack[this.minHelperStack.length-1];
    } 
    else {
        this.min = Infinity; // Reset back to Infinity when the stack is empty
    }
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    return this.stack[this.stack.length-1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.minHelperStack[this.stack.length-1];
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(value)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */