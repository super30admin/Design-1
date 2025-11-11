# leetcode account with username: shreyagoyal06
# Since the list goes from 0 to 10^6 (both included), made sure there are 10^6+1 values set to default while initializing
# In the add function, added the key and just marked that position in the array as True
# In the remove function, flipping that position in the array to False
# In the contains function, looking up for that position in the array and returning it

class MyHashSet:

    def __init__(self):
        self.data=[False]* 1000001        

    def add(self, key: int) -> None:
        self.data[key]=True

    def remove(self, key: int) -> None:
        self.data[key]=False

    def contains(self, key: int) -> bool:
        return self.data[key]
