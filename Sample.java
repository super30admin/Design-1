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

    // How many floors the hotel has, and how many rooms per floor.
    // 1000 x 1000 covers keys 0...999,999 in one clean grid.
    let primaryBuckets = 1000     // number of floors
    let secondaryBuckets = 1000   // number of rooms per floor

    // The hotel itself: one slot per floor.
    // Each slot is EITHER nil (floor not built yet) OR an array of Bool
    // (floor built, one flag per room). This is why it's [[Bool]?] —
    // an array, where each element is an OPTIONAL array of Bool.
    var storage: [[Bool]?]

    init() {
        // Build the outer floor-list up front, but every floor starts
        // as nil — nobody has checked in anywhere yet, so no room-arrays
        // exist. This is the "lazy allocation" part.
        storage = [[Bool]?](repeating: nil, count: primaryBuckets)
    }

    // Which floor does this key belong to? The remainder after dividing
    // by 1000 — e.g. key 2547 -> floor 547.
    private func getPrimaryHash(_ key: Int) -> Int {
        return key % primaryBuckets
    }

    // Which room on that floor? The whole-number result of dividing by
    // 1000, remainder dropped — e.g. key 2547 -> room 2.
    private func getSecondaryHash(_ key: Int) -> Int {
        return key / secondaryBuckets
    }

    func add(_ key: Int) {
        let primaryIndex = getPrimaryHash(key)          // which floor

        // Has this floor ever been visited before? If not, build it now.
        if storage[primaryIndex] == nil {
            if primaryIndex == 0 {
                // Floor 0 is the one special case: key 1,000,000 lands
                // here with room 1000, which needs one extra room beyond
                // the normal 1000 (rooms 0...1000 = 1001 rooms total).
                storage[primaryIndex] = [Bool](repeating: false, count: secondaryBuckets + 1)
            } else {
                // Every other floor only ever needs rooms 0...999.
                storage[primaryIndex] = [Bool](repeating: false, count: secondaryBuckets)
            }
        }

        let secondaryIndex = getSecondaryHash(key)      // which room
        storage[primaryIndex]![secondaryIndex] = true   // check the guest in
        // The "!" here just means "I already know this floor exists
        // (we just built it above if it didn't), so unwrap the optional
        // and go straight to the room array."
    }

    func remove(_ key: Int) {
        let primaryIndex = getPrimaryHash(key)

        // If the floor was never built, there's nothing to remove —
        // this key was never added, so just walk away.
        guard storage[primaryIndex] != nil else {
            return
        }

        let secondaryIndex = getSecondaryHash(key)
        storage[primaryIndex]![secondaryIndex] = false  // check the guest out
    }

    func contains(_ key: Int) -> Bool {
        let primaryIndex = getPrimaryHash(key)

        // No floor built means this key was definitely never added —
        // don't even bother computing a room number.
        guard storage[primaryIndex] != nil else {
            return false
        }

        let secondaryIndex = getSecondaryHash(key)
        return storage[primaryIndex]![secondaryIndex]   // read the room's flag
    }
}
