package main

import "fmt"

const (
	// ideally math.sqrt of an input size
	// but if you know the constraint ( i.e biggest/longest key possible )
	// then you can hardcode this in
	bucketSize     = 1000
	bucketItemSize = bucketSize + 1
)

// either I ran an o(n) loop to make defaults all -1 instead of 0( which collides with value being 0)
// or
// use a ptr to figure out whether a key exists or not
// had to use a custom type for type assertion
// because I could not figure how to initialize nested
// fixed sized array in golang without pre-allocating initially
type myIntVal *int
type MyHashMap struct {
	items [bucketSize]interface{}
}

func Constructor() MyHashMap {
	return MyHashMap{
		// I could not find a better way to "lazy" nested array initialing
		// therefore using interfaces
		// TODO: requires more investigation on my end to find out if there is a cleaner way
		// to do this
		items: [bucketSize]interface{}{},
	}
}

// we will use double hashing to avoid collision of hash results that result to same idx.
// collision is when multiple different keys after hashing point to same idx in array,
// if they do point to same idx in array we will use nested list and double hashing to
// find uniq idx for each colliding key
/*
	time and space: o(1)
*/
func (this *MyHashMap) bucketIdx(key int) int { return key % bucketSize }

// time and space: o(1)
func (this *MyHashMap) bucketItemIdx(key int) int { return key / bucketItemSize }

/*
	time: o(1)
	space: o(1) - but amortized
				- will be o($bucketItemSize) at-least once for each idx
*/
func (this *MyHashMap) Put(key int, value int) {
	bIdx := this.bucketIdx(key)
	bIIdx := this.bucketItemIdx(key)
	if this.items[bIdx] == nil {
		this.items[bIdx] = make([]myIntVal, bucketItemSize)
	}
	this.items[bIdx].([]myIntVal)[bIIdx] = toPtrInt(value)
}

/*
	time and space: o(1)
*/
func (this *MyHashMap) Get(key int) int {
	bIdx := this.bucketIdx(key)
	bIIdx := this.bucketItemIdx(key)
	if this.items[bIdx] == nil || this.items[bIdx].([]myIntVal)[bIIdx] == nil {
		return -1
	}
	return *this.items[bIdx].([]myIntVal)[bIIdx]
}

/*
	time and space: o(1)
*/
func (this *MyHashMap) Remove(key int) {
	bIdx := this.bucketIdx(key)
	bIIdx := this.bucketItemIdx(key)
	if this.items[bIdx] == nil {
		return
	}
	this.items[bIdx].([]myIntVal)[bIIdx] = nil
}
func toPtrInt(n int) *int { return &n }

func main() {
	h := Constructor()
	h.Put(1, 1)
	h.Put(2, 2)
	fmt.Println(h.Get(1)) // 1
	fmt.Println(h.Get(2)) // 2
	fmt.Println(h.Get(3)) // -1 ( key not yet inserted )
	h.Put(2, 1)
	fmt.Println(h.Get(2)) // value updated to 1
	h.Remove(2)
	fmt.Println(h.Get(2)) // -1 , because key was removed

}
