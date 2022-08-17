# Time Complexity : all operations O(n)
# Space Complexity : all operations O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : wasn't able to code in professor's approach in python for constant complexity


# Your code here along with comments explaining your approach: basic checkers if the value exists in the hashset for additions/deletion
class MyHashSet:
    list1 = []
    
    def __init__(self):
        self.list1 = []

    def add(self, key: int) -> None:
        for i in self.list1:
            if i == key:
                return False
        self.list1.append(key)
        return self.list1
                

    def remove(self, key: int) -> None:
        for i in self.list1:
            if i == key:
                self.list1.remove(key)
                return self.list1
        return False

    def contains(self, key: int) -> bool:
        for i in self.list1:
            if i == key:
                return True
        return False
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)


    