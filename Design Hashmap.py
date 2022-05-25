""""// Time Complexity : O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach"""



class MyHashMap:

    def __init__(self):
        self.dict = {}

    def put(self, key: int, value: int) -> None:
        self.dict[key] = value
        # print(self.dict[key])

    def get(self, key: int) -> int:
        if key not in self.dict:
            return -1
        else:
            return self.dict[key]

    def remove(self, key: int) -> None:
        if key in self.dict:
            self.dict.pop(key)
# Your MyHashMap object will be instantiated and called as such:
x = MyHashMap()
x.put(1, 10)
x.put(2, 5)
print(x.get(10))
print(x.get(2))
x.remove(1)
print(x.get(1))
