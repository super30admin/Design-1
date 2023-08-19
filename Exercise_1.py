#Time Complexity : push - O(1), pop-O(1), top-O(1), getMin-O(1)
#The code creates a hashset with functions hash_fun1, hash_fun2 that return the hash value for the bucket.
#The function add adds the key by getting the bucket_index and bucket_item_index. Similarly contains checks if the key is available and remove deletes the key from the respective position in the bucket.
class MiHashSet:
    def __init__(self):
        # variable for size of storage
        self.size = 1000
        # creating storage buckets for hashset - primary array
        self.storage = [None] * self.size

    # hash function for getting bucket index in array
    def hash_fun1(self, key):
        return key % 1000

    # hash function for getting bucket item index in secondary array
    def hash_fun2(self, key):
        return key % 1000

    def add(self, key):
        # getting primary array index
        bucket_index = self.hash_fun1(key)
        # getting secondary array index
        bucket_item_index = self.hash_fun2(key)
        # checking if secondary array present yet
        if self.storage[bucket_index] is None:
            # HANDLING INDEX OUT OF BOUNDS
            if bucket_index == 0:
                self.storage[bucket_index] = [False] * (self.size + 1)
            else:
                self.storage[bucket_index] = [False] * (self.size)
        self.storage[bucket_index][bucket_item_index] = True

    def contains(self, key):
        # getting primary array index
        bucket_index = self.hash_fun1(key)
        # getting secondary array index
        bucket_item_index = self.hash_fun2(key)
        # checking if secondary array present yet
        if self.storage[bucket_index] is None:
            return False
        return self.storage[bucket_index][bucket_item_index]

    def remove(self, key):
        # getting primary array index
        bucket_index = self.hash_fun1(key)
        # getting secondary array index
        bucket_item_index = self.hash_fun2(key)
        # checking if secondary array present yet
        if self.storage[bucket_index] is None:
            return
        # Removing key
        self.storage[bucket_index][bucket_item_index] = False
