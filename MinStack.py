#Time Complexity : O(1) for all methods
#Space Complexity : O(n + log n ) for average case
                    O(n + n) for worst case
                    O(n) for best case
#Did this code successfully run on Leetcode : Yes
class MinStack:

    def __init__(self):
        self.stack = list()
        self.head = -1
        self.min_value = None

    def push(self, val: int) -> None:

        #if stack is empty, then add val in stack and set it as min_val
        if self.head == -1:
            self.min_value = val
            self.head += 1
            self.stack.append(val)

        #for non-empty stack...
        else:
            #if val is greater than min_val then just append. Because min_val is not affected
            if self.min_value < val:
                self.head += 1
                self.stack.append(val)

            #elif val is greater or equal to min_val, append this new val as well as
            #and set this new val as min_val. S0, we have top = new val and top-1 = old_min.
            #This is helpful when we we pop minimum element from stack. We would still be having
            #old_min_val.
            else:
                self.head += 2
                self.stack.append(self.min_value)
                self.stack.append(val)
                self.min_value = val

    def pop(self) -> None:
        if self.head == -1:
            pass
        else:
            # pop ans store it in ans.
            ans = self.stack.pop()
            self.head -= 1
            #if ans <= current_min_val, then we will use old min_val. (Which we stored in push operation)
            if ans <= self.min_value and self.head != -1: #self.head != -1 is set because if stack becomes empty then there is no need to further pop items.
                self.min_value = self.stack.pop()
                self.head -= 1
            else:
                pass

    def top(self) -> int:
        #returns value where top poiner is pointing
        return self.stack[len(self.stack) - 1]

    def getMin(self) -> int:
        #returns min_value. We are keeping track of min_val while popping and pushing so no need to
        #parse whole stack for that. Therefore, Time Complexity = O(1)
        return self.min_value

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
