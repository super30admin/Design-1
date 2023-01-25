# Explain your approach in **three sentences only** at top of your code
'''This approach is the same as implementing a stack with lists, except
that there is an extra list that keeps track of the minimum equivalent to 
the value of the corresponding stack. 
'''
# Time Complexity : O(1)
# Space Complexity : O(N), N being the length of stack. 
# Did this code successfully run on Leetcode : Yes. 
# Any problem you faced while coding this : I had done this leetcode in 
# the past, when I did have a lot of trouble thinking about how to keep
# track of the minimum. This time around, I knew of the strategy. 


#  Your code here along with comments explaining your approach

class MinStack:

    def __init__(self):
        self.stack = []
        self.min_value =[]

    def push(self, val: int) -> None:
        self.stack.append(val)
        #for each value of stack, keep track of the minimum at the point
        #in the stack. Add current minimum for each. 
        if len(self.min_value)==0:
            self.min_value.append(val)
        else:
            last_min = self.min_value[len(self.min_value)-1]
            if last_min>val:
                self.min_value.append(val)
            else:
                self.min_value.append(last_min)

    def pop(self) -> None:
        #pop both the stack and the array for keeping track of minimum. 
        self.stack.pop(len(self.stack)-1)
        self.min_value.pop(len(self.min_value)-1)

    def top(self) -> int:
        return self.stack[len(self.stack)-1]

    def getMin(self) -> int:
        return self.min_value.pop(len(self.min_value)-1)