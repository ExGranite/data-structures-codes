public class A2{
    public boolean palindrome (int [] cir, int start, int size){
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
        return a;
    }
    
    public void remove (int [] cir, int start, int size, int elem){
        int a = start;
        int sizeCount = 0;
        for(int i = 1; i <= size; i++){
            if(cir[a]==elem){
                int shiftStart = a;
                for(int k = size + start - a; k > 0; k-- ){
                    cir[shiftStart] = cir[(shiftStart + 1)%cir.length];
                    shiftStart = (shiftStart+1)%cir.length;
                }
                a--;
                sizeCount++;
            }
            a = (a+1)%cir.length;
        }
        size-=sizeCount;
            
        for(int i = 0; i < cir.length; i++){
                System.out.println(cir[i]);
            }
        
    }
}