"""
Intuition: Stack is a first in, last out data structure.

Stack was implemented using a list. 
The values inside each stack index were stored in a dictionary.

A top pointer was utilized to retrive the latest element.
#####################################################################
Push Method: Every new element is inserted at the top
Time Complexity : O(1)
Space Complexity : O(1)
#####################################################################
Pop Method: Element present at the top will be popped
Time Complexity : O(1)
Space Complexity : O(1)
#####################################################################
Top Method: Value of the element present at the top will be accessed
Time Complexity : O(1)
Space Complexity : O(1)
#####################################################################
getMin Method: MinValue of the element present at the top will be accessed
Time Complexity : O(1)
Space Complexity : O(1)
#####################################################################
"""

class MinStack:

    def __init__(self):
        #Initializing array
        self.minStack = [0] * 10000     
        self.topIndex = -1

    def push(self, val: int) -> None:
        """
        Description: Adds element to the topIndex
        Nothing is returned, as leetcode is asking to return void.
        """
        newValue = {"value": val, "min": val}

        #Checking if the stack is not empty
        if self.topIndex != -1:
            newValue["min"] = min(newValue["min"], self.minStack[self.topIndex]["min"])    
        
        #Inserting element
        self.topIndex += 1
        self.minStack[self.topIndex] = newValue

    def pop(self) -> None:
        """
        Descriptiom: Removing the topmost element by simply decremeting the top index.
        Nothing is returned, as leetcode is asking to return void.
        """
        self.topIndex -= 1
        
    def top(self) -> int:
        """Returning the topmost element. NOT the minimunm element"""
        return self.minStack[self.topIndex]["value"]

    def getMin(self) -> int:
        """Returning the minimunm element"""
        return self.minStack[self.topIndex]["min"]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()