// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class MinStack {
    stack = [];
    minStack = [];
    push(num) {
        this.stack.push(num);
        if(this.getMin() >= num || this.minStack.length === 0) this.minStack.push(num);
    }
    getMin() {
        return this.minStack[this.minStack.length - 1];
    }
    top() {
        return this.stack[this.stack.length - 1];
    }
    pop() {
        let popped = this.stack.pop();
        if(popped === this.getMin()) this.minStack.pop();
    }
}