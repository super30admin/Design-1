//Constant Time for push , pop,top
//O(n) space
var MinStack = function() {
    this.stack = [];
    this.min = Infinity;

};

MinStack.prototype.push = function(number) {
    if(number <= this.min){
        this.stack.push(this.min);
        this.min = number;
    }
    this.stack.push(number);
};


MinStack.prototype.pop = function() {
    if(this.min == this.stack.pop()){
        this.min = this.stack.pop();
    }
};

MinStack.prototype.top = function() {
     return this.stack[this.stack.length-1];
};

MinStack.prototype.getMin = function() {
    return this.min;
};
