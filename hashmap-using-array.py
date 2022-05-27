# unefficent as space complexity is O(n) line 5. Unnecessary waste to space in the array by unused indexes. Good aproch to sshow how can you make it better.
class MyHashMap:

    def __init__(self):
        self.arr=[-1]*10**7
    
    def put(self, key: int, value: int) -> None:
        
        self.arr[key]=value

    def get(self, key: int) -> int:
        return self.arr[key]

    def remove(self, key: int) -> None:
        self.arr[key]=-1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)