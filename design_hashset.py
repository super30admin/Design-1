class MyHashSet:



  def __init__(self):
    self.primary_buckets = 1000
    self.secondary_buckets = 1001
    self.storage = [None] * self.primary_buckets


  def primary_hash(self, key)-> int:
    return key % self.primary_buckets


  def secondary_hash(self, key)-> int:
    return key // self.secondary_buckets

  def add(self, key)-> None:
    primary_index = self.primary_hash(key)
    secondary_index =self.secondary_hash(key)

    if self.storage[primary_index]==None:
      self.storage[primary_index] = [False] * self.secondary_buckets
      self.storage[primary_index][secondary_index] = True

    else:
      self.storage[primary_index][secondary_index] = True

  def remove(self, key) -> None:
    primary_index = self.primary_hash(key)
    secondary_index = self.secondary_hash(key)
    if self.storage[primary_index]!=None:
      self.storage[primary_index][secondary_index] = False


  def contains(self, key) -> bool:
    primary_index = self.primary_hash(key)
    secondary_index = self.secondary_hash(key)
    if self.storage[primary_index]!=None:
      return self.storage[primary_index][secondary_index]==True
    return False





