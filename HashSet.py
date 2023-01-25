"""
Rasika Sasturkar
Time Complexity: O(1)
Space Complexity: Depends on the number of elements added
"""


class MyHashSet:

    def __init__(self):
        """
        Constructor - initialized bucket, bucket_items and our hash_storage (set)
        """
        self.bucket = 1000
        self.bucket_items = 1000
        self.hash_storage = [None for _ in range(self.bucket)]

    def hash_funct1(self, item):
        """
        Hash function for our index list
        """
        return item % 1000

    def hash_funct2(self, item):
        """
        Hash function for our pointer list
        """
        return item // 1000

    def add(self, key: int) -> None:
        """
        We get the indexes from hash functions 1 & 2.
        We check if there is any pointer at the hash index 1, if not then create new Boolean list
        Then using hash index 2, we make the item at that position as True
        """
        hash1 = self.hash_funct1(key)
        hash2 = self.hash_funct2(key)
        if self.hash_storage[hash1] is None:
            if hash1 == 0:
                self.hash_storage[hash1] = [False for _ in range(self.bucket_items + 1)]
            else:
                self.hash_storage[hash1] = [False for _ in range(self.bucket_items)]
        self.hash_storage[hash1][hash2] = True

    def remove(self, key: int) -> None:
        """
        We get the indexes from hash functions 1 & 2.
        If hash index 1 was None, then there is no element to remove, so we just return
        Or using hash index 2, we make the item at that position False
        """
        hash1 = self.hash_funct1(key)
        hash2 = self.hash_funct2(key)
        if self.hash_storage[hash1] is None:
            return
        self.hash_storage[hash1][hash2] = False

    def contains(self, key: int) -> bool:
        """
        We get the indexes from hash functions 1 & 2.
        If it was None at the hash index position 1, then we return False
        Or using hash index 2, we return that value (can be True if found or False if not)
        """
        hash1 = self.hash_funct1(key)
        hash2 = self.hash_funct2(key)
        if self.hash_storage[hash1] is None:
            return False
        return self.hash_storage[hash1][hash2]


def main():
    """
    Main function - an example from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    myHashSet = MyHashSet()
    myHashSet.add(1)  # set = [1]
    myHashSet.add(2)  # set = [1, 2]
    print(myHashSet.contains(1))  # return True
    print(myHashSet.contains(3))  # return False, (not found)
    myHashSet.add(2)  # set = [1, 2]
    print(myHashSet.contains(2))  # return True
    myHashSet.remove(2)  # set = [1]
    print(myHashSet.contains(2))  # return False, (already removed)


if __name__ == "__main__":
    main()
