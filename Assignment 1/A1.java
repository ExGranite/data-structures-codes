class A1{
    public void remove(Object[] obj, int index, int size){
        for(int i = index; i < obj.length-1; i++){
            obj[i] = obj[i+1];
        }
        obj[obj.length - 1] = null;
        size--;
    }
    public void insert(Object []a, int index, int size, int element){
        if(size == a.length){
            System.err.println("No more capacity");
        } else {
            for(int i = size; i > index; i--){
                a[i] = a[i+1];
            }
            a[index] = element;
            size++;
        }
    }
    public void leftShift(Object []a, int k){
        for(int j = 1; j <= k; j++){
            for(int i = 0; i < a.length-1; i++){
                a[i] = a[i+1];
            }
            a[a.length-1] = null;
        }
    }
    public void rightRotate(Object []a, int k){
        for(int j = 1; j <= k; j++){
            Object temp = a[a.length-1];
            for(int i = a.length-1; i > 0; i--){
                a[i] = a[i-1];
            }
            a[0] = temp;
        }
    }
    public boolean pairSumFound (int []a, int sum){
        for(int i = 0; i < a.length-1; i++){
            for(int j = i+1; j < a.length; j++){
                int testSum = a[i] + a[j];
                if(testSum == sum){
                    return true;
                }
            }
        }
        return false;
    }
    public void alternateArray (int []a){
        for(int index = 0; index < a.length; ){
            for(int j = index; j < a.length; j++){
                if(a[j]>0){
                    int temp = a[j];
                    for(int k = j; k > index; k--){
                        a[k] = a[k-1];
                    }
                    a[index] = temp;
                    break;
                }
            } index++;
            for(int j = index; j < a.length; j++){
                if(a[j]<0){
                    int temp = a[j];
                    for(int k = j; k > index; k--){
                        a[k] = a[k-1];
                    }
                    a[index] = temp;
                    break;
                }
            } index++;
        }
    }
    public void squareArray (int []a){
        int temp = a[a.length-2];
        for(int i = 0; i < a.length-1; i++){
            a[i] = a[i+1]*a[i+1];
        }
        a[a.length-1] = temp*temp;
    }
}