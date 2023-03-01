var MinStack;

MinStack = function() {
  return Object.assign(Object.create(MinStack.prototype), {
    st: Array(16),
    min: null,
    topIndex: -1
  });
};

MinStack.prototype.push = function(x) {
  this.st[++this.topIndex] = x;
  if (this.min === null || this.min > x) {
    this.min = x;
  }
  return null;
};

MinStack.prototype.pop = function() {
  var i, ref, ti;
  if (this.st[this.topIndex] === this.min) {
    this.min = null;
    for (ti = i = ref = this.topIndex - 1; (ref <= 0 ? i <= 0 : i >= 0); ti = ref <= 0 ? ++i : --i) {
      if (this.min === null || this.min > this.st[ti]) {
        this.min = this.st[ti];
      }
    }
  }
  this.topIndex--;
  return null;
};

MinStack.prototype.top = function() {
  return this.st[this.topIndex];
};

MinStack.prototype.getMin = function() {
  return this.min;
};

// should implement a min heap but just for correctness, brute force!

//# sourceMappingURL=minstack_cs.js.map
