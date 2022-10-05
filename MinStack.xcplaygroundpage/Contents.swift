// Time complexity O(1)
// Space complexity O(2n)

class MinStack {
    private var min: Int
    private var stack: Stack
    
    init() {
        min = Int.max
        stack = Stack()
    }
    
    func push(_ val: Int) {
        if val <= min{
            self.stack.push(min)
            min = val
        }
        self.stack.push(val)
    }
    
    func pop() {
        if self.top() == min {
            self.stack.pop()
            min = self.top()
        }
        stack.pop()
    }
    
    func top() -> Int {
        return stack.peek()
    }
    
    func getMin() -> Int {
        return min
    }
}

class Stack {
    var stack:[Int]
    
    init() {
        self.stack = []
    }
    
    func push(_ value: Int) {
        self.stack.insert(value,at:0)
    }
    
    func pop() -> Int {
        return self.stack.removeFirst()
    }
    
    func peek() -> Int {
        return self.stack.first ?? 0
    }
   
    func isEmpty() -> Bool {
        return self.stack.isEmpty
    }
    
    func printStack() {
        print(self.stack)
    }
}

let obj = MinStack()
obj.push(10)
obj.pop()
let ret_3: Int = obj.top()
let ret_4: Int = obj.getMin()
