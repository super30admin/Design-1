// Time Complexity: O(1) on average for add, remove, and contains operations
// Space Complexity: O(n) where n is the number of unique elements added to the set
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashSet() {

    val arraySize = 1000
    val buckets: Array<MutableList<Int>> = Array(arraySize) { mutableListOf<Int>() }

    fun hash(key: Int) : Int {
        return key % arraySize
    }

    fun add(key: Int) {
        val index = hash(key)
        
        if(!buckets[index].contains(key)) {
            buckets[index].add(key)
        }
    }

    fun remove(key: Int) {
        val index = hash(key)
        buckets[index].remove(key)
    }

    fun contains(key: Int): Boolean {
        val index = hash(key)
        return buckets[index].contains(key)
    }
}

 fun main() {
    var obj = MyHashSet()
    obj.add(89)
    obj.add(122323)
    obj.add(2)
    obj.remove(122323)
    obj.remove(12)
    println(obj.contains(89))
 }