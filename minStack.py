#Time Complex = O(1)
#Sapce Comlex = O(1)

class MinStack:

    def __init__(self):
        min = 0
        self.stack  =[]     # create a stack 
        self.minStack = []  # create a minStack to keepa a record of the minimum values so that we can return the min value in O(1)
    
 #push
    def push(self, val: int) -> None:
        self.stack.append(val)    #we will append the values
        if self.minStack:         #We will check if the minStack is not empty then we will get the minimum of val & value at minstack
            val = min(val, self.minStack[-1])  # we will update val by the minumum value
        self.minStack.append(val) # we will now append the val i.e the minimum value in the min stack
        
# pop
    def pop(self) -> None:    
        if self.stack == None:    # if stack is empty then return the stack
            return self.stack
        else:
            self.stack.pop(-1)    # we will pop the the top item i.e the last item in array using -1 
            self.minStack.pop(-1) # we will pop the the top item i.e the last item in array using -1 to keep the min value in the stack 
        
#top value
    def top(self) -> int:
        return self.stack[-1]     # return the top item
    
#min value
    def getMin(self) -> int:
            
        return self.minStack[-1]  # return the top item from the min stack as the top item will be minimum


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()