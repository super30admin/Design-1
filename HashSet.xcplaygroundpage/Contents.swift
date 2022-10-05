// Time complexity O(1)
// Space complexity O(n)

class MyHashSet {
    
    static let kNumberOfHBuckets = 10
    static let kNumberOfVBuckets = 10
    var verticalArray = Array(repeating: [Int.min], count: kNumberOfVBuckets)
    var array: [[Int]]
    
    init() {
        array = []
        for _ in 0...MyHashSet.kNumberOfHBuckets {
            var verticalArray: [Int] = []
            for _ in 0...MyHashSet.kNumberOfVBuckets {
                verticalArray.append(Int.min)
            }
            array.append(verticalArray)
        }
    }
   
    private func horizontalHash(_ key: Int) -> Int {
        return key / MyHashSet.kNumberOfHBuckets
    }
    
    private func verticalHash(_ key: Int) -> Int {
        return key % MyHashSet.kNumberOfVBuckets
    }
    
    
    func add(_ key: Int) {
        let horizontalSpace =  horizontalHash(key)
        let verticalSpace = verticalHash(key)
        array[horizontalSpace][verticalSpace] = key
    }
    
    func remove(_ key: Int) {
        let horizontalSpace =  horizontalHash(key)
        let verticalSpace = verticalHash(key)
        array[horizontalSpace][verticalSpace] = Int.min
    }
    
    func contains(_ key: Int) -> Bool {
        let horizontalSpace =  horizontalHash(key)
        let verticalSpace = verticalHash(key)
        let result = array[horizontalSpace][verticalSpace] == Int.min ? false : true
        return result
    }
    

}

//[,"contains","add","contains"]
//[,[2],[1000000],[1000000]]
 
let obj = MyHashSet()
obj.add(1)
obj.add(2)
obj.contains(1)
obj.contains(3)
obj.add(2)
obj.contains(2)
obj.remove(2)
obj.contains(2)
obj.add(100)
obj.contains(100)



