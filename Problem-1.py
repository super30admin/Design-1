# // Time Complexity :
    # add O(n)
    # remove O(n)
    # contains O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :No
#all operations are done with single traversal 

class MyHashSet:

    def __init__(self):
        self.l=[]
        self.count=0
        

    def add(self, key: int) -> None:
        for i in self.l:
            if i==key:return None
        self.l.append(key)
        self.count+=1
        

    def remove(self, key: int) -> None:
        if key in self.l:
            self.l.remove(key)
            self.count-=1
        return None


    
    def contains(self, key: int) -> bool:
        return key in self.l
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
