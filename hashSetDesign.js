
/**
 * Intution:
 * I am using bucket + arrays concept that i learnt online,
 * Using hash function to give an index for the given key which helps us identifying the bucket during add/ remove operations
 * chaining (each index holds an array) helps us having store all the values that belongs to that hash index without conflicts.

 */

class MyHashSet {
    constructor() {

        this.numerOfBuckets = 1000;
        this.buckets = Array.from({
            length: this.numerOfBuckets
        },
            () => []);
    }

    hashing = (key) => {
        return key % this.numerOfBuckets;
    }
};


/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.add = function (key) {
    const hashIndex = this.hashing(key);
    const currBucket = this.buckets[hashIndex];
    if (!currBucket?.includes(key))
        currBucket.push(key);
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function (key) {
    const hashIndex = this.hashing(key);
    const currBucket = this.buckets[hashIndex];
    if (currBucket.includes(key)) {
        const indexOfTheKey = currBucket.indexOf(key);
        currBucket.splice(indexOfTheKey, 1);
    }
};

/** 
 * @param {number} key
 * @return {boolean}
 */
MyHashSet.prototype.contains = function (key) {
    const hashIndex = this.hashing(key);
    return this.buckets[hashIndex].includes(key);
};

/** 
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */