
/**
 * Intution:
 * Here  i am using in and out stack concept.
 * Outstack contains the data that are in the reverse order of in stack, which will help us pop the firdt element that gets in
 * Not allocating space to the array in the constructor, as the main way to test whether it is empty or not is by checking it's length. If we allocate the space, the length always holds some value and even though there is no data.
 * 
 */

class MyQueue {
    constructor() {
        
        this.inStack = [];
        this.outStack = [];
    }
};

/** 
 * @param {number} x
 * @return {void}
 */
MyQueue.prototype.push = function (x) {
    this.inStack.push(x);
};

/**
 * @return {number}
 */
MyQueue.prototype.pop = function () {
    this.peek();
    return this.outStack.pop();
};

/**
 * @return {number}
 */
MyQueue.prototype.peek = function () {
     if (!this.outStack.length) {
        while (this.inStack.length > 0) {
            this.outStack.push(this.inStack.pop());
        }
    }
    if(!this.outStack.length) return;
    return this.outStack[this.outStack.length - 1];
};

/**
 * @return {boolean}
 */
MyQueue.prototype.empty = function () {
    return this.outStack.length === 0 && this.inStack.length === 0;
};

/** 
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */