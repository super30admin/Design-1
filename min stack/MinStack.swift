//
//  ImplementMinStack.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 12/24/25.
//

//Min stack - supports push, pop, top and retrieving the minimum element in constant time.

class MinStack {
    
    var stack: StackUsingLL<Int> = StackUsingLL<Int>(llList: LLLinkedList())
   
    /*
     Min stack maintains 1:1 mapping with the main element and the minimum element.
     At the 4th push to the stack, min stack contains the minimum at the 4th index in all elements present at 0 to 4th index.
     Either we cna maintain a min stack or can store a tuple in the main stack. Pair(current element, current minimum)
     */
    var minStack: StackUsingLL<Int> = StackUsingLL<Int>(llList: LLLinkedList())

    private var currentMin: Int
    
    init() {
        self.currentMin = Int.max
        self.minStack.push(value: self.currentMin)
    }
   
    
    //it will pop the top element
    func pop() -> Int? {
        if (!stack.isEmpty()) {
            let topElement = stack.pop()!
            let _ = minStack.pop()
            currentMin = minStack.peek()!
            return topElement
        }
        return nil
    }
    
    //it will push the element
    func push(val: Int) {
        let minimum = min(currentMin, val)
        stack.push(value: val)
        minStack.push(value: minimum)
    }
    
    //it will return the top element
    func top() -> Int? {
        return stack.peek()
    }
    
    //it will return the min element in the stack
    func getMin() -> Int {
        return currentMin
        //or can return minStack.peek()
    }
}

class ImplementMinStack {
    
    //Implement this stack using linked list because push and pop can happen in O(1) time cmplexity.
    //Take 1 stack to keep min items.
    
    init() {
        let items: [Any] = [12, 8, 10, 1, 2, "P", "P", 3, "P", "P", "P"]
        
        let minStack =  MinStack()
        for item in items {
            if (item is Int) {
                minStack.push(val: item as! Int)
            } else {
                let removedElement = minStack.pop()
                print("removedElement \(String(describing: removedElement))")
            }
        }
    }
}
