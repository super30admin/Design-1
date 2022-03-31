class MyHashMap:

    def __init__(self):
        self.map = {}
        

    def put(self, key: int, value: int) -> None:
        self.map[key] = value
        

    def get(self, key: int) -> int:
        if key in self.map:
            return self.map[key]
        return -1
            
    def remove(self, key: int) -> None:
         if key in self.map:
                del self.map[key]