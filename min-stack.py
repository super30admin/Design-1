class MinStack:
#create two stacks and maintain 1:1 relation between them
    def __init__(self):
        self.stack=[]
        self.minStack=[]
        self.min=int(sys.maxsize) #setting min as infinity
        self.minStack.append(self.min) #append current min (infinity) to minstack

    def push(self, val: int) -> None:
        self.stack.append(val) #append in main stack regardless of anything
        if val<=self.min: # compare that value with curr min, if smaller, new min is that val now
            self.min=val 
        self.minStack.append(self.min) #update the minstack with new min

    def pop(self) -> None:
        self.stack.pop() 
        self.minStack.pop()
        self.min=self.minStack[-1] #after popping, update min to current top of min stack
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.minStack[-1]

#Time Complexity 0(1)
#Space Complexity 0(N)

#Using 1 stack
# class MinStack:
#     def __init__(self):
#         self.stack=[]
#         self.min=int(sys.maxsize)
    
#     #while pushing, if new val impacting curr min, then push twice. First push old min, then push new val. Other wise if not impacting, just push new val once.
#     def push(self,val):
#         if val<=self.min:
#             self.stack.append(self.min) #append old min
#             self.min=val #update min to curr min
#         self.stack.append(val) #in any case, append the new val to stack
    
#     def pop(self):
#         popped= self.stack.pop()
#         if popped==self.min:
#             self.min=self.stack.pop()
    
#     def top(self):
#         return self.stack[-1]
    
#     def getMin(self):
#         return self.min

#Time Complexity 0(1)
#Space Complexity 0(1)