class MinStack {
    constructor() {
        this.st = new Array()
        this.minSt = new Array()
        this.counter = -1
        this.minCounter = 0
        this.min = Number.MAX_SAFE_INTEGER;
        this.minSt.push(this.min)
    }

    push(val) {
        const calMin = Math.min(this.min, val)
        this.st.push(val)
        this.minSt.push(calMin)
        this.counter = this.counter + 1
        this.minCounter = this.minCounter + 1
        this.min = calMin
    }

    pop() {
        this.st.pop()
        this.minSt.pop()
        this.counter = this.counter - 1
        this.minCounter = this.minCounter - 1
        this.min = this.minSt[this.minCounter]
    }

    top() {
        return this.st[this.counter]
    }

    getMin() {
        return this.min
    }
}