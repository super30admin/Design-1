# Time Complexity : O(1) for push, pop, top and getMin
# Space Complexity : O(n); worst case 2n entries when every push is a new min
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : First version didn't restore the previous min on pop
#
# Approach (3 sentences only):
# I use one stack plus a variable holding the current min.
# When pushing a value <= the current min, I first push the old min onto the stack, then update the min.
# When popping a value equal to the min, I pop once more to restore the previous min.


class MinStack:

    def __init__(self):
        self.st = []
        self.min = float("inf")

    def push(self, val: int) -> None:
        if val <= self.min:
            self.st.append(self.min)
            self.min = val

        self.st.append(val)

    def pop(self) -> None:
        popped_value = self.st.pop()
        if popped_value == self.min:
            self.min = self.st.pop()

    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.min


if __name__ == "__main__":
    st = MinStack()
    st.push(-2)
    st.push(0)
    st.push(-3)
    print(st.getMin())  # -3
    st.pop()
    print(st.top())     # 0
    print(st.getMin())  # -2
