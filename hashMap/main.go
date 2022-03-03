package main

import "fmt"

const (
	arraySize  = 1000
	nestedSize = arraySize + 1
)

type HashMap struct {
	items [][]*int
}

func Constructor() HashMap {
	return HashMap{items: make([][]*int, arraySize)}
}

func (h *HashMap) hash(key int) int  { return key % arraySize }
func (h *HashMap) hash2(key int) int { return key / nestedSize }

func (h *HashMap) Put(key, val int) {
	idx := h.hash(key)
	nestedIdx := h.hash2(key)
	if h.items[idx] == nil {
		h.items[idx] = make([]*int, nestedSize)
	}
	h.items[idx][nestedIdx] = &val
}

func (h *HashMap) Get(key int) int {
	idx := h.hash(key)
	nestedIdx := h.hash2(key)
	if h.items[idx] == nil {
		return -1
	}
	if h.items[idx][nestedIdx] == nil {
		return -1
	}
	return *h.items[idx][nestedIdx]
}

func (h *HashMap) Remove(key int) {
	idx := h.hash(key)
	nestedIdx := h.hash2(key)
	if h.items[idx] == nil {
		return
	}
	h.items[idx][nestedIdx] = nil
}

func main() {
	h := Constructor()
	fmt.Println("Get 1 : should be -1 ----- ", h.Get(1))
	h.Put(1, 100)
	fmt.Println("Get 1 : should be 100 ----- ", h.Get(1))
	h.Put(1000000, 1000000)
	fmt.Println("Get: ", h.Get(1000000))

}
