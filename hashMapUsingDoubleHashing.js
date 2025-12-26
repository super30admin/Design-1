/**
 *  I used double hashing technique here
 *  First hash function uses mod and second hash function uses division
 *  Created a method called getFinalLocation which uses both hashOne and hashTwo functions
 */


class MyHashMap {
    constructor() {
        this.bucketSize = 1000;
        this.parentArray = Array.from({
            length: this.bucketSize
        }, () => []);
    }

    hashOne = (key) => {
        return key % this.bucketSize;
    }

    hashTwo = (key) => {
        return Math.floor(key / this.bucketSize);
    }

    getFinalLocation = (key) => {
        const mainIndex = this.hashOne(key);
        const currSlot = this.parentArray[mainIndex];
        const childIndex = this.hashTwo(key);
        return [currSlot, childIndex];
    }

};

/** 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function (key, value) {
    let [currSlot, childIndex] = this.getFinalLocation(key);
    if (!currSlot[childIndex]) {
        currSlot[childIndex] = [key, value];
    } else {
        currSlot[childIndex][1] = value;
    }
};

/** 
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function (key) {
    let [currSlot, childIndex] = this.getFinalLocation(key);
    if (!currSlot[childIndex]) return -1;
    return currSlot[childIndex][1];
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function (key) {
    let [currSlot, childIndex] = this.getFinalLocation(key);
    if (!currSlot[childIndex]) return;
    currSlot[childIndex] = null;
};

/** 
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */
