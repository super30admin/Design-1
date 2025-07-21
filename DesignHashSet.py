class MyHashSet:

    def __init__(self):
        self.p_size = 1000
        self.s_size = 1000
        self.array = [None] * self.p_size

    def p_hash(self, key):
        return key % self.p_size

    def s_hash(self, key):
        return key // self.s_size

    def add(self, key: int) -> None:
        p_index = self.p_hash(key)
        s_index = self.s_hash(key)

        if self.array[p_index] == None:
            if p_index == 0:
                self.array[p_index] = [None] * (self.s_size + 1) # adding 1 so that we can also store if there is key with value 1,000,000
            else:
                self.array[p_index] = [None] * self.s_size # we can take none here instead of boolean in order tosave space ?

        # adding value to the final index    
        self.array[p_index][s_index] = True

    def remove(self, key: int) -> None:
        p_index = self.p_hash(key)
        s_index = self.s_hash(key)

        # handling invalid case
        if self.array[p_index] == None:
            return None
        
        # removing value from final index
        self.array[p_index][s_index] = None

    def contains(self, key: int) -> bool:
        p_index = self.p_hash(key)
        s_index = self.s_hash(key)

        # handling invalid case
        if self.array[p_index] == None:
            return False

        # checking and returning the value at the final index
        if self.array[p_index][s_index] == None:
            return False
        else:
            return True


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)