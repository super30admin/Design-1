# TC = O(1)
# SC = O(n)
class MinStack(object):

    def __init__(self):
        self.st=[]
        self.min_st = []
        self.min = float('inf')

    def push(self, value):
        if self.min >= value:
            self.min_st.append(self.min)
            self.min = value
        self.st.append(value)
        

    def pop(self):
        if (self.st.pop() == self.min):
            self.min = self.min_st.pop()
        
    def top(self):
        return self.st[-1]    

    def getMin(self): 
        return self.min
      
