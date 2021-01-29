class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_value = None

    def push(self, x: int) -> None:

        if ( self.min_value == None ):
            self.min_value = x
            self.stack.append( self.min_value )
            return
        if ( x <= self.min_value  ):
            self.stack.append( self.min_value )
            self.min_value = x
        self.stack.append( x )

        return

    def pop(self) -> None:

        top = self.stack.pop()
        if ( top == self.min_value ):
            if ( self.stack ):
                self.min_value = self.stack.pop()
            else:
                self.min_value = None

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:

        return self.min_value


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
