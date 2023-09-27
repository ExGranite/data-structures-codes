public class CircularArray{
    
    private int start;
    private int size;
    private Object [] cir;
    
    public CircularArray(Object [] lin, int st, int sz){
        start = st; size = sz;
        cir = new Object[lin.length];
        for(int i = 0; i < lin.length; i++){
            cir[st]= lin[i];
            st = (st+1)%cir.length;
        }
    }
    
    public void printFullLinear(){
        int i = 0;
        for( ; i < cir.length-1; i++){
            System.out.printf("%s ,",cir[i]);
        }
        System.out.println(cir[i]);
    }
    
    public void printForward(){
        int st = start;
        for(int i = 1; i < size; i++){
            System.out.printf("%s ,",cir[st]);
            st = (st+1)%cir.length;
        }
        System.out.println(cir[st]);
    }
    
    public void printBackward(){
        int end = (start + size -1)%cir.length;
        for(int i = 0; i < size-1; i++){
            System.out.printf("%s ,",cir[end]);
            end--;
            if(end < 0){
                end = cir.length-1;
            }
        }
        System.out.println(cir[end]);
    }
    
    public void linearize(){
        Object[] lin = new Object[size];
        int st = start;
        for(int i = 0; i < lin.length; i++){
            lin[i] = cir[st];
            st = (st+1)%cir.length;
        }
        cir = lin;
        start = 0;
    }
    
    public void resizeStartUnchanged(int newcapacity){
        Object[] a = new Object[newcapacity];
        int i = start;
        int j = start;
        for(int k = 1; k <= size; k++){
            a[i]=cir[j];
            i = (i+1)%a.length;
            j = (j+1)%cir.length;
        }
        cir = a;
    }
    
    public void resizeByLinearize(int newcapacity){
        linearize();
        Object[] a = new Object[newcapacity];
        for(int i = 0; i < cir.length; i++){
            a[i] = cir[i];
        }
        cir = a;
    }
    
    public void insertByRightShift(Object elem, int pos){
        if(size==cir.length){
            resizeStartUnchanged(cir.length+3);
        }
        int shiftStart = start + pos;
        int shiftEnd = start + size;
        while(shiftEnd > shiftStart){
            cir[shiftEnd%cir.length] = cir[(shiftEnd -1)%cir.length];
            shiftEnd--;
        }
        cir[(start+pos)%cir.length] = elem;
        size++;
    }
    
    public void insertByLeftShift(Object elem, int pos){
        if(size==cir.length){
            resizeStartUnchanged(cir.length+3);
        }
        int shiftEnd = start + pos;
        int shiftStart = start;
        while(shiftStart <= shiftEnd){
            cir[(shiftStart -1)%cir.length] = cir[(shiftStart)%cir.length];
            shiftStart++;
        }
        cir[shiftEnd%cir.length] = elem;
        size++;
        start--;
        if(start < 0){
            start = cir.length-1;
        }
    }
    
    public void removeByLeftShift(int pos){
        int shiftStart = start + pos;
        for(int i = size - pos; i > 0; i-- ){
            cir[shiftStart] = cir[(shiftStart + 1)%cir.length];
            shiftStart = (shiftStart+1)%cir.length;
        }
        cir[shiftStart] = null;
        size--;
    }
    
    public void removeByRightShift(int pos){
        int shiftEnd = start + pos;
        int shiftStart = start;
        while(shiftEnd > shiftStart){
            cir[shiftEnd%cir.length] = cir[(shiftEnd -1)%cir.length];
            shiftEnd--;
        }
        cir[start] = null;
        size--;
        start++;
        if(start > cir.length-1){
            start = 0;
        }
    }
    
    public void palindromeCheck(){
        boolean a = true;
        int i = start;
        int end = (start+size-1)%cir.length;
        for(int j = 1; j < (size/2); j++){
            if(cir[i]!=cir[end]){
                a = false; break;
            }
            i = (i+1)%cir.length;
            end--;
            if(end < 0){
                end = cir.length-1;
            }
        }
        if(a==true){
            System.out.println("This array is a palindrome.");
        }else{
            System.out.println("This array is NOT a palindrome.");
        }
    }
    
    
//This method will sort the values by keeping the start unchanged
    
    public void sort(){
        for(int i = 0; i < size; i++){
            int j = start;
            int end = (start+size-1)%cir.length;
            while(j<(start+size-1)){
                if(cir[((j+1)%cir.length)]!=null && cir[j]!=null && (Integer.parseInt(cir[j]+"") > Integer.parseInt(cir[((j+1)%cir.length)]+""))){
                    Object temp = cir[j];
                    cir[j] = cir[((j+1)%cir.length)];
                    cir[((j+1)%cir.length)] = temp;
                }
                j = (j+1)%cir.length;
                if(j==end+1){
                    break;
                }
            }
        }
    }
    
    public boolean equivalent(CircularArray k){
        int ciri = start; int cirki = k.start;
        for(int i = 1; i <= size; i++){
            if(cir[ciri]!=k.cir[cirki]){
                return false;
            }
            ciri = (ciri+1)%cir.length;
            cirki = (cirki+1)%k.cir.length;
        }
        return true;
    }
}