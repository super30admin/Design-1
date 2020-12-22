# Approach: Initially tried with using a large array defined as per constraint ([0, 1000000])
# If the key is not found we return -1 hence intialized the huge sized array with -1
# Time complexity - O(1) for get, put,remove
# Space complexity - O(N) where N is the size of the array
# Not an ideal solution as defining a huge array adds to space constraint 
# Ran with 365 ms and 39 Mb space
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.arr = [-1] * 1000000
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        self.arr[key] = value
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        
        return self.arr[key]
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        self.arr[key] = -1
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)

#####

# Approach 2: Declared an array for holding the data with the help of a linked list
# Used a basic hashing by performing modulo operation on the key wrt to the size declared with a linked list approach
# Not sure how to calculate Time complexity
# Space Complexity -- O(M + N) where M is the size of hashMap and N is the keys inserted
class Node:
    def __init__(self, key, val):
        self.key_val_pair = (key, val)
        self.next = None

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        Declare an array for holding the data
        """
        self.size = 1000
        self.hashMap = [None] * self.size
        

    def put(self, key, value):
        """
        Obtain index based on hashing defined below
        If the value at this index in hashmap is None, we can add the new key val pair here
        If not check if the key corresponds to the key at which we need to insert the value -- Update the key val pair
        If current element is None break there
        If the key value is different, move to next element and repeat
        """
        index = key % self.size
        if self.hashMap[index] == None:
            self.hashMap[index] = Node(key, value)
        else:
            current_element = self.hashMap[index]
            while True:
                # Case 1 - Same key, update the value
                if current_element.key_val_pair[0] == key:
                    current_element.key_val_pair = (key, value)
                    return
                if current_element.next == None: 
                    break
                current_element = current_element.next
            current_element.next = Node(key, value)
        

    def get(self, key):
        """
        Obtain the index at which we need to insert key val pair
        If at index key value matches, return the value at index 1 since its a pair
        If not return -1
        """
        index = key % self.size
        current_element = self.hashMap[index]
        while current_element:
            if current_element.key_val_pair[0] == key:
                return current_element.key_val_pair[1]
            else:
                current_element = current_element.next
        return -1
            
        

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: void
        """
        index = key % self.size
        current_element = self.hashMap[index]
        # Not sure how the removal method would work
        # I understand that if we hit the case where the key is the one we need to remove we need to assign current_element to current_element.next
        # 





