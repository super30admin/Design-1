
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this : No
#Time complexity : O(1)
class MinStack:
    
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.mini = None #tracking minimum value 
        

    def push(self, val: int) -> None:

        if len(self.stack)==0:   #if stack empty update minval with first element
            self.stack.append(val)
            self.mini = val
        else:   
            if val<= self.mini:  #check if incoming val <= mini , then append current mini to stack and change new min with current incoming value
                self.stack.append(self.mini)
                self.mini = val
            self.stack.append(val) #append element to stack

        

    def pop(self) -> None:
        if len(self.stack)>0:
            if self.stack[-1] >self.mini:  #If top element is > mini value just pop
                temp = self.stack.pop()
                return temp
            else:
                q = self.stack.pop() #if is == to mini value pop that value and update current min with previous mini and pop the mini
                if len(self.stack)>0:
                    self.mini = self.stack[len(self.stack)-1]
                    temp = self.stack.pop()
                    return temp
                else:
                    self.mini = None
                    return q
        else:
            return 

    def top(self) -> int:
        if len(self.stack)>0:
            temp = self.stack[-1]
            return temp
        else:
            return 
        

    def getMin(self) -> int:
        return self.mini
        


