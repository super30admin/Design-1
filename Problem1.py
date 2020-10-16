# Time Complexity : put O(1) get O(1) remove O(1)
# Space Complexity :???
class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket=1000
        self.bucketitem=1001
        self.storage=[None for i in range(self.bucket)]

    def hash1(self,key):
        return key % 1000

    def hash2(self,key):
        return key//1000



    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index1=self.hash1(key)
        index2=self.hash2(key)
        print(index2)
        if self.storage[index1]==None:
               self.storage[index1]=[None for i in range(self.bucketitem)]

        self.storage[index1][index2]=value




    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index1=self.hash1(key)
        index2=self.hash2(key)

        if self.storage[index1]==None or self.storage[index1][index2]==None :
            return -1
        else:
            return self.storage[index1][index2]



    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index1=self.hash1(key)
        index2=self.hash2(key)
        #print(self.storage[index1])
        if self.storage[index1]==None:
            print("t")
            return

        self.storage[index1][index2]=None
        print(self.storage[index1][index2])





# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
