"""
We need hashset as it makes searches easy for us , does not iterate in the object , search is in O(1) and there are no suplicates.
In this code, hash set keys are unique.
Firstly, we need to store keys or values. It is advisable to use arrays as the lookup is O(1), we know the data type ie the parent data structure. And everytime we use the key it gives us the same output.
"""

"""
Time Complexity :O(1)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes it did
Any problem you faced while coding this : At first I got a syntax error because function were empty -forgot to use `pass`.
Then I fixed it by implementing actual logic and using Python's built-in set for efficiency
"""

class MyHashSet(object):

    def __init__(self):
        self.set = set()

    def add(self, key):
        self.set.add(key)

    def remove(self, key):
        if key in self.set:
            self.set.remove(key)

    def contains(self, key):
        return key in self.set


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)