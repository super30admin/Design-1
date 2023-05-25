# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : In the contain was not able to figure out the return statement

class MyHashSet:

    def __init__(self):
        self.arr =[]
        for i in range(1000):
            row = []
            if i == 0 :
                for j in range(1001):
                    row.append(None)
            else:
                for j in range(1000):
                    row.append(None)
            self.arr.append(row)

    def add(self, key: int) -> None:
        hash1 = key % 1000
        hash2 = key // 1000
        self.arr[hash1][hash2] = key
        

    def remove(self, key: int) -> None:
        hash1 = key % 1000
        hash2 = key // 1000
        self.arr[hash1][hash2] = None
        

    def contains(self, key: int) -> bool:
        hash1 = key % 1000
        hash2 = key // 1000
        return self.arr[hash1][hash2] is not None
        
        
# test cases        
def test_my_hash_set():
    obj = MyHashSet()
    assert obj.add(1) is None
    assert obj.add(2) is None
    assert obj.contains(1) is True
    assert obj.contains(3) is False
    assert obj.add(2) is None
    assert obj.contains(2) is True
    assert obj.remove(2) is None
    assert obj.contains(2) is False

def test_my_hash_set_negative():
    obj = MyHashSet()
    assert obj.contains(1) is False
    assert obj.remove(1) is None


test_my_hash_set()
test_my_hash_set_negative()

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)