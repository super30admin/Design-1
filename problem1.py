class MyHashMap:
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.array = [-1 for i in range(1000000)]
        

    def put(self, key: int, value: int) -> None:
        
        # value will always be non-negative.
        self.array[key] = value
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        return self.array[key]
        """
        self.array[key] = -1

        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        self.array[key] = -1




MyHashMap hashMap = new MyHashMap()


hashMap.put(1, 2)          



hashMap.put(2, 3)         



hashMap.get(1)          # returns 2



hashMap.get(3)          # returns -1 (not found)



hashMap.put(2, 4)       # update the existing value



hashMap.get(2)              #returns 4 



hashMap.remove(2)       # remove the mapping for 2



hashMap.get(2)            # returns -1 (not found)