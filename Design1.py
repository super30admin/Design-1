# Time Complexity : O(1)
# Space Complexity : O(N) where N is the number of elements in the set
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using a defaultdict which will store the keys in a hashset. If I add an element in the hashset I mark 1 for the element. 
# While removing I just pop the element from the hashset and make it default value. To find an element I just check if the key
# is present in the hashset as marked 1.

import collections


class MyHashSet:

    def __init__(self):
        self.hashset = collections.defaultdict(int)

    def add(self, key: int) -> None:
        self.hashset[key] = 1

    def remove(self, key: int) -> None:
        self.hashset.pop(key,None)

    def contains(self, key: int) -> bool:
        return self.hashset[key] == 1