"""
// Time Complexity : put o1, get: oN, remove:oN
// Space Complexity : ON, all input data
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
//push pop top must be O1
Use 2 stacks, in house stack fxn allowed
one stak to keep track of min, as pop occurs
"""

class MyHashMap:

    def __init__(self):
        self.data = {};

    def put(self, key: int, value: int) -> None:
        self.data[key] = value;

    def get(self, key: int) -> int:
        if key in self.data:
            return self.data[key]
        else:
            return -1
        

    def remove(self, key: int) -> None:
        if not self.data:
            print("hashmap is empty")
        del self.data[key]
        


# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(1,20)
obj.put(2,20)
obj.put(3,20)
param_2 = obj.get(1)
obj.remove(2)