"""

    Student : Shahreen Shahjahan Psyche

    The Code Ran Successfully in Leetcode for all the test cases.

    Memory Complexity : O(N)

    Average Time Complexity:
        def push : O(1)
        def pop : O(1)
        def top: O(1)
        def getMin : O(1)

    I have used chaining methods to store the values if there are collisions.

"""


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        
        self.records = []
        self.min_records = []
        

    def push(self, x: int) -> None:
        if len(self.min_records) == 0:
            self.min_records.append(x)
        else:
            self.min_records.append(min(self.min_records[-1], x))
        self.records.append(x)
        

    def pop(self) -> None:
        if self.records is None:
            return
        self.min_records.pop()
        return self.records.pop()
        

    def top(self) -> int:
        if self.records is None:
            return
        return self.records[len(self.records)-1]
        
    def getMin(self) -> int:
        if self.min_records is None:
            return
        return self.min_records[len(self.min_records)-1]