#// Time Complexity :O(1)
#// Space Complexity :O(n)
#// Did this code successfully run on Leetcode : YES
class MyHashMap:

    def __init__(self):
        self.arr=[None for x in range(1000)]

    def put(self, key: int, value: int) -> None:
        key1=key%1000
        
        if self.arr[key1]==None:
            self.arr[key1]=[None]*1001
        key2=key//1000
        self.arr[key1][key2]=value
        

    def get(self, key: int) -> int:
        # print(self.arr)
        key1=key%1000
        key2=key//1000
        if self.arr[key1] != None and self.arr[key1][key2]!= None:
            return self.arr[key1][key2]
        
        return -1

    def remove(self, key: int) -> None:
        key1=key%1000
        key2=key//1000
        if self.arr[key1] != None and self.arr[key1][key2]!= None:
            self.arr[key1][key2] =-1


