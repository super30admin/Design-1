# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : A little on understanding how to implement the put funtion, but later it was all okay.

# Your code here along with comments explaining your approach

class MyHashMap:

    def __init__(self):
        # create an initial array of size 1000 as a bucket
        self.bucket = [0]*1000

    def put(self, key: int, value: int) -> None:
        # calculate the hashvalue
        keytosearch = key % 1000
        new_key = key // 1000

        # checking if the key is present in the first array, if not then create a new array and assign value to it
        if self.bucket[keytosearch] == 0:
            # assign one extra element in order to avoid collision if the index is 0
            if keytosearch != 0:
                bucket_one = [-1]*1000
            else:
                bucket_one = [-1]*1001

            # assigning value using double hashing technique
            bucket_one[new_key] = value
            self.bucket[keytosearch] = bucket_one

        else:
            # updating the new value with the old value
            bucket_one = self.bucket[keytosearch]
            bucket_one[new_key] = value

    def get(self, key: int) -> int:
        # calculate the hashvalue
        keytosearch = key % 1000
        new_key = key // 1000

       # return -1 if there is no second array
        if self.bucket[keytosearch] == 0:
            return -1
        # else, return value in second array 
        else:
            bucket_one = self.bucket[keytosearch]
            return bucket_one[new_key]

    def remove(self, key: int) -> None:
        # calculate the hashvalue
        keytosearch = key % 1000
        new_key = key // 1000

        # if exists, then update the value in second array
        if self.bucket[keytosearch] != 0:
            bucket_one = self.bucket[keytosearch]
            bucket_one[new_key] = -1


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
