// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I found it difficult to access the Space and time complexity.


function Node(key, value) {
    this.key = key;
    this.value = value;
    this.next = null;
}

/**
 * Initialize your data structure here.
 */
var MyHashMap = function() {
    this.size = 2069;
    this.store = [];
};

/**
 * value will always be non-negative. 
 * @param {number} key 
 * @param {number} value
 * @return {void}
 */
MyHashMap.prototype.put = function(key, value) {
    const hash = this._getHash(key);
    if (!(this.store[hash] instanceof Node)) {
        this.store[hash] = new Node(key, value);
    }
    let prevNode;
    let node = this.store[hash];
    while (node) {
        if (node.key === key) {
            node.value = value;
            return;
        }
        prevNode = node;
        node = node.next;
    }
    prevNode.next = new Node(key, value);
};

/**
 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key 
 * @param {number} key
 * @return {number}
 */
MyHashMap.prototype.get = function(key) {
    const hash = this._getHash(key);
    if (!(this.store[hash] instanceof Node)) {
        return -1;    
    }
    let node = this.store[hash];
    while (node) {
        if (node.key === key) {
            return node.value;
        }
        node = node.next;
    }
    return -1;
};

/**
 * Removes the mapping of the specified value key if this map contains a mapping for the key 
 * @param {number} key
 * @return {void}
 */
MyHashMap.prototype.remove = function(key) {
    const hash = this._getHash(key);
    if (!(this.store[hash] instanceof Node)) {
        return;
    }
    let node = this.store[hash];
    if (node.key === key) {
        this.store[hash] = node.next;
        return;
    }
    let prevNode = node;
    node = node.next;
    while (node) {
        if (node.key === key) {
            prevNode.next = node.next;
            return;
        }
        prevNode = node;
        node = node.next;
    }
};

MyHashMap.prototype._getHash = function(key) {
    return key % this.size;
}

/** 
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */