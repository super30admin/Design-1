type MinStack struct {
    st []*int
    min []*int
}


func Constructor() MinStack {
    return MinStack{
        st: []*int{},
        min: []*int{},
    }
}


func (this *MinStack) Push(val int)  {
    ptrVal := &val
    this.st = append(this.st, ptrVal)
    if len(this.min) == 0 || val <= *this.min[len(this.min)-1] {
        this.min = append(this.min, ptrVal)
    }
    
}


func (this *MinStack) Pop()  {
    topPtr := this.st[len(this.st)-1]
    this.st = this.st[:len(this.st)-1]
    if topPtr == this.min[len(this.min)-1] {
        this.min = this.min[:len(this.min)-1]
    }
}


func (this *MinStack) Top() int {
    return *this.st[len(this.st)-1]
}


func (this *MinStack) GetMin() int {
    return *this.min[len(this.min)-1]    
}


/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */
