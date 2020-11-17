class MyHashMap(dict):
    def __init__(l):
        l=dict()        

    def put(l, key, value):
        l[key]=value
        

    def get(l, key):
        for k,v in l.items():
            if key==k:
                return l[key]
        return -1        

    def remove(l, key):
        if key in l.keys():
            l.pop(key)
    

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)