## Problem 2:
# Design MinStack (https://leetcode.com/problems/min-stack/)

# Time Complexity : In design problems we consider time complexity for each function. It is perfect O(1) for push(), pop(), top() and getMin() methods
# Space Complexity : O(N) = O(length(stack)) -- It is length of stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Implemented Stack using dynamic array
# Here I keep a tuple of current element and min of the entire stack till now
# If we get a smaller element than min, then I update the min value

# Method-1
# Using Dynamic Array
class MinStack(object):

    def __init__(self):
        # stack containing pair of (currentElement, currMin)
        self.stack = []
        

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        if(not self.stack):
            self.stack.append((val,val))
        else:
            _, currMin = self.stack[-1]
            if(val < currMin):
                currMin = val
            self.stack.append((val, currMin))
        

    def pop(self):
        """
        :rtype: None
        """
        if(self.stack):
            self.stack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        if(self.stack):
            return (self.stack[-1])[0]
        

    def getMin(self):
        """
        :rtype: int
        """
        if(self.stack):
            return (self.stack[-1])[1]

print("Method-1: Using Dynamic Array")
minStack = MinStack()
minStack.push(-2)
minStack.push(0)
minStack.push(-3)
print(minStack.getMin())
minStack.pop()
print(minStack.top())
print(minStack.getMin())


# Method-2
# Using LinkedList

# Time Complexity : In design problems we consider time complexity for each function. It is perfect O(1) for push(), pop(), top() and getMin() methods
# Space Complexity : O(N) = O(length(stack)) -- It is length of stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Implemented Stack using Singly Linked List
# Here we maintain a Linked List, where we use head to push and pop elements. Each node of the LinkedList conatins its data and 
# the minimum found till now
# If we get a smaller element than min, then I update the min value

class Node(object):
    def __init__(self, val = 0):
        self.data = val
        self.currMin = None
        self.next = None

class MinStackLL(object):

    def __init__(self):
        self.head = None
        

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        newNode = Node(val)
        if(not self.head):
            self.head = newNode
            newNode.currMin = val
        else:
            newNode.next = self.head
            if(newNode.data < self.head.currMin):
                newNode.currMin = val
            else:
                newNode.currMin = self.head.currMin
            self.head = newNode
            

        

    def pop(self):
        """
        :rtype: None
        """
        if(self.head):
            curr = self.head
            self.head = self.head.next
            curr.next = None
        

    def top(self):
        """
        :rtype: int
        """
        if(self.head):
            return self.head.data
        

    def getMin(self):
        """
        :rtype: int
        """
        if(self.head):
            return self.head.currMin
        
print("Method-2: Using LinkedList")
minStack = MinStackLL()
minStack.push(-2)
minStack.push(0)
minStack.push(-3)
print(minStack.getMin())
minStack.pop()
print(minStack.top())
print(minStack.getMin())