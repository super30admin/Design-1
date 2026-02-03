//Time Complexity: O(1) for all operations
//Space Complexity: O(n) where n is the number of elements in the stack


class MinStack() {

    val stack = mutableListOf<Pair<Int, Int>>()
    var size = 0

    fun push(`val`: Int) {
        val currentMin = if (size == 0) `val` else minOf(stack[size - 1].second, `val`)
        stack.add(Pair(`val`, currentMin))
        size += 1
    }

    fun pop() {
        if (size != 0) {
            stack.removeAt(size - 1)
            size -= 1
        }
    }

    fun top(): Int {
        return stack[size - 1].first
    }

    fun getMin(): Int {
        return stack[size - 1].second
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */