//
//  MinStack.swift
//  coding-swift
//
//  Created by Alagu Karthikprabhu on 5/25/20.
//  Copyright © 2020 kpalagu. All rights reserved.
//

// Time Complexity : (O)1
// Space Complexity : (O)n
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
// Create two stack to maintain min stack
// first stack contain the input value. second minimum stack will insert the mimimum value of last element


import Foundation

class MinStack {

    var stack = [Int]()
    var minStack = [Int]()
    
    /** initialize your data structure here. */
    init() {
        
    }
    func addToMinStack(_ x: Int) {
        if minStack.isEmpty {
            minStack.append(x)
        }else if x <= minStack.last! {
            minStack.append(x)
        }
    }
    func push(_ x: Int) {
        stack.append(x)
        addToMinStack(x)
    }
    
    func pop() {
        if !minStack.isEmpty && !stack.isEmpty && minStack.last! == stack.last! {
            minStack.removeLast()
        }
        if !stack.isEmpty {
            stack.removeLast()
        }
    }
    
    func top() -> Int {
        return stack.isEmpty ? -1 : stack.last!
    }
    
    func getMin() -> Int {
        return minStack.isEmpty ? -1 : minStack.last!
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * let obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * let ret_3: Int = obj.top()
 * let ret_4: Int = obj.getMin()
 */
