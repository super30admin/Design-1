class DesignHashSet {
    //Time complexity: Log N
    class TreeNode{
        TreeNode right;
        TreeNode left;
        int val;

        TreeNode(int val){
            this.val = val;
        }
    }

    class Bucket{
        private TreeNode root;

        Bucket(){
            this.root = null;
        }

        public void insert(int key){
            System.out.println("inserting "+key);
            root= helperInsert(root, key);
        }
        private TreeNode helperInsert(TreeNode cur, int key){
            if(cur == null) return new TreeNode(key);

            if(cur.val < key) cur.left = helperInsert(cur.left, key);
            else{
                cur.right = helperInsert(cur.right, key);}

            return cur;

        }

        public boolean get(int key){
            return traverse(root, key);
        }
        private boolean traverse(TreeNode node, int key){
            if(node == null) return false;
            if(node.val == key) return true;
            if(node.val < key) return traverse(node.left, key);
            else return traverse(node.right, key);
        }
        public void remove(int key){
            root= helperRemove(root, key);
        }

        private TreeNode helperRemove(TreeNode node, int key){
            if(node == null) return null;

            node.left = helperRemove(node.left, key);
            node.right = helperRemove(node.right, key);

            if(node.val == key){

                if(node.right == null){
                    node = node.left;
                }
                else{
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    while(right.left != null) right = right.left;
                    right.left = left;
                    node = node.right;
                }
            }

            return node;
        }
    }

    int hash = 2069;
    Bucket[] bucket;
    public DesignHashSet() {
        bucket = new Bucket[hash];
        for(int i =0; i< hash; i++){
            bucket[i] = new Bucket();
        }
    }

    public void add(int key) {
        bucket[(key%hash)].insert(key);
    }

    public void remove(int key) {
        bucket[(key%hash)].remove(key);
    }

    public boolean contains(int key) {
        return bucket[(key%hash)].get(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */