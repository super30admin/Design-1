// Time Complexity : Search O(1), Put O(1) and remove O(1)
// Space Complexity : O(primaryStorageSize + secondaryStorageSize)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Forgot to use Math.Floor to avoid decimal issue


// Your code here along with comments explaining your approach

// Defining all the variable 
// As the constraints 10^6 we doing square root of 10^6 which 1000.
var MyHashSet = function() {
    this.primaryStorageSize = 1000;
    this.secondaryStorageSize = 1000;
    this.storage = Array(this.primaryStorageSize);
};

// Primary Hashfunction uses Mod to keep the value in InBound
MyHashSet.prototype.primaryHashfunction = function(key) {
    return key % this.primaryStorageSize;
}

// Secondary Hashfunction uses divide this will make sure no different values collide on the same bucket. In JS we have to do Math.floor to avoid decimal values
MyHashSet.prototype.secondaryHashfunction = function(key) {
    return Math.floor(key / this.secondaryStorageSize);
}

/** 
 * @param {number} key
 * @return {void}
 * 
 */
MyHashSet.prototype.add = function(key) {
    let primaryIndex = this.primaryHashfunction(key);
    if(!this.storage[primaryIndex]) {
        // This handles the edge case when the value will be 10^6
        if(primaryIndex == 0) {
            this.storage[primaryIndex] = Array(this.secondaryStorageSize + 1).fill(false)
        }else {
            this.storage[primaryIndex] = Array(this.secondaryStorageSize).fill(false)
        }
    }

    let secondaryStorage = this.secondaryHashfunction(key);
    this.storage[primaryIndex][secondaryStorage] = true;
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function(key) {
    let primaryIndex = this.primaryHashfunction(key);
    if(this.storage[primaryIndex]) {
        let secondaryStorage = this.secondaryHashfunction(key);
        this.storage[primaryIndex][secondaryStorage] = false;
    }
};

/** 
 * @param {number} key
 * @return {boolean}
 */
MyHashSet.prototype.contains = function(key) {
    let primaryIndex = this.primaryHashfunction(key);
    if(this.storage[primaryIndex]) {
        let secondaryStorage = this.secondaryHashfunction(key);
        return this.storage[primaryIndex][secondaryStorage];
    }

    return false;
};

/** 
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */
