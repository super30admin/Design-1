# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashMap:

    def __init__(self):
        self.dict={}
        

    def put(self, key: int, value: int) -> None:
        self.dict[key]=value
        

    def get(self, key: int) -> int:
        if key in self.dict:
            return self.dict[key]
        return -1
        

    def remove(self, key: int) -> None:
        if key in self.dict:
            del self.dict[key]
        
hashMap = MyHashMap()
hashMap.put(1, 2)
hashMap.put(2, 3)
print(hashMap.get(1))
print(hashMap.get(3))
hashMap.put(2, 4)
hashMap.get(2)
print(hashMap.remove(2))
print(hashMap.get(2))