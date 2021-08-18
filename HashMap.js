// Time Complexity : O(1) for all 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes

var MyHashMap = function () {
    this.size = 13;
    this.keyMap = new Array(this.size);

};


MyHashMap.prototype.hash = function (key) {
    key = key.toString();
    let hashVal = 0;
    for (let i = 0; i < key.length; i++) {
        let char = key[i];
        let val = char.charCodeAt(0);
        hashVal = (hashVal + val) % this.keyMap.length;

    }

    return hashVal;
}


MyHashMap.prototype.put = function (key, value) {
    let index = this.hash(key);
    if (!this.keyMap[index]) {
        this.keyMap[index] = [[key, value]];
    } else {
        let elemExists = false;
        for (let i = 0; i < this.keyMap[index].length; i++) {

            if (this.keyMap[index][i][0] === key) {
                this.keyMap[index][i][1] = value;
                elemExists = true;
            }

        }
        if (elemExists === false) {
            this.keyMap[index].push([key, value]);
        }
    }

};


MyHashMap.prototype.get = function (key) {
    let index = this.hash(key);
    if (this.keyMap[index]) {
        for (let i = 0; i < this.keyMap[index].length; i++) {
            if (this.keyMap[index][i][0] === key) {
                return this.keyMap[index][i][1];
            }
        }
    }

    return -1;
};


MyHashMap.prototype.remove = function (key) {
    let index = this.hash(key);
    if (this.keyMap[index]) {
        for (let i = 0; i < this.keyMap[index].length; i++) {
            if (this.keyMap[index][i][0] === key) {
                this.keyMap[index].splice(i, 1);
            }
        }
    }

};


/**
* Your MyHashMap object will be instantiated and called as such:
* var obj = new MyHashMap()
* obj.put(key,value)
* var param_2 = obj.get(key)
* obj.remove(key)
*/