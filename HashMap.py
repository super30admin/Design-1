#time complexity: O(1)
#space complexity : O(n)
# this solution is implemented using dictionary in python and is implemented on leetcode.
class MyHashMap:

    def __init__(self):
        self.size = 100000
        self.dict = [-1] * self.size#defining a list   

    def put(self, key: int, value: int) -> None:
        self.dict[key] = value # inserting the key-value pair in dictionary

    def get(self, key: int) -> int:
        return self.dict[key]
    def remove(self, key: int) -> None:
        self.dict[key] = -1
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)