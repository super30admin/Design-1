
var MinStack = function() {
    this.stack = [];
    this.min = Infinity;

};

/** 
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(number) {
    if(number <= this.min){
        this.stack.push(this.min);
        this.min = number;
    }
    this.stack.push(number);
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    if(this.min == this.stack.pop()){
        this.min = this.stack.pop();
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
    return this.min;
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */