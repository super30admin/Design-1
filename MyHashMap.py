class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 2069
        self.buckets = [[] for i in range(self.size)]

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        bucket = self.buckets[key % self.size]
        for elem in bucket:
            if elem[0] == key:
                elem[1] = value
                return
        bucket.append([key, value])

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        bucket = self.buckets[key % self.size]
        for elem in bucket:
            if elem[0] == key:
                return elem[1]
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        bucket = self.buckets[key % self.size]
        for i, elem in enumerate(bucket):
            if elem[0] == key:
                del bucket[i]
                break
