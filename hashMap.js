// Time Complexity : O(1)
// Space Complexity : O(100)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MyHashMap {
    constructor() {
        this.memory = 100;
        this.data = new Array(this.memory);
    }
    _hash(key) {
        return key / this.memory;
    }
    put(key, value) {
        let address = this._hash(key);
        if(!this.data[address]) {
            this.data[address] = [];
            this.data[address].push([key, value]);
        } 
        else {
            this.data[address].unshift([key, value]);
        }
    }
    get(key) {
        let address = this._hash(key);
        let curBucket = this.data[address];
       
        if(curBucket) {
            for(let i = 0; i < curBucket.length; i++) {
                if(curBucket[i][0] === key) return curBucket[i][1];
            }
        }
        return -1;
    }
    remove(key) {
        let address = this._hash(key);
        this.data[address] = [];
    }
}