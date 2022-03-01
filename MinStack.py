# Time Complexity : O(1) for all operations
# Space Complexity : O(n) for minstack list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Append the minimum element between the top element of minstack and current value to maintain the minimum value of stack at the top of minstack

class MinStack:

    def __init__(self,size) -> None:
        # Here I would not have size as a parameter as lists do not have a fixed size but as the problem statement asked
        # for a isFull function, that would mean that the stack has a fixed size. 
        self.stack=[None]*size
        self.minstack=[]
        self.top=-1

    def push(self,val:int):
        if self.isFull():
            print("Stack Overflow")
            return
        else:
            self.top+=1
            self.stack[self.top]=val
        if self.minstack:
            self.minstack.append((min(val,self.minstack[-1])))
        else:
            self.minstack.append(val)
            

    def pop(self):
        self.stack.pop()
        self.minstack.pop()
        self.top-=1
        return self.top
    
    def isEmpty(self):
        if self.stack:
            return False
        return True

    def isFull(self):
       if self.stack[-1]:
           return True
       else:
            return False

    def getTop(self):
        return self.stack[self.top]

    def getMin(self):
        return self.minstack[self.top]

# Your MinStack object will be instantiated and called as such:
size=6
obj = MinStack(size)
obj.push(5)
obj.push(6)
obj.push(4)
obj.push(8)
obj.push(9)
obj.push(10)
print("Is the stack full?: ",obj.isFull())
obj.pop()
print("Is the stack empty?",obj.isEmpty())
print("The top of the stack is: ",obj.getTop())
print("The minimum element of the stack is: ",obj.getMin())