class MinStack {
  constructor() {
    this.stack = [];
    this.min = Number.MAX_SAFE_INTEGER;
  }

  push = (val) => {
    if (val < this.min) {
      this.stack.push(val);
      this.min = val;
    }
    this.stack.push(val);
  };

  pop = () => {
    if (this.stack.pop() === this.min) {
      const poppedElement = this.stack.pop();
      this.min = poppedElement;
    }
  };

  peek = () => {
    return this.stack[this.stack.length - 1];
  };

  getMin = () => {
    return this.min;
  };
}

const myMinStack = new MinStack();
myMinStack.push(4);
myMinStack.push(8);
myMinStack.push(10);
myMinStack.push(5);
myMinStack.push(99);
console.log(myMinStack.getMin());
