# // Time Complexity : Update: Best Case: O(1) Worse Case: O(n)
# // Space Complexity: Space complextiy would be the size of the array that you initialized it to
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # The hash function that we will use is the modulo operator.
        # Initialize the array to a constant size(SIZE). Preferably a prime number. This value will also be used in the hash function as
        # the max value of the modulus of the SIZE with a key, will be less than the SIZE as this is the size of the array
        # max(key % SIZE) < SIZE
        self.SIZE = 2069

        # Initialize each value in the array to an array in case of collision
        self.array = [[] for i in range(self.SIZE)]

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        # Use the hash function(Modulo) to identify the location in the array to insert the value
        insertAt = key % self.SIZE

        # Update value at the location by iterating through the array. This is where the worse case can occur
        for i in range(len(self.array[insertAt])):
            k, v = self.array[insertAt][i]
            
            if k == key:
                self.array[insertAt][i] = (k, value)
                return
        self.array[insertAt].append((key,value))
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        valueAt = key % self.SIZE
            
        for i in range(len(self.array[valueAt])):
            k, v = self.array[valueAt][i]
            
            if k == key:
                return v
        return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        valueAt = key % self.SIZE
            
        for i in range(len(self.array[valueAt])):
            k, v = self.array[valueAt][i]
            
            if k == key:
                del self.array[valueAt][i]
                return
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)