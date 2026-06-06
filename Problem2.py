# Time Complexity: O(1) for all operations: push, pop, top and getMin all use
# Space Complexity: O(n) both stacks grow by 1 on every push, giving us O(2n) which simplifies to O(n)

# We maintain two stacks in parallel - the main stack stores all values while the min stack stores a snapshot of the current minimum at every level

# On every push we compare the new value against the current min and update it, so we always know the minimum without ever having to search

# Logic: On every pop we remove from both stacks simultaneously and the new minimum is automatically restored by looking at the top of the min stack

class MinStack:

    def __init__(self):                #here we are initializing 2 explty stacks
      self.stack =[]                   #the first stack is the enter all the values
      self.minstack=[]                 #the 2nd one is to maintain values that are min corresponding to the elements
      self.min = float('inf')          #we need t set the value in the minstack to infinity so whatever number next enters will automatically be the new min value
      self.minstack.append(self.min)   #we need to append infinity into min stack

    def push(self, value: int) -> None:
       self.min = min(value,self.min)   #it just returns the min value everytime
       self.stack.append(value)         # here we are appending the values to the main stack
       self.minstack.append(self.min)   #here we are appending the min values only

    def pop(self) -> None:
        self.stack.pop()               #we pop the element using pop funtion
        self.minstack.pop()
        self.min = self.minstack[-1]   #we need to update the new min value and it will be the topmost value in the table
        

    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(value)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()