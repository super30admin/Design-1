#Time complexity - O(1) for all operations
#space complexity - O(n) #worst case
class MinStack:

    def __init__(self):
        self.m_s=[] #main stack to store all the elements
        self.a_s=[] #auxilary stack to store value of min element in the stack
        
        

    def push(self, val: int) -> None:
        #append element into main stack
        self.m_s.append(val)
        #check if aux stack is empty or top of aux stack is equal to or greater than the new element than push it to aux stack 
        if self.a_s==[] or self.a_s[-1]>=val: 
            self.a_s.append(val)
        
        

    def pop(self) -> None:
        var=self.m_s.pop()
        #if popped element from main stack is at min val element then pop it too
        if var==self.a_s[-1]:
            self.a_s.pop()
        

    def top(self) -> int:
        #gets the top element of the main stack.
        return self.m_s[-1]
        

    def getMin(self) -> int:
        #retrieves the minimum element in the  aux stack.
        return self.a_s[-1]
    
    def isEmpty(self):
        return self.m_s==[]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
