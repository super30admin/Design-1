// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

# Time Complexity : Amortized - O(1) | Worst Case - O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class MyHashMap:

    def __init__(self):
        self.arr_size = 2069 #Prime Number
        self.arr = [[] for _ in range(2069)]

    def put(self, key: int, value: int) -> None:
        idx = key % (self.arr_size)

        for item in self.arr[idx]:
            k,v = item
            if k == key:
                self.arr[idx].remove((k,v))
        self.arr[idx].append((key,value))

    def get(self, key: int) -> int:
        idx = key % (self.arr_size)
        
        for k,v in self.arr[idx]:
            if k == key:
                return v
        return -1

    def remove(self, key: int) -> None:
        idx = key % (self.arr_size)

        for items in self.arr[idx]:
            k, v = items
            if k == key:
                self.arr[idx].remove((k,v))

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)