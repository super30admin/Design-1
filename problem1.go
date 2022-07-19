const CAPACITY = 1000

type DoublyLinkedList struct {
    Head *Node
    Tail *Node
}

type Node struct {
    Val int
    Next *Node
    Prev *Node
}

func NewNode(val int) *Node {
    return &Node{
        Val: val,
    }
}

func NewDoublyLinkedList() *DoublyLinkedList{
    head := NewNode(-1)
    tail := NewNode(-1)
    head.Next=tail
    tail.Prev=head
    return &DoublyLinkedList{
        Head: head,
        Tail: tail,
    }
}

func (d *DoublyLinkedList) Print(msg string) {
    fmt.Println(msg)
    for node := d.Head.Next; node != d.Tail; node = node.Next {
        fmt.Printf("( %v)  ", node.Val)
    }
    fmt.Println()
}

func (d *DoublyLinkedList) AddToHead(node *Node) { // O(1)
    node.Next = d.Head.Next
    node.Prev=d.Head
    d.Head.Next=node
    node.Next.Prev=node
}

func (d *DoublyLinkedList) Remove(node *Node)  { // O(1)
    node.Prev.Next=node.Next
    node.Next.Prev=node.Prev
}

func (d *DoublyLinkedList) Find(val int) *Node { // O(N)
    var node *Node
    for node = d.Head.Next; node != d.Tail && node.Val!=val; node = node.Next {
    }
    if node == d.Tail {
        return nil
    }
    return node
}

type MyHashSet struct {
    Data []*DoublyLinkedList
    Capacity int
}

func (this *MyHashSet) hashFunc(key int)(hashVal int) {
    return key % this.Capacity
}

func Constructor() MyHashSet {
    hashSet := MyHashSet{
        Capacity: CAPACITY,
    }
    hashSet.Data = make([](*DoublyLinkedList),hashSet.Capacity)
    return hashSet
}

func (this *MyHashSet) Add(key int)  {
    index := this.hashFunc(key)
    if this.Data[index] == nil {
        this.Data[index] = NewDoublyLinkedList()
    }
    if !this.Contains(key) {
        this.Data[index].AddToHead(NewNode(key))
    }
    return
}


func (this *MyHashSet) Remove(key int)  {
    // fmt.Printf("Removing %v\n", key)
    index := this.hashFunc(key)
    if this.Data[index] == nil {
        // fmt.Printf("No DLL found at index %v\n", index)
        return
    }
    node := this.Data[index].Find(key)
    if node == nil {
        return
    }
    // this.Data[index].Print(fmt.Sprintf("Before removing %v", key))
    this.Data[index].Remove(node)
    // this.Data[index].Print(fmt.Sprintf("After removing %v", key))
    return
}


func (this *MyHashSet) Contains(key int) bool {
    // fmt.Printf("Looking for %v\n", key)
    index := this.hashFunc(key)
    if this.Data[index] == nil {
        // fmt.Printf("No DLL found at index %v\n", index)
        return false
    }
    // this.Data[index].Print(fmt.Sprintf("Before looking for %v", key))
    return this.Data[index].Find(key) != nil
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Add(key);
 * obj.Remove(key);
 * param_3 := obj.Contains(key);
 */