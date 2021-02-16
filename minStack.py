"""
MinStack:

// Time Complexity :
    push -> O(1) because it will directly pushes the element
    pop -> O(1) because it will directly pops the element
    getMin -> O(1) because it will only return min value

// Space Complexity :

// Did this code successfully run on Leetcode :
    The Soluition where I use two List was successfully submitted.

    But the one with single List is giving wrong Output

// Any problem you faced while coding this :
    Having trouble with minVal - after popping 0 it should show minValue
    as 2 but it's still showing 0
    
    in the pop() function

// Your code here along with comments explaining your approach

"""
import sys
class MinStack:

    def __init__(self):
        """
        initializing data structure here.

        """
        self.stack_item = []
        self.minVal = sys.maxsize


    def push(self, x: int) -> None:
        '''
        Pushing elements onto the stack. Also push min value onto the Stack
        :param x: int
        :return: None
        '''
        # print("MinValue Before: ", int(self.minVal))
        if x <= self.minVal:
            self.stack_item.append(min)
            self.minVal = x
        self.stack_item.append(x)
        # print("MinValue After: ", int(self.minVal))


    def pop(self) -> None:
        '''
        Pop the Stack top element.
        Update min value
        :return: None
        '''
        if self.stack_item.pop() == self.minVal:
            min = self.stack_item.pop()


    def top(self) -> int:
        '''
        Returns the top element or the last inserted element in Stack
        :return: int
        '''
        if self.stack_item:
            return self.stack_item[-1]


    def getMin(self) -> int:
        '''
        Returns the current min value of the Stack
        :return: int (minVal)
        '''
        return self.minVal


    def printStack(self):
        '''
        Printing Stack for visual
        :return: None
        '''
        print("MinValue: ",int(self.minVal))
        return self.stack_item




# Your MinStack object will be instantiated and called as such:
obj = MinStack()
'''obj.push(1)
obj.push(2)
obj.push(3)
obj.push(0)
obj.push(4)
obj.push(1)'''
obj.push(3)
obj.push(6)
obj.push(2)
obj.push(0)
obj.push(1)
print("stack: \n",obj.printStack(), end="| \n")
obj.pop()
obj.pop()
param_3 = obj.top()
print("Top: ",param_3)
param_4 = obj.getMin()
print("Min Value: ",param_4)
print("stack: \n",obj.printStack(), end="| \n")


"""
TWO LISTs SOLUTION: 

class MinStack:

    def __init__(self):
        
        # initialize your data structure here.
        
        self.stack_item = []
        self.min_stack = []

    def push(self, x: int) -> None:
        if self.min_stack == [] or x <= self.min_stack[-1]:
            self.min_stack.append(x)
        self.stack_item.append(x)

    def pop(self) -> None:
        if self.stack_item[-1] == self.getMin():
            self.min_stack.pop()
        self.stack_item.pop()

    def top(self) -> int:
        if self.stack_item:
            return self.stack_item[-1]

    def getMin(self) -> int:
        if self.min_stack:
            return self.min_stack[-1]
"""
