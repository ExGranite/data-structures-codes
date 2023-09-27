public class TestCircularArray{
    
    String [] cir;
    int size;
    int start;
    
    public TestCircularArray(String[]lin, int st, int sz){
        start = st; size = sz;
        cir = new String[lin.length];
        for(int i = 0; i < lin.length; i++){
            cir[st]= lin[i];
            st = (st+1)%cir.length;
        }
        display();
        
    }
    
    public void sort(){
        for(int i = 0; i < size; i++){
            int j = start;
            while(j<(start+size-1)){
                if(Integer.parseInt(cir[j]) > Integer.parseInt(cir[j+1])){
                    String temp = cir[j];
                    cir[j] = cir[j+1];
                    cir[j+1] = temp;
                }
                j = (j+1)%cir.length;
            }
        }
        display();
    }
    
    public int countOdd(){
        int count = 0; int st = start;
        for(int i =0;i<size;i++){
            String word = cir[st];
            int num = 0;
            for(int j=0;j<word.length();j++){
                num = num + (int)(word.charAt(j));
            }
            if (num%2!=0){
                count++;
            }
            st = (st+1)%cir.length;
        }
        return count;
    }
    
    public int countEven(){
        int count = 0; int st = start;
        for(int i =0;i<size;i++){
            String word = cir[st];
            int num = 0;
            for(int j=0;j<word.length();j++){
                num = num + (int)(word.charAt(j));
            }
            if (num%2==0){
                count++;
            }
            st = (st+1)%cir.length;
        }
        return count;
    }
    
    public void insert(String item,int offset) throws CircularArrayException{
        if (offset<0 || offset>size){
            throw new CircularArrayException("Invalid offset");
        }
        if (size==cir.length){
            throw new CircularArrayException("Array full");
        }
        int shiftEnd = start + offset;
        int shiftStart = start;
        while(shiftStart <= shiftEnd){
            cir[(shiftStart -1)%cir.length] = cir[(shiftStart)%cir.length];
            shiftStart++;
        }
        cir[shiftEnd%cir.length] = item;
        size++;
        start--;
        if(start < 0){
            start = cir.length-1;
        }
        display();
    }
    
    public String delete (int offset)throws CircularArrayException{
        int shiftEnd = start + offset;
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
        display();
        return null;
    }
    
    public void display(){
        int i = 0;
        int st = start;
        while(i<size){
            System.out.print(cir[st]+" ");
            i++;
            st = (st+1)%cir.length;
        }
        System.out.println();
    }
}