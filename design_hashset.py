"""
Approach:

we create a list
list index = key
for each index we store/chain elements using linkedlist using a hash function (modulo)

index  values (as linkedlist nodes)
[0] -> [0,10,20,30...]
[1] -> [1,11,21,31...]
[2] -> [2,12,22,32...]
[3] -> [3,13,23,33...]
.
.
[9] -> [9,99,999,9999]


Time Complexity:
add, contains, remove: O(1) since we access using key

Space Complexity:
O(n) since we created hashset using array
"""


# we use LinkedList to handle collisions using chaining
class ListNode:
    def __init__(self, data, next_node=None):
        self.data = data
        self.next = next_node

class MyHashSet:
    def __init__(self):

        # create a list
        self.set = []

        # create list of size 10**4 and add a dummy ListNode with data 0
        for _ in range(10**4):
            self.set.append(ListNode(0))


    def add(self, key: int) -> None:
        # to add element, first find the index where we will add
        index = self.hash_function(key)

        # convert key to linkedlist to store in that index
        new_node = ListNode(key)

        # find the first node at that index
        current_node = self.set[index]

        # traverse at the end of linkedlist
        while current_node.next:
            # if element already exists in that bucket
            # we used current_node.next.data instead of current_node.data because our first node is a dummy node with value 0
            if current_node.next.data == key:
                return

            current_node = current_node.next

        # now we are at the end of linkedlist and so add element
        current_node.next = new_node


    def contains(self, key: int) -> bool:
        index = self.hash_function(key)
        current_node = self.set[index]

        while current_node.next:
            if current_node.next.data == key:
                return True

            current_node = current_node.next

        return False

    def remove(self, key: int) -> None:
        index = self.hash_function(key)
        current_node = self.set[index]
        
        while current_node.next:
            if current_node.next.data == key:
                #just delete that node using next pointer
                current_node.next = current_node.next.next
                return
            current_node = current_node.next


    # use modulo for hashing
    def hash_function(self, key: int) -> int:
        index = key%len(self.set)
        return index

    def display(self):
        print("Display hashset:")
        for idx, bucket in enumerate(self.set):
            values = []
            current = bucket.next
            while current:
                values.append(current.data)
                current = current.next
            if values:
                print(f"Bucket {idx}: {values}")


def main():
    myHashSet = MyHashSet()
    myHashSet.add(10)
    myHashSet.add(20)
    myHashSet.remove(10)
    print(myHashSet.contains(10))
    myHashSet.add(23)
    myHashSet.add(23)
    myHashSet.display()

if __name__ == "__main__":
    main()