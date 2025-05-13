class MyHashSet:

    #Time complexity - o(n)
    #Space Complexity - o(n)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : None

    def __init__(self):
        self.hashSet = []

    def add(self, key: int) -> None:
        if not self.contains(key):
            self.hashSet.append(key)
        

    def remove(self, key: int) -> None:
        
        if self.contains(key):
            for i in range(len(self.hashSet)):
                if self.hashSet[i]==key:
                    self.hashSet.pop(i)
                    return

    def contains(self, key: int) -> bool:
        if len(self.hashSet)>0:
            for i in range(len(self.hashSet)):
                if self.hashSet[i]==key:
                    return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)