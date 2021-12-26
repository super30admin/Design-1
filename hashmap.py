"""
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
"""
class MyHashMap:

    def __init__(self):
        self.bucket_length = 1000
        self.item_length = 1000
        self.bucket = [[] for bucket in range(self.bucket_length)]

    def put(self, key, value):
        bucket = key % self.bucket_length
        item = key // self.item_length

        if not self.bucket[bucket]:
            self.bucket[bucket] = [-1 for bucket in range(self.item_length)]
        if bucket == 0:
            self.bucket[bucket].append(-1)

        self.bucket[bucket][item] = value

    def get(self, key):
        bucket = key % self.bucket_length
        item = key // self.item_length

        if not self.bucket[bucket]:
            return -1
        return self.bucket[bucket][item]

    def remove(self, key):
        bucket = key % self.bucket_length
        item = key // self.item_length

        if not self.bucket[bucket]:
            return
        self.bucket[bucket][item] = -1



# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)