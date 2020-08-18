MyHashMap = () -> Object.assign(
  Object.create(MyHashMap::),
    hm: Array(8).fill([])
    size: 8
)

MyHashMap::keyToHKey = (key) ->
  {size} = @
  key%size

MyHashMap::put = (key, value) ->
  {hm} = @
  subhm = hm[@keyToHKey(key)]
  found = subhm.find (kv) -> kv.key == key
  if found
    found.value = value
  else
    hm[@keyToHKey(key)] = [
      subhm...,
      {key, value}
    ]

MyHashMap::get = (key) ->
  {hm} = @
  subhm = hm[@keyToHKey(key)]
  found = subhm.find (kv) -> kv.key == key
  if found
    found.value
  else
    -1

MyHashMap::remove = (key) ->
  {hm} = @
  subhm = hm[@keyToHKey(key)]
  foundIndex = subhm.findIndex (kv) -> kv.key == key
  return if foundIndex < 0
  hm[@keyToHKey(key)] = subhm.filter (kv) -> kv.key != key
