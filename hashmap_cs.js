var MyHashMap;

MyHashMap = function() {
  return Object.assign(Object.create(MyHashMap.prototype), {
    hm: Array(8).fill([]),
    size: 8
  });
};

MyHashMap.prototype.keyToHKey = function(key) {
  var size;
  ({size} = this);
  return key % size;
};

MyHashMap.prototype.put = function(key, value) {
  var found, hm, subhm;
  ({hm} = this);
  subhm = hm[this.keyToHKey(key)];
  found = subhm.find(function(kv) {
    return kv.key === key;
  });
  if (found) {
    return found.value = value;
  } else {
    return hm[this.keyToHKey(key)] = [...subhm, {key, value}];
  }
};

MyHashMap.prototype.get = function(key) {
  var found, hm, subhm;
  ({hm} = this);
  subhm = hm[this.keyToHKey(key)];
  found = subhm.find(function(kv) {
    return kv.key === key;
  });
  if (found) {
    return found.value;
  } else {
    return -1;
  }
};

MyHashMap.prototype.remove = function(key) {
  var foundIndex, hm, subhm;
  ({hm} = this);
  subhm = hm[this.keyToHKey(key)];
  foundIndex = subhm.findIndex(function(kv) {
    return kv.key === key;
  });
  if (foundIndex < 0) {
    return;
  }
  return hm[this.keyToHKey(key)] = subhm.filter(function(kv) {
    return kv.key !== key;
  });
};

//# sourceMappingURL=hashmap_cs.js.map
