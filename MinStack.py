# Time Complexity: O(1)
#  Space Complexity : O(n)

class MinStack(object):
    stack_array = []
    min_stack = []
    max_size = 100000
    current_min = 0

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack_array = []

    def compare(self, current_val, top_min_val):
        if current_val <= top_min_val:
            return True
        else:
            return False

    def push(self, val):
        if len(self.stack_array) < self.max_size:
            self.stack_array.append(val)
            # push element in stack array and if length of stack is 1 then add it to min stack
            if len(self.stack_array) == 1:
                self.min_stack.append(val)
                # print(val)
            # else if stack has more than one element then we will compare top of min stack
            # and current stack and then only append in min stack array
            elif len(self.stack_array) > 1:
                # print(self.min_stack[len(self.min_stack) -1])
                if self.compare(val, self.min_stack[len(self.min_stack) - 1]):
                    self.min_stack.append(val)
                    # print(val)

        else:
            print("Stack is Full")

        """
        :type val: int
        :rtype: None
        """

    def pop(self):
        if len(self.stack_array) == 0:
            print("stack is empty")
        #  if top element in stack array is also present in min stack array then pop from that location too
        else:
            if self.stack_array[len(self.stack_array) - 1] == self.min_stack[len(self.min_stack) - 1]:
                self.min_stack.pop()
            self.stack_array.pop()
        """
        :rtype: None
        """

    def top(self):
        if len(self.stack_array) == 0:
            print(" Stack is Empty")
        else:
            return self.stack_array[len(self.stack_array) - 1]
        """
        :rtype: int
        """

    def getMin(self):
        if len(self.min_stack) != 0:
            return self.min_stack[len(self.min_stack) - 1]
        """
        :rtype: int
        """

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(2)
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()