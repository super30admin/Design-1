"""
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approachclass MyHashMap(object):
"""
    def __init__(self):
        """
        Initialize your data structure here.
        """
        buckets = 5000
        self.buckets = [[] for _ in range(buckets)]
        self.hash_fn = lambda k: k%buckets

        
    def _get_bucket_from_key(self, key):
        bucket = self.buckets[self.hash_fn(key)]
        index = -1
        for i in range(len(bucket)):
            if bucket[i][0] == key:
                index = i
            break
        return bucket, index

    def put(self, key, value):
        bucket, index = self._get_bucket_from_key(key)
        if index == -1:
            bucket.append([key, value])
        else:
            bucket[index][1] = value

    def get(self, key):
        bucket, index = self._get_bucket_from_key(key)
        if index == -1:
            return -1
        return bucket[index][1]

    def remove(self, key):
        bucket, index = self._get_bucket_from_key(key)
        if index != -1:
            bucket[index], bucket[-1] = bucket[-1], bucket[index]
        bucket.pop()        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
