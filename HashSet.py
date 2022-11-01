class MyHashSet:
    
    """
    add method time complexity - O(1), space complexity worst case- O(10^6)
    remove method time complexity - O(1)
    contains method time complexity - O(1)
    get_hash method time complexity - O(1)
    get_second_hash time complexity - O(1)
    """

    def __init__(self):
        self.list = [-1 for x in range(0,1000)]
        self.size = 1000
        

    def add(self, key: int) -> None:
        hash_index = self.get_hash(key)
        if hash_index == 0 and self.list[hash_index] == -1:
            self.list[hash_index] = [-1 for x in range(0,1001)]
        elif self.list[hash_index] == -1:
            self.list[hash_index] = [-1 for x in range(0,1000)]
        second_hash_index = self.get_second_hash(key)
        self.list[hash_index][second_hash_index] = key


    def remove(self, key: int) -> None:
        hash_index = self.get_hash(key)
        if self.list[hash_index] != -1:
            second_hash_index = self.get_second_hash(key)
            self.list[hash_index][second_hash_index] = -1
                
        

    def contains(self, key: int) -> bool:
        hash_index = self.get_hash(key)
        if self.list[hash_index] == -1:
            return False
        second_hash_index = self.get_second_hash(key)
        # can store True/False instead of key
        if self.list[hash_index][second_hash_index] == key:
            return True
        return False

    
    def get_hash(self, key):
        return key % self.size
    
    def get_second_hash(self, key):
        return key // self.size
        
        