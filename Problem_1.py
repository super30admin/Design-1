"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : I am having issue in designing a new hash function if I want to 
apply double hashing


Your code here along with comments explaining your approach
I have made an array of size 1000 and taken the hashfunction as key%1000. Originally the value is None, but when 
a new value comes, a list is appended to that index of the original map array. For searching, same approach is used.
We find the index using hashfunction and traverse through the list. This solution is not optimal as
double hashing can be used. Instead of appending a value to the list one by one, we can make an array to that position
in the map array, and use another hash function to find the new index. But, I was not able to decide and find out
what kind of new hash function can be implemented. Maybe prime numbers can be used , but I am not sure.
So I submitted this version.
"""


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 1000
        self.map = [None] * self.size

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        i = key % self.size
        pair = [key, value]
        if not self.map[i]:
            self.map[i] = list([pair])
        else:
            for p in self.map[i]:
                if p[0] == key:
                    p[1] = value
                    return True
            self.map[i].append(pair)
            return True

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        i = key % self.size
        if not self.map[i]:
            return -1
        for p in self.map[i]:
            if p[0] == key:
                return p[1]
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        i = key % self.size
        if not self.map[i]:
            return False
        for x in range(len(self.map[i])):
            if self.map[i][x][0] == key:
                self.map[i].pop(x)
                return True
        return False


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
