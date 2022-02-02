#time complexity: O(1)
#space complexity : O(n)
# this solution is implemented using dictionary in python and is implemented on leetcode.
class MyHashMap:

    def __init__(self):
        self.dict = {} #defining a dictionary    

    def put(self, key: int, value: int) -> None:
        self.dict[key] = value # inserting the key-value pair in dictionary

    def get(self, key: int) -> int:
        if key in self.dict:# if the key is present
            return self.dict[key]  # return the element
        return -1 # if the key is not present

    def remove(self, key: int) -> None:
        if key in self.dict:
            self.dict.pop(key)# deleting the key-value pair inside a dictionary
        
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)