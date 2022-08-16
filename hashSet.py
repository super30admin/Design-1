class MyHashSet:
    BUCKET = 1000

    def __init__(self):
        self.map = [[] for _ in range(MyHashSet.BUCKET)]
        

    def add(self, key: int) -> None:
        i = key % MyHashSet.BUCKET
        if key in self.map[i]:
            return None
        else:
            self.map[i].append(key)
        

    def remove(self, key: int) -> None:
        i = key% MyHashSet.BUCKET
        if key in self.map[i]:
            del self.map[i][self.map[i].index(key)]
        else:
            return
        

    def contains(self, key: int) -> bool:
        i = key% MyHashSet.BUCKET
        if key in self.map[i]:
            return True
        return False