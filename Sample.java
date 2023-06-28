// Problem 1 : HashSet

// Time Complexity : O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I am not sure how to create an empty 2 D array in Python. 
// Is there any better way to do this python?


// I have taken a 2-D array. First hash function will return row of the array in final answer 
// and second hash function will return the column where it can be inserted. While adding a 
// new element, I have checked if the node is empty. If empty, I have created a boolean list.
// Boolean list is used instead of integer to save space

class MyHashSet:

    def __init__(self):
        self.hashSetAnswer = [[None] * 1001 for i in range(1000)]

    def hash1(self, i):
        return i%1000
    
    def hash2(self, i):
        return i//1000

    def add(self, key: int) -> None:
        outer_index = self.hash1(key)
        if self.hashSetAnswer[outer_index] is None:
            inner_bucket=[false]*size
            self.hashSetAnswer[outer_index]=inner_bucket
        inner_index = self.hash2(key)
        self.hashSetAnswer[outer_index][inner_index]=True

    def remove(self, key: int) -> None:
        outer_index = self.hash1(key)
        if self.hashSetAnswer[outer_index] is None:
            return
        inner_index = self.hash2(key)
        self.hashSetAnswer[outer_index][inner_index]=False

    def contains(self, key: int) -> bool:
        outer_index = self.hash1(key)
        if self.hashSetAnswer[outer_index] is None:
            return
        inner_index = self.hash2(key)
        return self.hashSetAnswer[outer_index][inner_index]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

// Problem 2 : Min Stack

// Time Complexity : O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// I have used a single array for solving the problem. In each push operation, I am inserting 
// a combination of minimum value and the value pushed. The minimum value is maintained at every level.



class MinStack:

    def __init__(self):
        self.min_stack=[]
        

    def push(self, val: int) -> None:
        if len(self.min_stack) == 0:
            self.minimum = float("infinity")
        else:
            self.minimum = self.min_stack[-1][1]
        if val < self.minimum:
            self.minimum = val
            
        self.min_stack.append([val,self.minimum])

    def pop(self) -> None:
        self.min_stack.pop()

    def top(self) -> int:
        return self.min_stack[-1][0]

    def getMin(self) -> int:
        return self.min_stack[-1][1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()


