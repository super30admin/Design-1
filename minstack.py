#Time Complexity - push(): O(1)
# pop():O(1) 
# top() : O(1)
# getMin() : 
#Space Complexity - Overall it's O(n) where n are total inputs but all function implementations are O(1)

# Running on leetcode : Yes

# Class for minstack implementation
class MinStack:
    #Initialization of minstack with a list
    def __init__(self):
        self.q = []
        self.size = 0
    #Function to add an input to the minstack    
    def push(self, x: int) -> None:
        
        self.q.append((x, min(self.getMin(),x)))
        self.size+=1 
    #Function to pop an input from the minstack       
    def pop(self) -> None:
        #print(self.q)
        if self.size!=0:
            self.q.pop()
            self.size -=1 
        return None
    #Function to get the top/last element into the stack   
    def top(self) -> int:
        if  self.size!=0:
            return self.q[-1][0]
    #function to get minimum element fromn the minstack
    def getMin(self) -> int:
        if  self.size!=0:
            return self.q[-1][1]
        return sys.maxsize
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()