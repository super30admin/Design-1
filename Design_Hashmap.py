#Time Complexity: O(1) for searching and inserting for the range(0,10^6)
#Space Complexity: O(n)
#Working on LeetCode: Yes

class MyHashMap:
    def __init__(self):
        self.hash_table = [None]*(10**6+1)
    
    def put(self, key, value):
        self.hash_table[key] = value
    
    def get(self, key):
        if self.hash_table[key] is not None:
            return self.hash_table[key]
        return -1
    
    def remove(self, key):
        if self.hash_table[key] is not None:
            self.hash_table[key] = None
        return -1


if __name__ == "__main__":
    hash_obj = MyHashMap()
    hash_obj.put(1,1)
    hash_obj.put(2,2)
    hash_obj.put(3,3)
    hash_obj.put(3,2)
    print(hash_obj.get(3))
    hash_obj.remove(3)
