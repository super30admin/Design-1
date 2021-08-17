#  Time Complexity : Constant time for all the operations, but not sure for the pop operation,
# because it will take O(n) if the minimum element is the same while is deleted and for finding minimum element
# it will be iterated through out the stack
#  Space Complexity :
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No
#  Your code here along with comments explaining your approach

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class MinStack:
    '''
    Using Linked list for implementing stack
    1. Push the last element on the head.
    2. Removing the head element on pop operation.
    '''

    def __init__(self):
        """initialize your data structure here."""
        self.head = None  
        self.min_element = None

    def push(self, val):
        if self.head == None:
            self.head = Node(val)
            self.min_element = self.head.data
        else:
            node = Node(val)
            node.next = self.head
            self.head = node
            self.min_element = minimum_element(self.min_element, val)
    
    
    def pop(self) :        
        if self.head == None:
            return None
        min_num = self.head.data
        self.head = self.head.next  
        
        if self.min_element == min_num:
            # iterate through all elements in list and get the minimum element from the stack
            iter_node = self.head
            self.min_element = iter_node.data if iter_node else None
            while(iter_node):
                
                self.min_element = minimum_element(self.min_element, iter_node.data) 
                iter_node = iter_node.next
                
            
    def top(self):
        if self.head:
            return self.head.data
        

    def getMin(self):
        return self.min_element
    
    
def minimum_element(num1, num2):
    
    if num1 < num2:
        return num1
    if num2 < num1:
        return num2
    return num1

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(47)
obj.pop()
param_3 = obj.top()
param_4 = obj.getMin()