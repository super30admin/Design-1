class MyHashSet(object):

    def __init__(self):  # constructor
        # Step 1: Define number of buckets. Using a prime number reduces collisions.
        self.size = 769
        # Step 2: Initialize list of buckets. Each bucket is a list for chaining.
        self.buckets = [[] for _ in range(self.size)]

    def _hash(self, key):
        # Step 3: Hash function to map key to a bucket index.
        return key % self.size  # distributes the keys across the array

    def add(self, key):
        # Step 4: Compute the bucket index for the given key.
        hash_key = self._hash(key)
        bucket = self.buckets[hash_key]
        # Step 5: Only add the key if it is not already present to avoid duplicates.
        if key not in bucket:
            bucket.append(key)  # adds the key to the bucket

    def remove(self, key):
        # Step 6: Compute the bucket index for the key.
        hash_key = self._hash(key)
        bucket = self.buckets[hash_key]
        # Step 7: If the key exists in the bucket, remove it.
        if key in bucket:
            bucket.remove(key)

    def contains(self, key):
        # Step 8: Check if the key exists in the bucket.
        hash_key = self._hash(key)
        bucket = self.buckets[hash_key]
        return key in bucket
    
# Simulating the input and printing the output
ops = ["MyHashSet","add","add","contains","contains","add","contains","remove","contains"]
args = [[], [1], [2], [1], [3], [2], [2], [2], [2]]

output = []
obj = None

for op, arg in zip(ops, args):
    if op == "MyHashSet":
        obj = MyHashSet()
        output.append(None)
    elif op == "add":
        obj.add(arg[0])
        output.append(None)
    elif op == "remove":
        obj.remove(arg[0])
        output.append(None)
    elif op == "contains":
        result = obj.contains(arg[0])
        output.append(result)
print(output)