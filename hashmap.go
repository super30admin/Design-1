// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : syntax for go ptr array was new

// Your code here along with comments explaining your approach
/*
taking a mod of 1000 for division into arrays
each element of array is a pointer to a node with key, value and next link to node
so array containing linked list
use the mod as index to add linked list elements if they belong in the same mod
*/

package main

import "fmt"

const (
	mod = 1000
)

type MyHashMap struct {
	arr [mod]*Node
}

type Node struct {
	Key  int
	Val  int
	Next *Node
}

func (e *Node) Init(key int, val int) {
	e.Key = key
	e.Val = val
	e.Next = nil
}

/** Initialize your data structure here. */
func Constructor() MyHashMap {
	var a = [mod]*Node{}
	return MyHashMap{arr: a}
}

/** value will always be non-negative. */
func (this *MyHashMap) Put(key int, value int) {
	ind := key % mod
	ptr := this.arr[ind]
	if ptr == nil {
		ptr = new(Node)
		ptr.Init(key, value)
		this.arr[ind] = ptr
		return
	} else if ptr.Key == key {
		ptr.Val = value
		return
	} else {
		for ptr.Next != nil {
			ptr = ptr.Next
			if ptr.Key == key {
				ptr.Val = value
				return
			}
		}
		ptr.Next = new(Node)
		ptr.Next.Init(key, value)
		return
	}

}

/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
func (this *MyHashMap) Get(key int) int {
	ind := key % mod
	ptr := this.arr[ind]
	if ptr == nil {
		return -1
	} else if ptr.Key == key {
		return ptr.Val
	} else {
		for ptr.Next != nil {
			ptr = ptr.Next
			if ptr.Key == key {
				return ptr.Val
			}
		}
		return -1
	}
}

/** Removes the mapping of the specified value key if this map contains a mapping for the key */
func (this *MyHashMap) Remove(key int) {
	ind := key % mod
	ptr := this.arr[ind]
	if ptr == nil {
		return
	} else if ptr.Key == key {
		ptr.Val = -1
		return
	} else {
		for ptr.Next != nil {
			ptr = ptr.Next
			if ptr.Key == key {
				ptr.Val = -1
				return
			}
		}
		return
	}
}

func MainHashMap() {
	obj := Constructor()
	obj.Put(1, 1)
	obj.Put(2, 2)
	fmt.Println(obj.Get(1)) // returns 1
	fmt.Println(obj.Get(3)) // returns -1 (not found)
	obj.Put(2, 1)           // update the existing value
	fmt.Println(obj.Get(2)) // returns 1
	obj.Remove(2)           // remove the mapping for 2
	fmt.Println(obj.Get(2)) // returns -1 (not found)
}
