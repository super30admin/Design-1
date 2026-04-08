# Time Complexity : O(1)* - * could be O(n) if all n inserted values happen to fall in the same bucket, thus requiring us to scan through the entire array n-times
# Space Complexity : O(n) - for n elements being added
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
# we initiated an array of empty arrays so we can add new values to them by using % bucket_size. in each bucket, we add/remove the same way we would a normal array.


class MyHashSet:

    # Time: O(1)
    # Space: O(1)
    def __init__(self):
        self.bucket_size = 1000001
        self.buckets = [[] for _ in range(self.bucket_size)]

    # Time: O(1)*
    # Space: O(1)
    def add(self, key: int) -> None:
        if key not in self.buckets[key % self.bucket_size]:
            self.buckets[key % self.bucket_size].append(key)

    # Time: O(1)*
    # Space: O(1)
    def remove(self, key: int) -> None:
        if key in self.buckets[key % self.bucket_size]:
            self.buckets[key % self.bucket_size].remove(key)

    # Time: O(1)*
    # Space: O(1)
    def contains(self, key: int) -> bool:
        return key in self.buckets[key % self.bucket_size]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
