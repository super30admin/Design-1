#Time Complexity: O(1) for get, put and remove
#Space Complexity O(n) where n is number of values in Hashmap

#The solution is accepted in leetcode.



class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack=[]
        self.min= inf
  
    def push(self, x: int) -> None:
        """
        check if value to push is less than Min value
        if yes, push min value first
        then push the actual value
        This way previous min value is always below the curr element.
        """ 
        if x<=self.min:
            self.stack.append(self.min)
            self.min=x
        self.stack.append(x )  
        
    def pop(self) -> None:
        """
        pop the value 
        if value popped==min value, pop next value and set to min

        """ 
        val=self.stack.pop()
        if val== self.min :
            self.min = self.stack.pop()
        return val
        
    def top(self) -> int:
        """
        get last element from list which is top

        """ 
        return self.stack[-1]
        

    def getMin(self) -> int:
        """
        return min value

        """ 
        return self.min
