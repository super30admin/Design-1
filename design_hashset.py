# Time Complexity : O(1) for add, remove and contains
# Space Complexity : O(1) w.r.t. number of keys; bounded by the key range: 1000 slots up front, at most ~10^6 if every bucket is created
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Key 1,000,000 needs one extra slot in bucket 0
#
# Approach (3 sentences only):
# I split each key into two indexes: primary = key % 1000 picks the bucket, secondary = key // 1000 picks the slot inside it.
# Buckets are created only when the first key lands in them (bucket 0 gets 1001 slots so key 1,000,000 fits).
# add sets the slot to True, remove sets it to False, and contains returns the slot value, or False if the bucket doesn't exist.


class MyHashSet:

    def __init__(self):
        self.arr_size = 1000
        self.arr = [None] * self.arr_size

    def add(self, key: int) -> None:
        primary = key % self.arr_size
        secondary = key // self.arr_size
        if self.arr[primary] is None:
            size = self.arr_size + 1 if primary == 0 else self.arr_size
            self.arr[primary] = [False] * size
        self.arr[primary][secondary] = True


    def remove(self, key: int) -> None:
        primary = key % self.arr_size
        secondary = key // self.arr_size
        if self.arr[primary] is not None:
            self.arr[primary][secondary] = False


    def contains(self, key: int) -> bool:
        primary = key % self.arr_size
        secondary = key // self.arr_size

        if self.arr[primary] is None:
            return False
        return self.arr[primary][secondary]


if __name__ == "__main__":
    s = MyHashSet()
    s.add(1)
    s.add(2)
    print(s.contains(1))  # True
    print(s.contains(3))  # False
    s.add(2)
    print(s.contains(2))  # True
    s.remove(2)
    print(s.contains(2))  # False
