//Constant Time for all
var MyHashSet = function() {
    this.hash_map = {}
};

MyHashSet.prototype.add = function(key) {
    this.hash_map[key] = null;
};

MyHashSet.prototype.remove = function(key) {
    // Constant Space
    delete this.hash_map[key]
};

MyHashSet.prototype.contains = function(key) {
    // Constant Space
    // This just asks if the property exists
    return this.hash_map.hasOwnProperty(key)
};