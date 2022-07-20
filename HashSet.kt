// Time Complexity : getHash1() - O(1), getHash2() - O(1), add()- O(1), remove - O(1), contains - O(1),  self.hashMatrix - O(n^2)
// Space Complexity : o(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I see it takes more space, can you suggest what else I can do to reduce it.

class MyHashSet() {

    var size = 1000

    var hashSet = Array(1000) { BooleanArray(1001){ false } }

    fun getHash1(value: Int): Int{
        return value % size
    }

    fun getHash2(value: Int): Int{
        return value / size
    }


    fun add(key: Int) {
        val hashKey = getHash1(key)
        val hashKey2 = getHash2(key)
        hashSet[hashKey][hashKey2] = true
    }

    fun remove(key: Int) {
        val hashKey = getHash1(key)
        val hashKey2 = getHash2(key)
        hashSet[hashKey][hashKey2] = false
    }

    fun contains(key: Int): Boolean {
        val hashKey = getHash1(key)
        val hashKey2 = getHash2(key)
        return  hashSet[hashKey][hashKey2]
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */