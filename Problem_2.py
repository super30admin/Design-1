# Time Complexity : O(1) 
# Space Complexity : O(n) -> Space will be allocated for every given key.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :No

class MyHashSet(object):

    def __init__(self):
        self.containers= [[]]*1000

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        cont_idx= key % 1000
        if key not in self.containers[cont_idx]:
            self.containers[cont_idx].append(key)

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        cont_idx= key % 1000
        if key in self.containers[cont_idx]:
            self.containers[cont_idx].remove(key)

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        cont_idx= key%1000
        if key in self.containers[cont_idx]:
            return True
        return False



# Your MyHashSet object will be instantiated and called as such:

myHashSet = MyHashSet()
myHashSet.add(411)
myHashSet.add(267)
myHashSet.add(23)
myHashSet.add(76)
print(myHashSet.contains(411))  
print(myHashSet.contains(76))  
myHashSet.add(212)
print(myHashSet.contains(212))  
myHashSet.remove(212)
print(myHashSet.contains(212))  