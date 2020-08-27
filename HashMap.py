# Time Complexity : O(1) on average, but O(n) when there are collisions
# Space Complexity : O(n) for the size of the array
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this : choosing an appropriate hash function

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # the total number of keys my hashmap will have
        self.bucketList = []
        self.k = 2069

        # creating our array with buckets
        for i in range(0, self.k):
            self.bucketList.append([])

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        keyFound = False
        hashFunctionResult = key % self.k
        bucketToUpdate = self.bucketList[hashFunctionResult]
        for index, keyValuePair in enumerate(bucketToUpdate):
            if keyValuePair[0] == key:
                keyValuePair[index] = (key, value)
                break

        if keyFound is not True:
            bucketToUpdate.append([key, value])

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        keyFound = False
        hashFunctionResult = key % self.k
        bucketToUpdate = self.bucketList[hashFunctionResult]
        for index, keyValuePair in enumerate(bucketToUpdate):
            if keyValuePair[0] == key:
                return keyValuePair[1]

        if keyFound is not True:
            return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashFunctionResult = key % self.k
        bucketToUpdate = self.bucketList[hashFunctionResult]
        for i, kv in enumerate(bucketToUpdate):
            if key == kv[0]:
                del bucketToUpdate[i]

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)