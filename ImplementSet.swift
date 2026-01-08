//
//  S30Programs.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 12/24/25.
//


//We are implementing Set with double hashing
class ImplementSet {
    
    //primary storage
    private var storage: [[Bool]?]
    //length of primary array
    private var buckets: Int
    //length of nested array
    private var bucketItems: Int
    
    private func hash1(key: Int) -> Int {
        //primary bucket
        return key % buckets
    }
    
    private func hash2(key: Int) -> Int {
        //nested array bucket
        return key / bucketItems
    }
    
    
    init() {
        buckets = 1000
        bucketItems = 1000
        storage = Array(repeating: nil, count: buckets)
    }
    
    //primary array contains the pointer to the nested array.
    //secondary array contains the items which has the same hash1 value. To identify items uniquely in secondary array, apply hash2. After hash2, you will find an index, set that index's value to true.
    //O(1)
    func add(key: Int) {
        let bucket = hash1(key: key)
        
        if (storage[bucket] == nil) {
            //there is no nested arrey, so create a nested array
            if (bucket == 0) {
                storage[bucket] = Array(repeating: false, count: bucketItems + 1)
            } else {
                storage[bucket] = Array(repeating: false, count: bucketItems)
            }
        }
        let bucketItem = hash2(key: key)
        storage[bucket]![bucketItem] = true
    }
    
    func remove(key: Int) {
        //find out the primary array bucket
        let bucket = hash1(key: key)
        //if there is no nested array, just return. Wouldn't remove anything
        if (storage[bucket] == nil) {
            return
        }
        let bucketItem = hash2(key: key)
        storage[bucket]![bucketItem] = false
    }
    
    func contains(key: Int) -> Bool {
        let bucket = hash1(key: key)
        let bucketItem = hash2(key: key)
        //if there is no nested array, return false
        if (storage[bucket] == nil)  {
            return false
        }
        return storage[bucket]![bucketItem]
    }
}
