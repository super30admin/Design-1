#Time Complexity = add: O(1), remove: O(1), contains: O(n)
#Space Complexity = add: O(1), remove: O(1), contains: O(1)
class MyHashSet:
    #Declare a bucket of a large size to handle larger capacity of data
    BUCKET = 1000

    def __init__(self):
        #declare a map with the global BUCKEt
        self.map = [[] for _ in range(MyHashSet.BUCKET)]
        

    def add(self, key: int) -> None:
        #Add the key towards the index which is modulo of key and bucket and return none if there is a collission or else add it into the array
        i = key % MyHashSet.BUCKET
        if key in self.map[i]:
            return None
        else:
            self.map[i].append(key)
        

    def remove(self, key: int) -> None:
        #if the key is found remove the element key at ith index
        i = key% MyHashSet.BUCKET
        if key in self.map[i]:
            del self.map[i][self.map[i].index(key)]
        else:
            return
        

    def contains(self, key: int) -> bool:
        #return true if the array holds value at key
        i = key% MyHashSet.BUCKET
        if key in self.map[i]:
            return True
        return False