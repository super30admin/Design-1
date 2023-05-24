class MinStack:
    def __init__(self):
        self.array = []
        self.counter = 0
        self.minimum = None

    def push(self, val: int) -> None:

        if self.counter == 0:
            self.array.append(val)
            self.minimum = val
            self.counter += 1
        elif self.minimum > val:
            buffer = (2 * val) - self.minimum
            self.minimum = val
            self.array.append(buffer)
            self.counter += 1

        else:
            self.array.append(val)
            self.counter += 1

    def pop(self) -> None:
        if len(self.array) == 0:
            print("Array is empty")
        else:
            removing_element = self.array[self.counter - 1]
            if removing_element < self.minimum:
                self.minimum = (2 * self.minimum) - removing_element
            self.array = self.array[0:self.counter - 1]
            self.counter -= 1

    def top(self) -> int:
        return self.array[self.counter - 1]

    def getMin(self) -> int:
        return self.minimum
