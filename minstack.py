###I was following a youtube video  https://www.youtube.com/watch?v=QMlDCR9xyd8 for designing this
# and algorithm tells to insert 2*val - min if we find a value smaller than current min; need to attend today's
##class to see how it works ###

class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []

    def push(self, val: int) -> None:
        # self.stack.append(val)
        if self.stack==[]:
            self.stack.append(val)

        elif val >= self.getMin():
            self.stack.append(val)
        else:
            self.stack.append(2*val - self.getMin())



    def pop(self) -> None:
        if self.stack==[]:
            return None

        ###popping will happen same way as pushing just in case if value is less than currentmin we change min to
        ###2*min- currentvalue

    def top(self) -> int:

        return None

    def getMin(self) -> int:
        currentMin = self.stack[0].val ##initially

            # currentMin=None
        return currentMin



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()