package main

type MinStack struct {
	st [][]int // [val, minSoFar]
}

func Constructor() MinStack {
	return MinStack{
		st: [][]int{},
	}
}

/*
time : o(1)
space: o(1)
*/
func (this *MinStack) Push(val int) {
	item := []int{val, val}
	if len(this.st) == 0 {
		this.st = append(this.st, item)
		return
	}
	topMin := this.st[len(this.st)-1][1]
	if topMin < val {
		item[1] = topMin
	}
	this.st = append(this.st, item)
}

/*
time : o(1)
space: o(1)
*/
func (this *MinStack) Pop() {
	this.st = this.st[:len(this.st)-1]
}

/*
time : o(1)
space: o(1)
*/
func (this *MinStack) Top() int {
	return this.st[len(this.st)-1][0]
}

/*
time : o(1)
space: o(1)
*/
func (this *MinStack) GetMin() int {
	return this.st[len(this.st)-1][1]
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */
