// Time Complexity : push- O(1) constant time to add element to stack
// 		pop- O(1) constant time to pop element from stack
//		top- O(1) constant time to retrieve top element of stack
//		getMin- O(1) constant time to retrieve top element of min stack

// Space Complexity : O(N) as we are using an extra space (stack data structure) to store elements

// Did this code successfully run on Leetcode : No. 
// Any problem you faced while coding this : Getting IndexError "List index out of range" on line return self.min_stack[-1].


class MinStack:

    def __init__(self):
        self.min_stack = []
        self.new_stack = []

    def push(self, val: int) -> None:
        if not self.new_stack:
            self.new_stack.append(val)
            self.min_stack.append(val)
        else:
            if val < self.min_stack[-1]:
                self.min_stack.append(val)
                self.new_stack.append(val)
            else:
                self.new_stack.append(val)        

    def pop(self) -> None:
        self.new_stack.pop()
        self.min_stack.pop()        

    def top(self) -> int:
        return self.new_stack[-1]

    def getMin(self) -> int:
        return self.min_stack[-1]