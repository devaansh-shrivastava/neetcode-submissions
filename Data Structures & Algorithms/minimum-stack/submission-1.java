class MinStack {
    Node top;
    
    public MinStack() {
        Node n = new Node();
        this.top = n;
        this.top.min = null;
    }
    
    public void push(int val) {
        
        Node n = new Node();
        n.val = val;
        n.pre = this.top;
        n.min = this.top.min;

        if(this.top.min != null && this.top.min.val > n.val) {
            n.min = n;
        } else if (this.top.min == null) {
            n.min = n;
        }

        this.top = n;
        
    }
    
    public void pop() {

        Node p = this.top.pre;
        this.top = p;

    }
    
    public int top() {

        return this.top.val;
    }
    
    public int getMin() {

        return this.top.min.val;
    }

}
private class Node {
    int val;
    Node min;
    Node pre;
}
