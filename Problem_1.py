# Time Complexity : O(1)
# Space Complexity : O(n) it will be the max size of the constraint given 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
# I was trying to do it with 1000000 but changed it to 1000001 to fix the index issue 

class MyHashMap:

    def __init__(self):
        self.data = [None] * 1000001
    
    def put(self, key: int, value: int) -> None:
        self.data[key] = value

    def get(self, key: int) -> int:
        if self.data[key] is None:
            return -1
        else:
            return self.data[key]
        
    def remove(self, key: int) -> None:
        self.data[key] = None
