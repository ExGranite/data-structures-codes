public class ListStack implements Stack{
    int size;
    Node top;
    
    
    public ListStack(){
        size = 0;
        top = null;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        if(size==0)
            return true;
        return false;
    }
    
    public void push(Object e) throws StackOverflowException {
        Node n = new Node(e, null);
        n.next = top;
        top = n;
        size++;
    }
    
    public Object pop() throws StackUnderflowException {
        if(size==0)
            throw new StackUnderflowException();
        Object temp = top.val;
        top = top.next;
        size--;
        return temp;
    }
    
    public Object peek() throws StackUnderflowException {
        return top.val;
    }
    
    public String toString(){
        String a = "";
        for(Node n = top; n!=null; n=n.next){
            a += n.val + " ";
        }
        return a;
    }
    
    public Object[] toArray() {
        Object[] a = new Object[size];
        Node n = top;
        for(int i = 0; i < a.length; i++){
            a[i] = n.val;
            n = n.next;
        }
        return a;
    }
    
    public int search(Object e) {
        Node n = top;
        int offset = 0;
        for( ; n!=null; n=n.next){
            if(e==n.val){
                return offset;
            }
            offset++;
        }
        return -1;
    }
}