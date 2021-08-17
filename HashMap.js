// Time Complexity : O(1) for all
// Space Complexity : O(n) n is number of entries
// Did this code successfully run on Leetcode : Yes


var MyHashMap = function () {
    this.hashMap = {};
};

/**
* value will always be non-negative. 
*/
MyHashMap.prototype.put = function (key, value) {
    this.hashMap[key] = value;

};

/**
* Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key 
*/
MyHashMap.prototype.get = function (key) {
    if (typeof this.hashMap[key] === 'undefined') {
        return -1;
    }
    return this.hashMap[key];
};

/**
* Removes the mapping of the specified value key if this map contains a mapping for the key 
*/
MyHashMap.prototype.remove = function (key) {
    delete this.hashMap[key];

};

/**
* Your MyHashMap object will be instantiated and called as such:
* var obj = new MyHashMap()
* obj.put(key,value)
* var param_2 = obj.get(key)
* obj.remove(key)
*/