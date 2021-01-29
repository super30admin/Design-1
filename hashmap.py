class Node:

    def __init__(self, key, value ):

        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.max_length = 1000000
        self.array = [ None ] * self.max_length

    def find_hash( self, key: int ):
        return key % self.max_length

    def find_previous_node( self, key , index ):

        if self.array[ index ] == None :

            self.array[ index ] = Node( -1, -1 )
            return self.array[ index ]

        else:

            prev = self.array[ index ]

            while ( prev.next is not None and prev.next.key != key ):
                prev = prev.next

            return prev


    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """

        # Calculate the value of the key index ( hashing )
        index = self.find_hash( key )
        prev = self.find_previous_node( key , index )

        # This key was not already present so create a new node with
        # this value
        if ( prev.next == None ):
            prev.next = Node( key , value )
        # Update the value of this node with the new value
        else:
            prev.next.value = value



    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """

        # Calculate the value of the key index ( hashing )
        index = self.find_hash( key )
        prev = self.find_previous_node( key , index )

        if ( prev.next == None ):

            return -1
        else:
            return prev.next.value


    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """

        # Calculate the value of the key index ( hashing )
        index = self.find_hash( key )
        prev = self.find_previous_node( key , index )

        if ( prev.next != None ):
            prev.next = prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
