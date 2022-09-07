
var MyHashSet = function() {
    this.arr = []
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.add = function(key) {
    const index = this.arr.indexOf(key);
    if (index == -1) { 
        this.arr.push(key);
    }
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function(key) {
    const index = this.arr.indexOf(key);
    if (index > -1) { 
        this.arr.splice(index, 1); 
    }
};

/** 
 * @param {number} key
 * @return {boolean}
 */
MyHashSet.prototype.contains = function(key) {
    console.log(this.arr)
    for(let i=0; i<this.arr.length; i++){
        if(this.arr[i] === key){
            return true;
        }
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