#Time Complexity: O(n)
#Space complexity: O(n)
#Approach: The approach was that I created a Extra Stack to store the minimum value. the minimum value is always store in the mins stack and just return that ones the getMins() function is called

class MinStack:
    def __init__(self):
        self.s = []
        self.mins = []


    def push(self, val: int) -> None:
        self.s.append(val)
        if self.mins:
             val = min(val, self.mins[-1])
        else:
            val = val
            
        # val = min(val, self.mins[-1] if self.mins else val)
        self.mins.append(val)

    def pop(self) -> None:
        self.s.pop()
        self.mins.pop()
        

    def top(self) -> int:
        return self.s[-1]

    def getMin(self) -> int:
        return self.mins[-1]
