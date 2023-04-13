import math;
class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.hashSet = []
        for i in range(self.buckets + 1):
            self.hashSet.append([])
            for j in range(self.bucketItems + 1):
                self.hashSet[i].append(False)

    def bucket(self, key: int) -> int:
        value = key % self.buckets;
        return value;

    def bucketItem(self, key: int) -> int:
        value = math.floor(key / self.bucketItems);
        return value;

    def add(self, key: int) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
        
        self.hashSet[bucket][bucketItem] = True  
        

    def remove(self, key: int) -> None:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)
       
        self.hashSet[bucket][bucketItem] = False


    def contains(self, key: int) -> bool:
        bucket = self.bucket(key)
        bucketItem = self.bucketItem(key)

        return self.hashSet[bucket][bucketItem] 

#Testcase
# ["MyHashSet","add","add","contains","contains","add","contains","remove","contains"]
# [[],[1],[2],[1],[3],[2],[2],[2],[2]]     