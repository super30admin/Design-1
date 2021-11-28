"""
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.

Approach 1 (Declaring Two stacks):
1. Declare the min variable and initailize it to infinity
2. Declare stack to push the values and min_stack to maintain minimum value
3. Everytime we push the value, check if the value to be push is less than min.
4. If it is less than min then push the min value to the min_stack and update the min valriable
5. If not then push the value in min variable to min_stack
6. If the mnimum value id popped then pop value from primary stack and update the minumum variable as the value at the top of stack

Time Complexity: O(1)
Space Complexity: O(n)

Approach 2 (Declaring Only one stack):
1. Declare the min variable and initialize it to infinity
2. Declare only one stack
3. Everytime while pushing the value to stack check if value to be pushed is smaller than equal to value in min variable
4. If yes, push the old value in min to stack then push the input value and update the min valriable
5. If no, then only push the input value
6. While popping up the value check if value to be popped up is equal to value in minimum 
7. If yes, then popup twice and while doing the second popup save the value in minimun as it will be the smallest value 

Time Complexity: O(1)
Space Complexity: O(n)
"""
from collections import deque
class MinStack:
    
    def __init__(self):
        self.minimum = float("inf")
        self.stack = deque()
        self.min_stack = deque()
        self.min_stack.append(self.minimum)

    def push(self, val):
        self.minimum = min(self.minimum, val)
        self.stack.append(val)
        self.min_stack.append(self.minimum)
    
    def pop(self):
        self.stack.pop()
        self.min_stack.pop()
        self.minimum = self.min_stack[-1]
    
    def top(self):
         return self.stack[-1]
        
    def getMin(self):
        return self.minimum

#Approach 2
class MinStack_1:
    from collections import deque
    def __init__(self):
        self.minimum = float("inf")
        self.stack = deque()
        
    def push(self, val):
        if self.minimum >= val:
            self.stack.append(self.minimum)
            self.stack.append(val)
            self.minimum = val
        else:
            self.stack.append(val)
            
            
            
    def pop(self):
        temp =self.stack.pop()
        if temp == self.minimum:
            self.minimum = self.stack.pop()

    def top(self):
        return self.stack[-1]

    def getMin(self):
        return self.minimum
    
stack = MinStack_1()
stack.push(5)
stack.push(9)
stack.push(4)
stack.pop()
minimum = stack.getMin()
print(minimum)