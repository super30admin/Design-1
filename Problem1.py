'''
Time Complexity: O(1) for all operations
Space Complexity: O(n) n is the total number of keys possible
Run on Leetcode: YES
Problems: The code might not work for negative values of keys. we need to implement array of linked list for that.
'''
class MyHashMap:

    def __init__(self):
        self.value = [-1] * 1000001
        

    def put(self, key: int, value: int) -> None:
        self.value[key] = value
        return None
        

    def get(self, key: int) -> int:
        return self.value[key]
        

    def remove(self, key: int) -> None:
        self.value[key] = -1
        return None
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)