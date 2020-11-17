class Bucket:
    def __init__(self):
        self.bucket = []

    def get(self, key):
        for (k, v) in self.bucket:
            if k == key:
                return v
        return -1

    def update(self, key, value):
        found = False
        for i , kv in enumerate(self.bucket):
            if key == kv[0]:
                self.bucket[i] = (key, value)
                found = True
                break
        if not found:
            self.bucket.append((key, value))

    def remove(self, key):

        for i, kv in enumerate(self.bucket):
            if key == kv[0]:
                del self.bucket[i]


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.key_space = 11
        self.hash_table = [Bucket() for i in range(self.key_space)]

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """

        hashkey = key % self.key_space
        self.hash_table[hashkey].update(key, value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """

        hashkey = key % self.key_space
        return self.hash_table[hashkey].get(key)

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """

        hashkey = key % self.key_space
        self.hash_table[hashkey].remove(key)


