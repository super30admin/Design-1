"""
MinStack - Two Solutions
========================

Both solutions support push, pop, top, and getMin in O(1) time per operation.

Time Complexity (per operation): O(1) for push, pop, top, getMin
Space Complexity: O(n) worst case for both (e.g. pushing a strictly
non-increasing sequence causes every push to add to both structures,
i.e. up to 2n total elements stored -- which is still O(n) asymptotically,
constants are dropped).
"""


# ---------------------------------------------------------------------------
# Solution 1: Two-Stack Approach
# ---------------------------------------------------------------------------
# Idea: Keep a second stack (`min_stack`) that tracks the minimum seen so far
# at each point in the push history. When we push a value <= current min,
# we also push it onto min_stack. When we pop a value that equals the top of
# min_stack, we pop min_stack too, restoring the previous minimum.
#
# Time Complexity: O(1) per operation
# Space Complexity: O(n) worst case (min_stack can grow as large as stack)

class MinStackTwoStacks:
    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, x: int) -> None:
        self.stack.append(x)
        if len(self.min_stack) == 0 or x <= self.min_stack[-1]:
            self.min_stack.append(x)

    def pop(self) -> None:
        if not self.stack:
            raise IndexError("pop from empty stack")
        val = self.stack.pop()
        if self.min_stack and val == self.min_stack[-1]:
            self.min_stack.pop()

    def top(self) -> int:
        if not self.stack:
            raise IndexError("top from empty stack")
        return self.stack[-1]

    def getMin(self) -> int:
        if not self.min_stack:
            raise IndexError("getMin from empty stack")
        return self.min_stack[-1]


# ---------------------------------------------------------------------------
# Solution 2: One-Stack Approach
# ---------------------------------------------------------------------------
# Idea: Use a single stack. Whenever we push a new value that is <= the
# current running minimum, first push the *old* minimum onto the stack as a
# sentinel, then push the new value, then update min_value. On pop, if the
# popped value equals min_value, that means we just popped past a "new min"
# marker -- pop again to recover the previous minimum.
#
# Time Complexity: O(1) per operation
# Space Complexity: O(n) worst case (each "new min" push adds 2 elements)

class MinStackOneStack:
    def __init__(self):
        self.stack = []
        self.min_value = float('inf')

    def push(self, x: int) -> None:
        if x <= self.min_value:
            self.stack.append(self.min_value)  # save old min as sentinel
            self.min_value = x
        self.stack.append(x)

    def pop(self) -> None:
        if not self.stack:
            raise IndexError("pop from empty stack")
        popped = self.stack.pop()
        if popped == self.min_value:
            self.min_value = self.stack.pop()  # restore previous min

    def top(self) -> int:
        if not self.stack:
            raise IndexError("top from empty stack")
        return self.stack[-1]

    def getMin(self) -> int:
        if self.min_value == float('inf'):
            raise IndexError("getMin from empty stack")
        return self.min_value


# ---------------------------------------------------------------------------
# Tests
# ---------------------------------------------------------------------------

def run_tests(MinStackClass):
    name = MinStackClass.__name__

    # basic push/pop/top/getMin with a duplicate min
    s = MinStackClass()
    s.push(5)
    s.push(3)
    s.push(7)
    s.push(3)                      # duplicate min
    assert s.getMin() == 3
    assert s.top() == 3
    s.pop()                        # pop the duplicate 3
    assert s.getMin() == 3         # earlier 3 still tracked as min
    assert s.top() == 7
    s.pop()                        # pop 7
    assert s.top() == 3
    s.pop()                        # pop 3 -> min reverts to 5
    assert s.getMin() == 5
    assert s.top() == 5

    # single element
    s = MinStackClass()
    s.push(1)
    assert s.getMin() == 1
    assert s.top() == 1

    # negative numbers, shrinking min
    s = MinStackClass()
    s.push(-2)
    s.push(0)
    s.push(-3)
    assert s.getMin() == -3
    s.pop()
    assert s.getMin() == -2
    assert s.top() == 0

    # all equal values
    s = MinStackClass()
    for v in [2, 2, 2, 2]:
        s.push(v)
    assert s.getMin() == 2
    s.pop(); s.pop(); s.pop()
    assert s.getMin() == 2

    # strictly increasing -- min never changes after first push
    s = MinStackClass()
    for v in [1, 2, 3, 4, 5]:
        s.push(v)
    assert s.getMin() == 1
    s.pop(); s.pop()
    assert s.getMin() == 1
    assert s.top() == 3

    # strictly decreasing -- min changes on every push
    s = MinStackClass()
    for v in [5, 4, 3, 2, 1]:
        s.push(v)
    assert s.getMin() == 1
    s.pop()
    assert s.getMin() == 2
    s.pop()
    assert s.getMin() == 3

    # empty stack should raise on getMin / top / pop
    s = MinStackClass()
    for op in (s.getMin, s.top, s.pop):
        try:
            op()
            assert False, f"expected IndexError from {op.__name__}"
        except IndexError:
            pass

    print(f"{name}: all tests passed")


if __name__ == "__main__":
    run_tests(MinStackTwoStacks)
    run_tests(MinStackOneStack)
    print("\nAll tests passed for both implementations.")