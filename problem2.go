
import (
	"container/list"
)


type MinStack struct {
    Stack *list.List
    Min *list.List
}

func listStr(l *list.List) string{
    str := ""
    for e := l.Front(); e!= nil;e=e.Next() {
        str = fmt.Sprintf("%v %v", str, e.Value)
    }
    
    return str
}

func (this *MinStack) ToStr() string{
    str := fmt.Sprintf("\nStack: %v\n", listStr(this.Stack))
    str = fmt.Sprintf("%vMin: %v\n", str,listStr(this.Min))
    return str
}

func Constructor() MinStack {
    return MinStack{
        Stack: list.New(),
        Min:list.New(),
    }
}


func (this *MinStack) Push(val int)  { // O(1)
    // fmt.Printf("\n Before Push %v %v",val, this.ToStr())
    this.Stack.PushBack(val)
    if this.Min.Len() == 0 {
        this.Min.PushBack(val)
        // fmt.Printf("\n After Push %v %v",val, this.ToStr())
        return
    }
    if this.Min.Back() != nil && this.Min.Back().Value.(int) >= val {
        this.Min.PushBack(val)
    }
    // fmt.Printf("\n After Push %v %v",val, this.ToStr())
}


func (this *MinStack) Pop()  { // O(N)
    // fmt.Printf("\n Before Pop %v", this.ToStr())
    val := this.Stack.Remove(this.Stack.Back())
    if this.Min.Back() != nil && this.Min.Back().Value.(int) == val {
        this.Min.Remove(this.Min.Back())
    }
    // fmt.Printf("\n After Pop %v", this.ToStr())
}


func (this *MinStack) Top() int {
    // fmt.Printf("\n Before Top %v", this.ToStr())
    return  this.Stack.Back().Value.(int)
}


func (this *MinStack) GetMin() int {
    // fmt.Printf("\n Before GetMin  %v", this.ToStr())
    if this.Min.Back() == nil {
        return math.MaxInt
    }
    return  this.Min.Back().Value.(int)
}


/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */