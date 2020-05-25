//
//  MyHashMap.swift
//  coding-swift
//
//  Created by Alagu Karthikprabhu on 5/25/20.
//  Copyright © 2020 kpalagu. All rights reserved.
//

// Time Complexity : (O)N
// Space Complexity : (O)N
// Did this code successfully run on Leetcode : No Timelimit exceeded
// Any problem you faced while coding this : No but not able to get the logic with (O)1


// Your code here along with comments explaining your approach
// Create a new class called Node to hold key and value
// created array of nodes to keep map
// search array to find the key node to put, remove and get


import Foundation

class MyHashMap {
    
    class Node {
        var key: Int
        var value: Int
        
        init(key: Int, value: Int) {
            self.key = key
            self.value = value
        }
    }
    
    var map: [Node]!
    
    /** Initialize your data structure here. */
    init() {
        map = [Node]()
    }
    
    /** value will always be non-negative. */
    func put(_ key: Int, _ value: Int) {
        if let node = map.first(where: { $0.key == key }) {
            node.value = value
            return
        }
        map.append(Node(key:key, value:value))
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    func get(_ key: Int) -> Int {
        if let node = map.first(where: { $0.key == key }) {
            return node.value
        }
        return -1
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    func remove(_ key: Int) {
        if let index = map.firstIndex(where: { $0.key == key }) {
          map.remove(at: index)
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * let obj = MyHashMap()
 * obj.put(key, value)
 * let ret_2: Int = obj.get(key)
 * obj.remove(key)
*/
