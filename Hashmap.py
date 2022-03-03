#Time Complexity : O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : Runtime is greater
class MyHashMap:
    li = {}

    def __init__(self):
        self.li = {}
        

    def put(self, key: int, value: int) -> None:
        self.li[key] = value
        

    def get(self, key: int) -> int:
        for i,j in self.li.items():
            if i==key:
                return j
        return -1
        

    def remove(self, key: int) -> None:
        if key in self.li:
            del self.li[key]
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)