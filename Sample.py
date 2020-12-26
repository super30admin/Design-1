class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        # self.arr = [-1 for i in range(1000000)]
        self.bucketitems = 1000
        self.buckets = [-1]*self.bucketitems
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        assert type(key) == int
        assert type(value) == int
        
        indx = key%self.bucketitems
        
        # Fill when empty (or -1 here as in constructor)
        if self.buckets[indx] == -1:
            self.buckets[indx] = [[key, value]] # k, v pair
            
        for i, v in enumerate(self.buckets[indx]):
            if v[0] == key:
                self.buckets[indx][i][1] = value
        
        self.buckets[indx].append([key, value])
        # self.arr[key] = value # Brute force way

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, 
        or -1 if this map contains no mapping for the key
        """
        indx = key%self.bucketitems
        
        if self.buckets[indx] == -1:
            return -1
        
        for k, v in self.buckets[indx]:
            if k == key:
                return v
        
        return -1
        
        # return self.arr[key]


    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key 
        if this map contains a mapping for the key
        """
        # self.arr[key] = -1
        
        indx = key%self.bucketitems
        indx_remove = -1
        if self.buckets[indx] == -1:
            return 
        
        for i, kvpair in enumerate(self.buckets[indx]):
            if kvpair[0] == key:
                indx_remove = i
                break
        
        if indx_remove == -1:
            return
        else:
            del self.buckets[indx][indx_remove]

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)


class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        import math
        self.min = math.inf
        self.stack = []

    def push(self, x: int) -> None:
        if x <= self.min:
            self.stack.append(self.min)
            self.min = x
        self.stack.append(x)

    def pop(self) -> None:
        item = self.stack[-1]
        self.stack.pop()
        if self.min == item:
            self.min = self.stack[-1]
            self.stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()