// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes but I have written it in Python
// Any problem you faced while coding this :

//Code in Python
class MyHashSet:

    def __init__(self):
        self.size = 100
        self.hashset = [[] for _ in range(self.size)]

    def add(self, key: int) -> None:
        hashed_key = hash(key)%self.size
        bucket = self.hashset[hashed_key]
        found_key = False
        for index, record in enumerate(bucket):
            record_key = record
            if record_key == key:
                found_key = True
                break
        if found_key:
            bucket[index] = key
        else:
            bucket.append(key)

    def remove(self, key: int) -> None:
        hashed_key = hash(key)%self.size
        bucket = self.hashset[hashed_key]
        found_key = False
        for index, record in enumerate(bucket):
            record_key = record
            if record_key == key:
                found_key = True
                break
        if found_key:
            del bucket[index]
        
    def contains(self, key: int) -> bool:
        hashed_key = hash(key)%self.size
        bucket = self.hashset[hashed_key]
        found_key = False
        for index, record in enumerate(bucket):
            record_key = record
            if record_key == key:
                found_key = True
                break
        if found_key:
            return True
        else:
            return False
