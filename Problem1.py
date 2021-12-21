# Time Complexity : O(1)
# Space Complexity : O(k^2) where k is size of hash table choosen. Here 1000. 
# Did this code successfully run on Leetcode : 27/32 test cases passed.
# Any problem you faced while coding this : Implemented using 2nd hashing technique as taught in class.
class MyHashSet:

    def __init__(self):
        self.set = [None] * 1000 # Choose 1000 as key size is 10^6

    def add(self, key: int) -> None:
        initial_hash_value_position = key % 1000 # position to insert the key
        if(self.set[initial_hash_value_position] == None):
            self.set[initial_hash_value_position] = key
        elif type(self.set[initial_hash_value_position]) == list: # in case of collision.
            new_second_hash_temp = key // 1000
            self.set[initial_hash_value_position][new_second_hash_temp] = key
        else: # in case of 1st collision.
            temp = self.set[initial_hash_value_position]
            self.set[initial_hash_value_position] = [None] * 1000
            second_hash_temp = temp // 1000
            self.set[initial_hash_value_position][second_hash_temp] = temp
            new_second_hash_temp = key // 1000
            self.set[initial_hash_value_position][new_second_hash_temp] = key
        
    def remove(self, key: int) -> None:
        hash_position = key % 1000
        if hash_position == None:
            return
        else:
            if type(self.set[hash_position]) != list:
                self.set[hash_position] = None
            else:
                second_hash_map_key = key // 1000
                self.set[hash_position][second_hash_map_key] = None

    def contains(self, key: int) -> bool:
        hash_position = key % 1000
        if hash_position == None:
            return False
        else:
            if type(self.set[hash_position]) != list:
                if self.set[hash_position] == key:
                    return True
                else:
                    return False
            else:
                second_hash_map_key = key // 1000
                if(self.set[hash_position][second_hash_map_key]== key):
                    return True
                else:
                    return False
                

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
