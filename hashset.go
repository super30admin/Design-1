# used linkedlist to store keys for hashset. Time complexity is O(n)


package main

import (
	"fmt"
  "container/list"
)

type MyHashSet struct {
	data []list.List
}

func (this *MyHashSet) hashfn(key int) int {
	return key % len(this.data)
}

func Constructor() MyHashSet {
     return MyHashSet{make([]list.List, 100)}
}

func (this *MyHashSet) Add(key int) {
	if this.Contains(key) {
		return
	}
	val := this.hashfn(key)
	this.data[val].PushBack(key)
}

func (this *MyHashSet) Remove(key int) {
	val := this.hashfn(key)
	for e := this.data[val].Front(); e != nil; e = e.Next() {
		if e.Value.(int) == key {
			this.data[val].Remove(e)
		}
	}
}

func (this *MyHashSet) Contains(key int) bool {
	val := this.hashfn(key)
	for e := this.data[val].Front(); e != nil; e = e.Next() {
		if e.Value.(int) == key {
			return true
		}
	}
	return false
}


func main() {
  
   obj := Constructor()
   obj.Add(10)
   obj.Add(99)
   obj.Remove(10)
   present := obj.Contains(99)
   fmt.Println("The value is", present)
}

