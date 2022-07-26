import java.lang.Integer.min

class MinStack {

    var stack: ArrayList<Pair<Int, Int>> = arrayListOf()

    fun push(x: Int) {
        if (stack.size == 0) {
            stack.add(Pair(x, x))
        } else {
            val min = getMin()
            min?.let {
                stack.add(Pair(x, min(x, min)))
            }
        }
    }

    fun pop(): Pair<Int, Int>? {
//        return stack.removeLast()
        return stack.removeAt(stack.size - 1)
    }

    fun top(): Int? {
        return stack.lastOrNull()?.first
    }

    fun getMin(): Int? {

        return stack.lastOrNull()?.second

    }

}