class MyHashSet:

    def __init__(self):
        self.hass = [None] * 1000
        self.plength = 1000
        self.selength = 1000

    def has1(self, key):
        return key % self.plength

    def has2(self, key):
        return key // self.selength

    def add(self, key: int) -> None:
        val1 = self.has1(key)
        val2 = self.has2(key)

        if self.hass[val1] is None:
            if val1 == 0:
                self.hass[val1] = [False] * (self.selength + 1)
            else:
                self.hass[val1] = [False] * self.selength
        self.hass[val1][val2] = True

    def remove(self, key: int) -> None:
        val1 = self.has1(key)
        val2 = self.has2(key)

        if self.hass[val1] is None:
            return
        else:
            self.hass[val1][val2] = False

    def contains(self, key: int) -> bool:
        val1 = self.has1(key)
        val2 = self.has2(key)

        if self.hass[val1] is None:
            return False
        return self.hass[val1][val2]