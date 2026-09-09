'''
https://leetcode.com/problems/design-hashset/

Time Complexity :

- add
- remove
- contains

Space Complexity :

O(n) where n is the maximum possible amount of values

Did this code successfully run on Leetcode :

Conceptual Approach:

In this case I am going to attempt to design a hash set using double hashing. The idea behind double hashing is that we want to map a single key
into our 2 dimensional data structure. The point of having a 2D data structure is to still guarantee constant search time, but also having the
ability to save space.

We will also use the data type of Boolean since the key itself really is the value and this will allows to save even more space! It's a good idea
to use the nearest square dimensions as this is the most balanced approach for saving memory (i.e. the less indices we have in the first data structure,
the more likely we are to have to create the second array anyways) and vice versa

So the hashing functions will be:

- num / 10^3
- num % 10^3

Our first data structure really contains the lists
And the second data structure is the entires

Edge Cases:

- add
Make sure it doesn't already exist

- remove
If it doesn't exist do nothing

- One of the indices will have more than 1000 elements, because we have total of 1,000,001 keys - based upon your hashing functions this would be index 0 as the value 0
would exist at index 0 as value 0 would be at index 0, and value 999 would be at index 999 for a total of 1000 elements, right?

This logic is not correct, resolve it.

No you doofus, the extra value is 1,000,000, and the first hash is equal to 1000, right? Doesn't this mean it falls off the end? How does that work?

With my current design that would be the case - but I remember Jaspinder had a clever way for resolving this, because I noticed this during class. Somehow
He placed this value at index 0, was it truly just hardcoded? Well let's give that a. try and place it at index 0 such that there are 1001 elements there.

Constraints:
Always break down the constraints and understand if we are being given hints or if this will materially alter our design

- 0 <= key <= 10^6
- At most 10^4 calls will be made to add, remove, and contains
This is a hint that we can preserve space by intelligently selecting the dimensionality of each layer of our data structure

Any problem you faced while coding this:
- The edge case around value 1,000,000. I had put custom logic in the wrong place, when I should have just appropriately sized it in the add
function where the creation happens.
'''
class MyHashSet:
    def _first_hash(self, key):
        return key % self.max_elements

    def _second_hash(self, key):
        return key // self.max_elements

    def __init__(self):
        self.max_elements = 1000
        self.lists = [ None ] * self.max_elements
        self.max_value = 1000000

    def add(self, key: int) -> None:
        first_hash = self._first_hash(key)

        # If the list doesn't exist, create it
        if self.lists[first_hash] is None:
            size = self.max_elements + 1 if first_hash == 0 else self.max_elements
            self.lists[first_hash] = [ False ] * size

        second_hash = self._second_hash(key)

        self.lists[first_hash][second_hash] = True

    def remove(self, key: int) -> None:
        first_hash = self._first_hash(key)

        # If the list doesn't exist - don't do anything
        if self.lists[first_hash] is None:
            return
        second_hash = self._second_hash(key)
        self.lists[first_hash][second_hash] = False

    def contains(self, key: int) -> bool:
        first_hash = self._first_hash(key)
        # First check if the list exists
        if self.lists[first_hash] is None:
            return False

        # If it does we can check if the value exists
        second_hash = self._second_hash(key)
        return self.lists[first_hash][second_hash]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)