class MyHashSet:

    def __init__(self):
        # Initializing list and making all vals as -1
        self.l = [-1 for _ in range(1000000)]

    def put(self, key: int, value: int) -> None:
        # Adds the Key, value
        self.l[key] = value

    def remove(self, key: int) -> None:
        self.l[key] = -1

    def get(self, key: int) -> bool:
        return self.l[key]

