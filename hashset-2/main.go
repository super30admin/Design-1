package main

import "fmt"

type MyHashSet struct {
	hashset [][]bool
	inner   int
	outer   int
}

func Constructor() MyHashSet {
	hs := MyHashSet{}
	// How did we come to this conclusion that outer and inner are going to be the below values?
	// that was basically decided by the range/number of elements that need to be stored in the HashSet and was given in the question
	hs.outer = 1000
	hs.inner = 1000
	// init outer array
	hs.hashset = make([][]bool, hs.outer)
	// loop over the inner length and init inner array. every value will be false by default
	for i := 0; i < hs.inner; i++ {
		if i == 0 {
			// handing edge case of 1000000 as while inserting it we will have a collision
			hs.hashset[i] = make([]bool, hs.inner+1)
			continue
		}
		hs.hashset[i] = make([]bool, hs.inner)
	}
	return hs
}

func (this *MyHashSet) outerHash(val int) int {
	return val % this.outer
}

func (this *MyHashSet) innerHash(val int) int {
	return val / this.inner
}

func (this *MyHashSet) Add(key int) {
	outerIndex := this.outerHash(key)
	innerIndex := this.innerHash(key)
	if this.hashset[outerIndex][innerIndex] == false { // meaning this value is not there, as by default bool is false
		this.hashset[outerIndex][innerIndex] = true
	}
}

func (this *MyHashSet) Remove(key int) {
	outerIndex := this.outerHash(key)
	innerIndex := this.innerHash(key)
	if this.hashset[outerIndex][innerIndex] == true {
		// means that the key is there and I can set that to false now as I am removing it
		this.hashset[outerIndex][innerIndex] = false
	} else {
		fmt.Println("requested key does not exit in map")
	}
}

func (this *MyHashSet) Contains(key int) bool {
	outerIndex := this.outerHash(key)
	innerIndex := this.innerHash(key)
	return this.hashset[outerIndex][innerIndex]
}

func main() {
	obj := Constructor()
	obj.Add(1)
	obj.Add(2)
	obj.Contains(1)
	fmt.Println("Is 3 present in hashset : ", obj.Contains(3))
	for i := 0; i < obj.outer; i++ {
		for j := 0; j < obj.inner; j++ {
			if obj.hashset[i][j] == true {
				fmt.Println(i, j)
			}
		}
	}
}
