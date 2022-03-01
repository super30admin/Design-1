#Time complexity: All operations are O(1).
#Space Complexity: O(n).

#I implemented the stack in such a way that whenever push operation is called element along with current smallest element is added to the stack.
#[[val,smallest_val]]



class MinStack:

    def __init__(self):
        self.stack = []
        

    def push(self, val: int) -> None:
        if self.stack == []:
            self.stack.append([val,val])
            curr_mini = self.stack[-1][1]
        else:
            curr_mini = self.stack[-1][1]
            self.stack.append([val,min(curr_mini,val)])
            
            

    def pop(self) -> None:
        self.stack.pop()
        

    def top(self) -> int:
        return self.stack[-1][0]
        
        

    def getMin(self) -> int:
        return self.stack[-1][1]
