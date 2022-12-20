class MyHashSet:

    def __init__(self):
        self.arr = collections.defaultdict(int)
        

    def add(self, key: int) -> None:
        if not self.arr[key]:
            self.arr[key] = True
        

    def remove(self, key: int) -> None:
        if self.arr[key]:
            self.arr[key]=False
        

    def contains(self, key: int) -> bool:
        if self.arr[key]:
            return True
        else:
            return False