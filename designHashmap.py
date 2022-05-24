# Time Complexity, Put: O(1), Get:O(n), Remove: O(1)
#Space complexity: O(n)
class MyHashMap:

    def __init__(self):
        self.hashMap={}

    def put(self, key: int, value: int) -> None:
        self.hashMap[key]=value
        print('Put:',self.hashMap)

    def get(self, key: int) -> int:
        if key in self.hashMap:
            print('get value for key {}: {}'.format(key, self.hashMap[key]))
            return self.hashMap[key]
        else:
            print('Key not found:', -1)
            return -1

    def remove(self, key: int) -> None:
        if key in self.hashMap:
            self.hashMap.pop(key)
        print('popped:', key)
# ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
# [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]

hp=MyHashMap()
hp.put(1,1)
hp.put(2,2)
hp.get(1)
hp.get(3)
hp.put(2,1)
hp.get(2)
hp.remove(2)
hp.get(2)