package main

// Time Complexity : o(1)
// Space Complexity : o(1) for each func
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

type StackNode struct {
	val  int
	min  int
	next *StackNode
}

type MinStack struct {
	head *StackNode
}

// time: o(1)
// space: o(1)
func Constructor() MinStack {
	return MinStack{head: nil}
}

/*
	since we are using linked list and not arrays,
	time and space will always be o(1)
	since this is stack and we only
	ever push to the top which LL gurantees in o(1) time & space
*/
func (this *MinStack) Push(val int) {
	newHead := &StackNode{val: val, min: val}
	if this.head == nil {
		this.head = newHead
		return
	}
	topMin := this.head.min
	if topMin < val {
		newHead.min = topMin
	}
	newHead.next = this.head
	this.head = newHead
}

/*
	since we are using linked list and not arrays,
	time and space will always be o(1)
	since this is stack and we only
	ever pop from the top which LL gurantees in o(1) time & space
*/
func (this *MinStack) Pop() {
	if this.head == nil {
		panic("Nothing to pop")
	}
	newHead := this.head.next
	this.head.next = nil
	this.head = newHead
}

/*
	time: o(1)
	space: o(1)
*/
func (this *MinStack) Top() int {
	if this.head == nil {
		panic("Nothing to peek")
	}
	return this.head.val
}

/*
	time: o(1)
	space: o(1)
*/
func (this *MinStack) GetMin() int {
	if this.head == nil {
		panic("Nothing to peek min")
	}
	return this.head.min
}
