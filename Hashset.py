class MyHashSet:
    arr = []
    def __init__(self):
        self.arr = [[False] * 1000] * 1000
        self.arr[0] = [False] * 1001

    def add(self, key: int) -> None:
        # Double Hashing
        index1 = key % len(self.arr)
        index2 = int (key / len(self.arr[index1]))
        self.arr[index1][index2] = True
        
        # while self.arr[index] == True:
        #     index += 1
        # self.arr[index] = key
        
        # chaining
        # inintiate a linkedList at the collision index (not that effective)
        # initiate a BST there (better, not the best!)
        
        # Double Hashing
 
    def remove(self, key: int) -> None:
        index1 = key % len(self.arr)
        index2 = int(key / len(self.arr[index1]))
        self.arr[index1][index2] = False
        
    def contains(self, key: int) -> bool:
        index1 = key % len(self.arr)
        index2 = int (key / len(self.arr[index1]))
        if self.arr[index1][index2] == True:
            print (True)
        else:
            print (False)


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(5)
obj.add(1000000)
obj.contains(5)
obj.remove(5)
obj.contains(5)

# param_3 = obj.contains(key)