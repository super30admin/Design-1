#I am using the first list to store if the hash is present or not
# I am using another list to store all the elements for each of the hash



class MyHashSet:

    def __init__(self):
        self.size=1000
        self.buckets=[None] * self.size
        

    def add(self, key: int) -> None:
        index= key%self.size
        if self.buckets[index] is None:
            self.buckets[index]=[]
        if key not in self.buckets[index]:
            self.buckets[index].append(key)
        

    def remove(self, key: int) -> None:
        index= key%self.size
        if self.buckets[index] is not None and key in self.buckets[index]:
            self.buckets[index].remove(key)
        

    def contains(self, key: int) -> bool:
         index= key%self.size
         return self.buckets[index]!=None and key in self.buckets[index]
