#Time complexity is O(1) for push, pop, top and getmin
#Space complexity is O(1) as self.min is a single variable storing the Minimum value

#Code ran successfuly in leet code.



class MinStack:

    def __init__(self):
        """
        initialized a list as Stack and Minimum variable to infinity 
        """
        self.stack=[]
        self.min= inf
  
    def push(self, x: int) -> None:
        """
        Pushed the value to the stack and Update the Min value after checking  with current value pushed.
        """

        self.stack.append(x)
        if x<self.min:
            self.min=x

            
        
    def pop(self) -> None:
    """
    pop the value and check if popped value is the Min value. If true, get new Min value.
        
    """
        val=self.stack.pop()
        if val== self.min :
            if len(self.stack) > 0:
                self.min = min(self.stack)
            else:
                self.min =inf
        return val
        
    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.min
