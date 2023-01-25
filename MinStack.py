# Passed all Test cases in leetcode

class MinStack:

    def __init__(self):
        self.stack = []
        self.curMin = None


    # time complexity - O(1)
    # space complexity - O(1)
    # Here for every element given to be pushed in stack, we push a pair of tuple having element and the cur min. If given element is lesser than cur min then we update cur min and push the pair into stack
    def push(self, val: int) -> None:
        if not self.stack:
            self.curMin = val
            self.stack.append((val, self.curMin))
        else:
            if val < self.curMin:
                self.curMin = val
                self.stack.append((val, self.curMin))
            else:
                self.stack.append((val, self.curMin))


    # time complexity - O(1)
    # space complexity - O(1)
    # Here for every element poped from stack is present as pair, hence we return 
    # the first entry in the pair. Also we update the cur min after each pop with
    # cur min from the stack's top element-curMin pair. If no elements in stack 
    # then we update cur min to None
    def pop(self) -> None:
        val = self.stack.pop()[0]
        self.curMin = self.stack[-1][1] if self.stack else None
        return val


    # time complexity - O(1)
    # space complexity - O(1)
    # Here we return the stacks top element 
    def top(self) -> int:
        return self.stack[-1][0]


    # time complexity - O(1)
    # space complexity - O(1)
    # Here cur min holds the min value of the stack.
    def getMin(self) -> int:
        return self.curMin


s = MinStack()
s.push(8)
s.push(2)
s.push(-2)
print(s.stack)
s.pop()
print(s.getMin())
s.pop()
s.top()
print(s.getMin())