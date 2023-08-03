
const (
    arraySize int = 1001
)

// using chaining to avoid collision
type MyHashSet struct {
    items []*dll  
}


func Constructor() MyHashSet {
    return MyHashSet{
        items: make([]*dll, arraySize),
    }
}

func(this *MyHashSet) hashIdx(key int) int {
    return key % arraySize
}


func (this *MyHashSet) Add(key int)  {
    idx := this.hashIdx(key)
    if this.items[idx] == nil {
        this.items[idx] = newDLL()
    }
    exists := this.items[idx].searchAndReturnNode(key)
    if exists != nil {return}
    this.items[idx].addToTail(key)
}


func (this *MyHashSet) Remove(key int)  {
    idx := this.hashIdx(key)
    if this.items[idx] == nil {return}
    
    nodeToDelete := this.items[idx].searchAndReturnNode(key)
    if nodeToDelete != nil {
        this.items[idx].deleteNode(nodeToDelete)
    }
}


func (this *MyHashSet) Contains(key int) bool {
    idx := this.hashIdx(key)
    if this.items[idx] == nil {return false}    
    nodeToDelete := this.items[idx].searchAndReturnNode(key)
    return nodeToDelete != nil    
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Add(key);
 * obj.Remove(key);
 * param_3 := obj.Contains(key);
 */

type listNode struct {
    key int
    next *listNode
    prev *listNode
}

type dll struct {
    head *listNode
    tail *listNode
}

func newDLL() *dll {
    return &dll{}
}

func (d *dll) addToHead(key int) {
    newHead := &listNode{key: key}
    if d.head == nil {
        d.head = newHead
        d.tail = newHead
        return
    }
    newHead.next = d.head
    d.head.prev = newHead
    d.head = newHead
}

func (d *dll) addToTail(key int) {
    newTail := &listNode{key: key}
    if d.head == nil {
        d.head = newTail
        d.tail = newTail
        return
    }
    newTail.prev = d.tail
    d.tail.next = newTail
    d.tail = newTail
}


func (d *dll) deleteNode(node *listNode) {
    if d.head == nil {
        panic("DLL is emtpy")
    }
    if d.head == node {
        newHead := d.head.next
        d.head = newHead
        if d.tail == node {
            d.tail = newHead
        }
        return
    }
    next := node.next
    prev := node.prev
    node.next = nil
    node.prev = nil

    
    // tail node
    if node == d.tail {
        prev.next = nil
        d.tail = prev
        return
    }
    
    // middle node
    next.prev = prev
    prev.next = next
}

func (d *dll) searchAndReturnNode(key int) *listNode {
    if d.head == nil {return nil}
    curr := d.head
    for curr != nil {
        if curr.key == key {return curr}
        curr = curr.next
    }
    return nil
}
