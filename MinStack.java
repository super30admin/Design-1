class MinStack {

	public MinStack() {

	}

	private Node head;

	private class Node {
		int val;
		int min;
		Node nextNode;

		public Node(int val, int min, Node nextNode) {
			this.val = val;
			this.min = min;
			this.nextNode = nextNode;
		}

	}

	public void push(int val) {
		if (head == null) {
			head = new Node(val, val, null);
		} else {
			head = new Node(val, Math.min(val, head.min), head);
		}
	}

	public void pop() {
		head = head.nextNode;
	}

	public int top() {
		return head.val;
	}

	public int getMin() {
		return head.min;
	}
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
 * param_4 = obj.getMin();
 */
