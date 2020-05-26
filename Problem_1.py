"""

    Student : Shahreen Shahjahan Psyche

    The Code Ran Successfully in Leetcode for all the test cases.

    Memory Complexity : O(N^(1/2))

    Average Time Complexity:
        def put : O(1)
        def get : O(1)
        def remove: O(1)

    I have used chaining methods to store the values if there are collisions.

"""

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        
        self.records = [[] for _ in range(1000)]
        
    
    """
        This function returns the specific index to store, get or remove a key value pair based on the key
    """
    def hash_func(self, key:int):
        size = len(self.records)
        return hash(key)%size
        
        
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        get_index = self.hash_func(key)
        pair = [key, value]
        flag = 0
        
        if self.records[get_index] is None:
            self.records[get_index].append(pair)
        else:
            for i in self.records[get_index]:
                if i[0] == key:
                    i[1] = value
                    flag = 1
                    break      
            if flag == 0:
                self.records[get_index].append(pair)


    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        get_index = self.hash_func(key)
        
        if self.records[get_index] is None:
            return -1
        
        for i in self.records[get_index]:
            if i[0] == key:
                return i[1]
        return -1
    
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        get_index = self.hash_func(key)
        if self.records[get_index] is None:
            return
        
        for i in self.records[get_index]:
            if i[0] == key:
                self.records[get_index].remove(i)
                return
        return 
            
        