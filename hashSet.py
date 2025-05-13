"""
Fixed length buckets(lists) are used to handle collisions.
Key % size maps keys to a bucket index between 0 and size -1. All operations happen within the corresponding bucket.
Add checks and adds the key if not present, remove removes the key and contains checks if key is already present.

"""

"""
Time Complexity:
Average: O(1) for add, remove, and contains
Worst case (too many collisions): O(n) per bucket
Space Complexity:
O(n + Bucket count); n = number of keys stored, and Bucket count = 10000
"""


class hashSet:

    def __init__(self):

        self.size = 10000
        self.buckets = []
        for _ in range(self.size):
            self.buckets.append([])

    def add(self, key: int) -> None:

        if not self.contains(key):
            val = key % self.size
            self.buckets[val].append(key)
        

    def remove(self, key: int) -> None:
        val = key % self.size
        if key in self.buckets[val]:
            self.buckets[val].remove(key)      

    def contains(self, key: int) -> bool:

        val = key % self.size
        if key in self.buckets[val]:
            return True
        return False
        
if __name__=="__main__":

# Your MyHashSet object will be instantiated and called as such:
    obj = hashSet()
    obj.add(3)
    obj.add(10)
    obj.add(9)
    obj.add(3)
    obj.remove(9)
    print(obj.contains(9))
    print(obj.contains(3))

        