// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// MyHashSet — a HashSet built from a 2D grid ("hotel with floors and rooms")
//
// Big idea: instead of one giant array of a million booleans, we split each
// key into (floor, room) using % and /, and only build a floor's rooms the
// first time a key actually lands on that floor.

class MyHashSet {

    let primaryBuckets = 1000
    let secondaryBuckets = 1000

    var storage: [[Bool]?]

    init() {
        storage = [[Bool]?](repeating: nil, count: primaryBuckets)
    }

    private func getPrimaryHash(_ key: Int) -> Int {
        return key % primaryBuckets
    }

    private func getSecondaryHash(_ key: Int) -> Int {
        return key / secondaryBuckets
    }

    func add(_ key: Int) {
        let primaryIndex = getPrimaryHash(key)

        if storage[primaryIndex] == nil {
            if primaryIndex == 0 {
                storage[primaryIndex] = [Bool](repeating: false, count: secondaryBuckets + 1)
            } else {
                storage[primaryIndex] = [Bool](repeating: false, count: secondaryBuckets)
            }
        }

        let secondaryIndex = getSecondaryHash(key)
        storage[primaryIndex]![secondaryIndex] = true
    }

    func remove(_ key: Int) {
        let primaryIndex = getPrimaryHash(key)

        guard storage[primaryIndex] != nil else {
            return
        }

        let secondaryIndex = getSecondaryHash(key)
        storage[primaryIndex]![secondaryIndex] = false
    }

    func contains(_ key: Int) -> Bool {
        let primaryIndex = getPrimaryHash(key)

        guard storage[primaryIndex] != nil else {
            return false
        }

        let secondaryIndex = getSecondaryHash(key)
        return storage[primaryIndex]![secondaryIndex]
    }
}
