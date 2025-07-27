// Time Complexity :  O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// line 21 check
// min and getMin was also conflicting for kotlin changed to minV
// line number 41 was putting wrong value

class MyHashMap() {

    class Node(val key:Int, var value:Int, var next:Node?)

    private val bucketSize = 1000
    private val storage:Array<Node?> = Array<Node?> (bucketSize){ null }

    private fun getHash(key:Int):Int = key % bucketSize

    private fun getPrev(head:Node?, key:Int ): Node?{
        var prev:Node? = null
        var curr = head
        while(curr != null && curr?.key != key){
            prev = curr
            curr = curr.next
        }
        return prev
    }

    fun put(key: Int, value: Int) {
        val hashedIndex = getHash(key)
        //headNode = storage[hashedIndex]
        if(storage[hashedIndex] == null){
            storage[hashedIndex] = Node(-1, -1, null)//dummy node
            storage[hashedIndex]?.next = Node(key, value, null)
            return
        }
        val prev = getPrev(storage[hashedIndex], key)
        // val curr = prev?.next
        if(prev?.next == null){
            prev?.next = Node(key,value, null)
        }else{
            prev?.next?.value = value
        }
    }

    fun get(key: Int): Int {
        val hashedIndex = getHash(key)
        if(storage[hashedIndex]==null) return -1
        val prev:Node? = getPrev(storage[hashedIndex], key)

        return if(prev?.next != null){
            prev!!.next!!.value
        }else{
            -1
        }
    }

    fun remove(key: Int) {
        val hashedIndex = getHash(key)
        if(storage[hashedIndex] == null){
            return
        }

        val prev = getPrev(storage[hashedIndex], key)

        if(prev?.next == null){
            return
        }else{
            prev?.next = prev?.next?.next
        }
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */