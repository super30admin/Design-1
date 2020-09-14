class MinStack:
    # Idea is to store the cur_min element in the stack along with the pushed element (x, min())
    # Thereby when pop() is called we still have the till then min element and we dont have to recalculate 
    # Time Complexity : O(1) 
    # Space Complexity : O(n) stack size, along with min element
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack_size = 100
        self.top_idx = -1
        self.n_items = 0
        self.stack = [(-1,-1)]*self.stack_size

    def push(self, x: int) -> None:
        if(self.n_items<self.stack_size):
            self.top_idx += 1
            self.n_items += 1
            if(self.top_idx==0):
                self.stack[self.top_idx] =  (x, x)
            else:
                prev_x = self.stack[self.top_idx-1][1]
                self.stack[self.top_idx] =  (x, min(x, prev_x))
        else:
            self.stack_size += 100
            self.stack += [(-1,-1)]*100
            self.push(x)
    
    def pop(self) -> None:
        item = self.stack[self.top_idx]
        self.stack[self.top_idx] = (-1,-1)
        self.top_idx -= 1
        self.n_items -= 1
        return item[0]

    def top(self) -> int:
        return self.stack[self.top_idx][0]

    def getMin(self) -> int:
        return self.stack[self.top_idx][1]    