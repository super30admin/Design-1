
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this : No
#Time complexity : O(1)
class MinStack:
    
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        
        

    def push(self, val: int) -> None:
        if len(self.stack)==0:   
            self.stack.append((val,val))
        else:   #maintain updated min element along with every element being added to list
            self.stack.append((val,min(val,self.stack[-1][1])))

        

    def pop(self) -> None:
        if len(self.stack)>0:
            temp = self.stack.pop()
            return temp[0]
        else:
            return 

    def top(self) -> int:
        if len(self.stack)>0:
            temp = self.stack[-1][0]
            return temp
        else:
            return 
        

    def getMin(self) -> int:
        return self.stack[-1][1]
        


