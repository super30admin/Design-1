class MyHashSet:

    def __init__(self):
        self.hs=[]
        

    def add(self, key: int) -> None:
        if key not in self.hs:
            self.hs.append(key)
        

    def remove(self, key: int) -> None:
        if key in self.hs:
            self.hs.remove(key)
        

    def contains(self, key: int) -> bool:
        return (key in self.hs)