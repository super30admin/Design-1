'''
Problem 1:
Design Hashset (https://leetcode.com/problems/design-hashset/)

// Time Complexity :O(n)
// Space Complexity :O(n) since store all values
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No

 Your code here along with comments explaining your approach
Approach :
    The brute force HashSet simply uses a single list to store all elements. 
    When adding a value, it first checks if the value already exists to avoid duplicates. 
    To check if a value exists, it performs a linear search through the entire list. 
    When removing, it also searches the list to find and remove the target value if present.
'''
class MyHashSet:
    def __init__(self):
        # list to store all elements
        self.elements = []
        
    def add(self, key: int) -> None:
        # Only add if the key doesn't exist
        if not self.contains(key):
            self.elements.append(key)
    
    def contains(self, key: int) -> bool:
        # Check if key exists in our list
        return key in self.elements
    
    def remove(self, key: int) -> None:
        # Remove key if it exists
        if self.contains(key):
            self.elements.remove(key)

'''

Problem 2: 
Design MinStack (https://leetcode.com/problems/min-stack/)

// Time Complexity :O(1)
// Space Complexity :O(n) since uses two stacks
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
Approach :
    The brute force HashSet simply uses a single list to store all elements. 
    When adding a value, it first checks if the value already exists to avoid duplicates. 
    To check if a value exists, it performs a linear search through the entire list. 
    When removing, it also searches the list to find and remove the target value if present.
'''
class MinStack:

    def __init__(self):
        self.stack=[] # Regular stack to store all values
        self.minstack=[] # Another parallel stack that keeps track of minimum values
        

    def push(self, val: int) -> None:
        # Add value to both stacks
        self.stack.append(val)
        if not self.minstack:
            self.minstack.append(val)
        elif self.minstack[-1]<val:
            self.minstack.append(self.minstack[-1])
        else :
            self.minstack.append(val)    

    def pop(self) -> None:
        # Remove top element from both stacks
        self.stack.pop()
        self.minstack.pop()
        

    def top(self) -> int:
        # Return top element from regular stack
        return self.stack[-1]
        

    def getMin(self) -> int:
        # Return top element from minstack
        return self.minstack[-1]
