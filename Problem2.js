//## Problem 2: Design MinStack (https://leetcode.com/problems/min-stack/)

//time complexity is O(1) and space is O(n)
//accepted in leetcode
/* approch: create two stack insert elements an another to maintain min 
compared min value by using the Mathmin operation, and performed insert, delete using push and pop
*/

var MinStack = function() {

    this.stack=[];
    this.minStack=[];
    
};

/** 
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(val) {
    this.stack.push(val);
    if(!this.minStack.length){
        this.minStack.push(val)
    }
    else{
           this.minStack.push(Math.min(this.minStack[this.minStack.length-1], val))
    }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    if(!this.stack.length) return null;
    this.minStack.pop();
    return this.stack.pop();
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
    return this.minStack[this.minStack.length-1];
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */