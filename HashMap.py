"""
Problem 1:HashMap in Python

Time complexity for put/get/remove : O(1)
Space Complexity : O(n) where n is the no. of key,value pairs

Did the below program run for all cases given on Leetcode? Yes
"""

class HashMap:
    
    def __init__(self):
        self.a = {}
        
    def put(self,key: int,value: int):
        self.a[key] = value
        
    def get(self,key: int):
        if key in self.a.keys():
            return self.a[key]
        else:
            return -1
    def remove(self,key: int):
        if key in self.a.keys():
            del self.a[key]
            

h = HashMap()
h.put(1,1)
h.put(2,2)
print(h.get(1))
h.put(2,1)
print(h.get(2))
h.remove(2)
print(h.get(2))
