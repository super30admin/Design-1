// Time Complexity : O(1) for all 
// Space Complexity : O(1) / Fixed size of O(100)
// Did this code successfully run on Leetcode : Yes

class Node {
    constructor(key, val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}

var MyHashMap = function () {
    this.size = 10000;
    this.nodes = new Array(this.size);
};

MyHashMap.prototype.hashIndex = function (key) {
    return key % this.size;
}

MyHashMap.prototype.find = function (key, head) {
    let prev = null;
    let current = head;
    while (current != null && current.key != key) {
        prev = current;
        current = current.next;
    }
    return prev;
}


MyHashMap.prototype.put = function (key, value) {
    let index = this.hashIndex(key);
    if (!this.nodes[index]) {
        this.nodes[index] = new Node(-1, -1);
    }
    let prev = this.find(key, this.nodes[index]);
    if (!prev.next) {
        prev.next = new Node(key, value)
    } else {
        prev.next.val = value;
    }
};


MyHashMap.prototype.get = function (key) {
    let index = this.hashIndex(key);
    let prev = this.find(key, this.nodes[index]);
    if (prev && prev.next) {
        return prev.next.val;
    } else {
        return -1
    }
};


MyHashMap.prototype.remove = function (key) {
    let index = this.hashIndex(key);
    let prev = this.find(key, this.nodes[index]);
    if (prev && prev.next) {
        prev.next = prev.next.next;
    }

};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = new MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */
