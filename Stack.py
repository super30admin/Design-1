# Time Complexity :O(1)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Did not pass one test case. I was not able to find the reason.
#Any problem you faced while coding this : I feel like something might be wrong in push() function. That might be the reason why it didnt pass all the test cases in leet code.

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
