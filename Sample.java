// Time Complexity : 0(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  


// Your code here along with comments explaining your approach
class MinStack {

    /** initialize your data structure here. */
    var stack: [Int]
    var minArray : [Int]
    init() {
        stack = [Int]()
        minArray = [Int]()
    }
    
    func push(_ val: Int) {
        stack.append(val)
        if let minValue = minArray.last {
            if val < minValue {
                minArray.append(val)
            } else {
                minArray.append(minValue)
            }
        } else {
            minArray.append(val)
        }
    }
    
    func pop() {
       stack.removeLast()
        minArray.removeLast()
    }
    
    func top() -> Int {
        return stack[stack.count-1]
    }
    
    func getMin() -> Int {
        return minArray[minArray.count-1]
    }
}
