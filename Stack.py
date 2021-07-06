"""
Min stack implementation without using another Stack
Time Complexity :
    push : O(1)

    pop : O(1)

    get_Min : O(1)

    Top : O(1)

Space Complexity :
    I have used list data strcutre to implement the stack which will hold N input numbers 
    it is O(N)

Did this code successfully run on Leetcode : : YES


"""

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self._stack = list()
        self.size = 0


    def isEmpty(self):
        return len(self._stack) == 0

    """
        if Stack is Empty we will push (element,current_min) into list
        here stack is empty so elements to be pushed is the current_min
        if stack is not empty then we need to update the minimun if elements to be added in stack is
        less than current element

    """
    def push(self, x: int) -> None:
        if self.isEmpty():
            # push (element,min_element) into list 
            self._stack.append((x,x))
        else:
            # get current Minimum
            current_min = self.getMin()
            # if element we want to push to the stack is less than current element 
            # then new minmum will be change
            if x < current_min:
                self._stack.append((x,x))
            else:
                self._stack.append((x,current_min))
        self.size += 1

    def pop(self) -> None:
        # current_min = self.top()
        if self.isEmpty():
            raise Exception("Empty Stack")
        else:
            current_min = self.getMin()
            self._stack.pop()

    def top(self) -> int:
        if self.isEmpty():
            raise Exception("Empty stack")
        else:
            return self._stack[-1][0]

    def getMin(self) -> int:
        if self.isEmpty():
            raise Exception("Stack is Empty")
        else:
            self.print_stack()
            return self._stack[-1][1]

    def print_stack(self):
        print(self._stack)

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(2147483646)
obj.push(2147483646)
obj.push(2147483647)
obj.top()
obj.pop()
obj.getMin()
obj.pop()
obj.getMin()
obj.pop()
obj.push(2147483647)
obj.top()
obj.getMin()
obj.push(-2147483648)
obj.top()
obj.getMin()
obj.pop()
obj.getMin()

