class MinStack {

        public ArrayList<Integer> list = new ArrayList<>();
       /** initialize your data structure here. */
       public MinStack() {

       }

       public void push(int x) {
          list.add(x);
          
       }

       public void pop() {
         
          list.remove(list.size()-1);
       }

       public int top() {
          return list.get(list.size()-1);
       }

       public int getMin() {
          int min=Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            if(min>list.get(i))
              min=list.get(i);  
        }
           return min;
       }
}
