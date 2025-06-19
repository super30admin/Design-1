# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :faced while pushing the elements in the stack.

'''We need to use 2 stacks for achieving the push, pop, getMin. 
Checked the condition if the value in the stack is less than minimum we are pushing it to the minstack. 
whenever the push happens we are inserting it in both stack and the minstack, 
if the val is greater than the min_stack we insert the same element again in min stack and insert the value into stack. '''


#Your code here along with comments explaining your approach
class MinStack(object):

    def __init__(self):
        self.stack = []   #creating the empty stack
        self.min_stack = [float('inf')]  #creating the min stack for storing the minimum values
        

    def push(self, val):
        '''
        :type val: int
        :rtype: None
        '''
        self.stack.append(val)  #pushing the value to the stack
        if not self.min_stack:  #checking for the condition if the min_stack is empty then adding the value to the min_stack
            self.min_stack.append(val)
        else:
            # Push the smaller value between new val and current min
            current_min = self.min_stack[-1]
            self.min_stack.append(min(val, current_min))
        
    def pop(self):
        """
        :rtype: None
        """
        #deleting the element from the stack and min_stack 
        self.stack.pop()
        self.min_stack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        #checking if the stack is not empty 
        if self.stack:
            return self.stack[-1]
        return None
        

    def getMin(self):
        """
        :rtype: int
        """
        if self.min_stack:
            return self.min_stack[-1]
        return None
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
