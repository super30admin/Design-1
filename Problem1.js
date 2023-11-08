//## Problem 1:(https://leetcode.com/problems/design-hashset/)

// time compelxity is O(1) and space complexity is O(n)
// it is accepted in leetcode
// approch
/*used array datastructure for storage 
used modula for finding the bucketindex, checked for the availabilty of index and used push 
operation to push the elements and splice to delete */

var MyHashSet = function() {
    this.buckets = 1000;
    this.storage= new Array(this.buckets);

};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.add = function(key) {
    const bucketIndex = key%this.buckets;
    if(!this.storage[bucketIndex]){
        this.storage[bucketIndex]=[];
    }
    if(!this.storage[bucketIndex].includes(key)){
        this.storage[bucketIndex].push(key);
    }
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function(key) {
    const bucketIndex=key%this.buckets;
    if(this.storage[bucketIndex]){
        const index = this.storage[bucketIndex].indexOf(key);
        if (index !== -1) {
            this.storage[bucketIndex].splice(index, 1);
        }
    }
    
};

/** 
 * @param {number} key
 * @return {boolean}
 */
MyHashSet.prototype.contains = function(key) {
    const bucketIndex = key % this.buckets;
    return !!this.storage[bucketIndex] && this.storage[bucketIndex].includes(key);
};

/** 
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */