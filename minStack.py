""" 
Stack used to store all values; minimumStack used to check the minimum at each level.
On each push, push val to stack and check and store min(val, existingMin) in minimumStack to maintain sync. Top returns topmost element in stack.
On pop, remove from both stacks to keep them in sync. getMin returns the minimumElement viz the topmost element in minimumStack.
"""
"""
Time Complexity:
push, pop, top, getMin - All O(1) (constant time)
Space Complexity:
O(n) where n is the number of elements pushed. Both stacks grow equally.
"""


class minStack:

    def __init__(self) -> None:
        self.stack = []
        self.minimumStack =[]
    
    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.minimumStack:
            val = min(val,self.getMin())
        self.minimumStack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.minimumStack.pop()
    
    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minimumStack[-1]


if __name__=="__main__":

    mini = minStack()

    mini.push(6)
    mini.push(7)
    mini.push(5)
    print(mini.top())
    mini.pop()
    print(mini.top())