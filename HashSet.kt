//Time complexity: O(1) for add, remove, and contains operations
//Space complexity: O(1) for add, remove, and contains operations for hashSet o(n) where n is the size of the hashSet

class MyHashSet() {

    private val hashSet = Array(1000000) { mutableListOf<Int>() }
    private var size = 0

    private fun hashIndex(key: Int): Int {
        return key % 1000000
    }

    fun add(key: Int) {
        if(!contains(key)) {
            size += 1
            hashSet[hashIndex(key)].add(key)
        }
    }

    fun remove(key: Int) {
        if(contains(key)) {
            size -= 1
            hashSet[hashIndex(key)].remove(key)
        }
    }

    fun contains(key: Int): Boolean {
        return hashSet[hashIndex(key)].contains(key)
    }
}



/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */