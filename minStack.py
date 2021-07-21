class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.st=[]
        

    def push(self, val): #Time complexity O(1)
        #pushing values as tuple and maintaining minimum and current in each tuple.
        if not self.st:
            self.st.append((val,val))
        else:
            minimum=self.st[-1][0]
            if minimum<val:
                self.st.append((minimum,val))
            else:
                self.st.append((val,val))

    def pop(self): #Time complexity O(1)
        self.st.pop()

    def top(self): #Time complexity O(1)
        #top of the stack element will be element at first index of tuple at top of stack
        return self.st[-1][1]

    def getMin(self): #Time complexity O(1)
        #Minimum of the elements will be element at zero index of tuple at top of stack
        return self.st[-1][0]
        

#overall time complexity : O(1)
#overall spacecomplexity : O(n) where n is the total number of elements pushed on stack.
# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()