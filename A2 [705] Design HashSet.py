# Your MyHashSet object will be instantiated and called as such:

# Time Complexity O(1)
# Space Complexity O(n)

class MyHashSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size = 10000  # will suffice positions
        self.table = [None] * self.size  # Number of positions in table

    def calculate_hash_value(self, key):
        return key % self.size  # Calculating hash value

    def add(self, key: int) -> None:
        hv = self.calculate_hash_value(key)

        if self.table[hv] == None:  # if table[hv] is None, then assign key in that position of table
            self.table[hv] = [key]
        else:
            self.table[hv].append(key)  # append the value in the table[hv]

    def remove(self, key: int) -> None:
        hv = self.calculate_hash_value(key)  # Calculating hash value

        if self.table[hv] != None:  # if table[hv] is not None then delete all the values present in th hv index
            while key in self.table[hv]:
                self.table[hv].remove(key)

    def contains(self, key: int) -> bool:  # making return type as bool
        """
        Returns true if this set contains the specified element
        """
        hv = self.calculate_hash_value(key)  # Calculating hash value

        if self.table[
            hv] != None:  # if table[hv] is not empty, then check for the key value if it is present in that position or not
            print(key in self.table[hv])  # and return boolean values based on it
            return key in self.table[hv]
        return False


obj = MyHashSet()
obj.add(12)
obj.remove(12)
param_3 = obj.contains(12)