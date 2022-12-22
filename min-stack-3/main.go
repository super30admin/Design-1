package main

import (
	"fmt"
)

type MinStack struct {
	stack    []int
	minStack []int
}

func Constructor() MinStack {
	ms := MinStack{}
	return ms
}

func (this *MinStack) Push(val int) {
	this.stack = append(this.stack, val)
	// if minStack is empty and has no value then make first val as the min value
	if len(this.minStack) == 0 {
		this.minStack = append(this.minStack, val)
		return
	}
	// check if the value added to stack is less than the top value of the minStack
	if val < this.minStack[len(this.minStack)-1] || val == this.minStack[len(this.minStack)-1] {
		fmt.Println("val is ", val)
		this.minStack = append(this.minStack, val)
	}
}

func (this *MinStack) Pop() {
	pop := this.stack[len(this.stack)-1]

	// remove top element from stack
	this.stack = this.stack[:len(this.stack)-1]
	// pop from minStack if value pop'd is also on top of minStack
	if this.minStack[len(this.minStack)-1] == pop {
		this.minStack = this.minStack[:len(this.minStack)-1]
	}
}

func (this *MinStack) Top() int {
	if len(this.stack) > 0 {
		return this.stack[len(this.stack)-1]
	}
	return 0
}

func (this *MinStack) GetMin() int {
	if len(this.minStack) > 0 {
		return this.minStack[len(this.minStack)-1]
	}
	return 0
}

func main() {
	obj := Constructor()
	obj.Push(2147483646)
	obj.Push(2147483646)
	obj.Push(2147483647)
	obj.Top()
	obj.Pop() // 1
	fmt.Println(obj.GetMin())
	obj.Pop() // 2
	fmt.Println(obj.GetMin())
	fmt.Println("min", obj.minStack)
	obj.Pop() // 3
	obj.Push(2147483647)
	obj.Top()
	obj.GetMin()
	obj.Push(-2147483648)
	obj.Top()
	obj.GetMin()
	obj.Pop()
	obj.GetMin()
	fmt.Println(obj.stack)
	fmt.Println("min", obj.minStack)

}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */
