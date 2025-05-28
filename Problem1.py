class MyHashSet:
    def __init__(self):
        self.size=1000
        self.buckets=[[]for _ in range(self.size)]
    
    def _hash(self,key):
        return key%self.size
    
    def add(self,key):
        index=self._hash(key)
        if key not in self.buckets[index]:
            self.buckets[index].append(key)
    
    def remove(self,key):
        index=self._hash(key)
        if key in self.buckets[index]:
            self.buckets[index].remove(key)
    
    def contains(self,key):
        index=self._hash(key)
        return key in self.buckets[index]
    
ops=["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
vals=[[], [1], [2], [1], [3], [2], [2], [2], [2]]

output=[]

my_hash_set=None

for op,val in zip(ops,vals):
    if op=="MyHashSet":
        my_hash_set=MyHashSet()
        output.append("null")
    elif op=="add":
        my_hash_set.add(val[0])
        output.append("null")
    elif op=="remove":
        my_hash_set.remove(val[0])
        output.append("null")
    elif op=="contains":
        result=my_hash_set.contains(val[0])
        output.append("true" if result else "false")

print(output)
