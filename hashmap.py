# Time Complexity :O(1) for all operations
# Space Complexity :O(N)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : No
class MyHashMap:
    def __init__(self):
        self.data = []
        self.data = [None] * 1000000
    def put(self, key: int, value: int) -> None:
        self.data[key] = value
    def get(self, key: int) -> int:
        if self.data[key] is None:
            return -1
        else:
            return self.data[key]
    def remove(self, key: int) -> None:
        self.data[key] = None


if __name__ == '__main__':
    ob = MyHashMap()
    ob.put(1, 1)
    ob.put(2, 2)
    print(ob.get(1))
    print(ob.get(3))
    ob.put(2, 1)
    print(ob.get(2))
    ob.remove(2)
    print(ob.get(2))