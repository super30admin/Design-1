#Time Complexity: O(1) for push, pop, top and getMin
#Space Complexity: O(n), since extra  stack used to keep track of current min
#Working on LeetCode: Yes


class MinStack:
    def __init__(self):
        self.stack = []
        self.curr_min = [None]
    
    def push(self, val):
        if self.curr_min[-1] is None or self.curr_min[-1]>=val:
            self.curr_min.append(val)
        else:
            self.curr_min.append(self.curr_min[-1])
        self.stack.append(val)
    
    def pop(self):
        self.stack.pop()
        self.curr_min.pop()
    
    def top(self):
        top = self.stack[-1]
        return top
    
    def getMin(self):
        return self.curr_min[-1]

if __name__ == "__main__":
    stack_obj = MinStack()
    stack_obj.push(-2)
    stack_obj.push(0)
    stack_obj.push(-3)
    stack_obj.pop()
    print(stack_obj.top())
    print(stack_obj.getMin())
