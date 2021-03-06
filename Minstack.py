#Implementation of Min Stack using single array
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        #Implementation of min stack using single stack(array list)
        #Initializing the stack
        self.s = []
        self.minval = float('inf')
#Push function to append values to stack 
    def push(self, x: int) -> None:
        self.s.append(x)
        #Change the minimum value if new element is less than existing element
        if(x < self.minval):
            self.minval = x

    def pop(self) -> None:
        #remove last element( Stack--> Last In Fisrt Out (LIFO))
        pop_element=self.s.pop()
        #Change the minimum value if poped out element is min to the min value in stack else change to infinity
        if self.minval == pop_element:
            self.minval = min(self.s) if self.s else float('inf')
            print(self.s)
        
# Return the top or peek element. As it is array last value is array[-1]
    def top(self) -> int:
        return self.s[-1]
#Return minimum value which is "minval"
    def getMin(self) -> int:
        return self.minval