class MyHashMap:
## *****************************************Double hashing Technique*******************************************************
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size=1000
        self.bucket=[None for _ in range(1000)]
        # self.chainList=list()

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        #First Hash to traverse in main array it gives the remainde
        bucketHash=key%self.size
        ## Second Hash to traverse in the sub array it divides and takes the floor value
        itemHash=key//self.size
        if self.bucket[bucketHash]==None:
            self.bucket[bucketHash]=[None for _ in range(1001)]
        self.bucket[bucketHash][itemHash]=value

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        bucketHash=key%self.size
        itemHash=key//self.size
        # if self.bucket[bucketHash]==None:
        #     return -1;
        if self.bucket[bucketHash]==None or self.bucket[bucketHash][itemHash]==None:
            return -1
        else:
            return self.bucket[bucketHash][itemHash]

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        bucketHash=key%self.size
        itemHash=key//self.size
        if self.bucket[bucketHash]==None or self.bucket[bucketHash][itemHash]==None:
            return
        self.bucket[bucketHash][itemHash]=None
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)