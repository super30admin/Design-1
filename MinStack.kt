// Time Complexity: O(1) on average
// Space Complexity: O(capacity) where n is the number of elements

class MinStack() {

    private val capacity: Int = 1_000_000
    private val stack = IntArray(capacity)
    
    private val mins = IntArray(capacity)

    private var top = -1
    
    fun push(`val`: Int) {
        if (top == capacity - 1) {
            throw StackOverflowError("Stack overflow: capacity=$capacity")
        }
        stack[++top] = `val`
        mins[top] = if (top == 0) `val` else minOf(`val`, mins[top - 1])
    }

    fun pop() {
        if (top == -1) {
            throw NoSuchElementException("Stack underflow: empty stack")
        }
        top--
    }

    fun top(): Int {
        return stack[top]
    }

    fun getMin(): Int {
        return mins[top]
    }
}

fun main() {
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin()) // return -3
    minStack.pop()
    println(minStack.top())    // return 0
    println(minStack.getMin()) // return -2
}
