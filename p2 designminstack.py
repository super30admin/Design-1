class MinStack:
    def __init__(self):
        self.st = []
        self.minst = []
        self.min = float('inf')
        self.minst.append(self.min)

    def push(self, val: int) -> None:
        self.min = min(val, self.min)
        self.st.append(val)
        self.minst.append(self.min)

    def pop(self) -> None:
        if self.st:
            self.st.pop()
            self.minst.pop()
            self.min = self.minst[-1]

    def top(self) -> int:
        return self.st[-1] if self.st else None

    def getMin(self) -> int:
        # In your image, this was partially cut off. 
        # It returns the current minimum from the auxiliary stack.
        return self.minst[-1] if len(self.minst) > 1 else None

# --- Example Execution ---
if __name__ == "__main__":
    minStack = MinStack()
    
    print("Action: push(-2), push(0), push(-3)")
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    
    print(f"getMin(): {minStack.getMin()}") # Returns -3
    
    print("Action: pop()")
    minStack.pop()
    
    print(f"top():    {minStack.top()}")    # Returns 0
    print(f"getMin(): {minStack.getMin()}") # Returns -2