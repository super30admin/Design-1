/** 
TC: O(1)
SC: O(n)
 */
var MyHashSet = function() {
    this.prim = Math.sqrt(1000000);
    this.sec =  Math.sqrt(1000000);
    this.designSet = new Array(this.prim).fill(null);
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.add = function(key) {
    let hashValue = this.firsthash(key)
    let doubleHashValue = this.secondHash(key)
    console.log(hashValue, doubleHashValue)

    //see if the array at this point exists
    if(!this.designSet[hashValue]) { 
        // the array has not yet initialized
        this.designSet[hashValue] = new Array(this.prim).fill(false)
    }
        this.designSet[hashValue][doubleHashValue] = true
};


MyHashSet.prototype.firsthash = function(key) {
    return key%this.prim;
}


MyHashSet.prototype.secondHash = function(key) {
    return Math.ceil(key/this.sec) + 1
}


/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function(key) {
     let hashValue = this.firsthash(key)
    let doubleHashValue = this.secondHash(key)
    if(!this.designSet[hashValue]) return;
    this.designSet[hashValue][doubleHashValue] = false
};

/** 
 * @param {number} key
 * @return {boolean}
 */
MyHashSet.prototype.contains = function(key) {
    
    let hashValue = this.firsthash(key)
    let doubleHashValue = this.secondHash(key)
    if(!this.designSet[hashValue]) return false;
    return this.designSet[hashValue][doubleHashValue]
};



/** 
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */