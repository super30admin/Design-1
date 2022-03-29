class MyHashMap:

    def __init__(self):
        self.hashMap = [-1 for _ in range(1000001)]
    

    def put(self, key: int, value: int) -> None:
        self.hashMap[key] = value
        

    def get(self, key: int) -> int:
        return self.hashMap[key]
        

    def remove(self, key: int) -> None:
        self.hashMap[key] = -1
        