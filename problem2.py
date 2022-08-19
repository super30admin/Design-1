#minstack
#leetcode solutio accepted
#Spacw complexity:O(n)
#time complexity:O(1)
class MinStack:

    def __init__(self):
        self.stack = [] #mainstack
        self.minstack = [] #second stack

    def push(self, val: int) -> None:
        self.stack.append(val) #append
        val = min(val,self.minstack[-1] if self.minstack else val)#update val
        self.minstack.append(val)#append updated value
        
        

    def pop(self) -> None:
        self.stack.pop() #pop from both the stack to maintain
        self.minstack.pop()
        

    def top(self) -> int:
        return self.stack[-1] #return main stack

    def getMin(self) -> int:
        return self.minstack[-1] #return top value of min stack
        