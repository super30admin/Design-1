// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : mathematical proof for min value

// Your code here along with comments explaining your approach
/*
structure is a stack having org data, min data and pointer to next
if stack is empty add the element and set as minimum
while pushing if current is lower then add 2(current)-currentmin
*/

package main

import "fmt"

type StackNode struct {
	Data int64
	DataOrg int64
	Next *StackNode
}

func (e *StackNode) Init(val int64, valorg int64) {
	e.Data = val
	e.DataOrg = valorg
	e.Next = nil
}

type MinStack struct {
	top *StackNode
	curmin int64
}


/** initialize your data structure here. */
func Constructor1() MinStack {
	return MinStack{}
}


func (this *MinStack) Push(x1 int)  {
	x := int64(x1)
	if this.top == nil {
		this.top = new (StackNode)
		this.top.Init(x, x)
		this.curmin = x
		return
	} else {
		var ptr = this.top
		for ptr.Next != nil {
			ptr = ptr.Next
		}
		if x < this.curmin {
			ptr.Next = new (StackNode)
			ptr.Next.Init(2*x - this.curmin, x)
			this.curmin = x
		} else {
			ptr.Next = new (StackNode)
			ptr.Next.Init(x, x)
		}
	}

}


func (this *MinStack) Pop()  {
	if this.top == nil {
		return
	} else {
		var ptr = this.top
		var ptrPrev *StackNode
		var first = false
		for ptr.Next != nil {
			ptr = ptr.Next
			if first {
				ptrPrev = ptrPrev.Next
			}
			if !first {
				first = true
				ptrPrev = this.top
			}
		}
		if ptr.Data < this.curmin {
			this.curmin = 2*this.curmin - ptr.Data
			if ptrPrev != nil {
				ptrPrev.Next = nil
			} else {
				this.curmin = 2147483647
			}
		} else {
			if ptrPrev != nil {
				ptrPrev.Next = nil
			} else {
				this.curmin = 2147483647
			}

		}
	}
}


func (this *MinStack) Top() int {
	var ptr = this.top
	for ptr.Next != nil {
		ptr = ptr.Next
	}
	return int(ptr.DataOrg)
}


func (this *MinStack) GetMin() int {
	return int(this.curmin)
}

func MainMinStack() {
	obj := Constructor1()
	obj.Push(-2)
	obj.Push(0)
	obj.Push(-3)
	fmt.Println(obj.GetMin()) // return -3
	obj.Pop()
	fmt.Println(obj.Top())    // return 0
	fmt.Println(obj.GetMin()) // return -2
}
