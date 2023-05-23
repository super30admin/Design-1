# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# We used a normal list and made buckets (number being a prime : https://medium.com/swlh/why-should-the-length-of-your-hash-table-be-a-prime-number-760ec65a75d1) 
# to imitate the functions of a hashset. We used Modulo Hash Function.

NUM_BUCKETS = 32783

class MyHashSet:

    def __init__(self):
        self.buckets = [[] for _ in range(NUM_BUCKETS)]
    
    def calc(self,key) -> int:
        return key % NUM_BUCKETS

    def add(self, key: int) -> None:
        mod = self.calc(key)
        if not key in self.buckets[mod]:
            self.buckets[mod].append(key)

    def remove(self, key: int) -> None:
        mod = self.calc(key)
        try:
            self.buckets[mod].remove(key)
        except:
            pass
           
    def contains(self, key: int) -> bool:
        mod = self.calc(key)
        return key in self.buckets[mod]