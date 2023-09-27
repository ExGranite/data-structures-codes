public class Lab01{
    public void printArray(int[] a){
        int i = 0;
        for( ; i < a.length -1; i++){
            System.out.printf("%d, ", a[i]);
        }
        System.out.println(a[i]);
    }
    public void printReverseArray(int[] a){
        int i = a.length -1;
        for( ; i > 0; i--){
            System.out.printf("%d, ", a[i]);
        }
        System.out.println(a[i]);
    }
    public int[] copyArray(int[] a){
        int[] copy = new int[a.length];
        for(int i = 0; i < a.length; i++){
            copy[i] = a[i];
        }
        return copy;
    }
    public void reverseArray(int[] a){
        int[] reverse = new int[a.length];
        for(int i = 0; i < a.length; i++){
            reverse[a.length-1-i] = a[i];
        }
    }
    public int[] leftShift(int[] a, int k){
        for(int j = 1; j <= k; j++){
            for(int i = 0; i < a.length-1; i++){
                a[i] = a[i+1];
            }
            a[a.length-1] = 0;
        }
        int[] newArray = a;
        return newArray;
    }
    public int[] lefttRotate(int[] a, int k){
        for(int j = 1; j <= k; j++){
            int temp = a[0];
            for(int i = 0; i < a.length-1; i++){
                a[i] = a[i+1];
            }
            a[a.length-1] = temp;
        }
        int[] newArray = a;
        return newArray;
    }
    public int[] rightShift(int[] a, int k){
        for(int j = 1; j <= k; j++){
            for(int i = a.length-1; i > 0; i--){
                a[i] = a[i-1];
            }
            a[0] = 0;
        }
        int[] newArray = a;
        return newArray;
    }
    public int[] rightRotate(int[] a, int k){
        for(int j = 1; j <= k; j++){
            int temp = a[a.length-1];
            for(int i = a.length-1; i > 0; i--){
                a[i] = a[i-1];
            }
            a[0] = temp;
        }
        int[] newArray = a;
        return newArray;
    }
    public void insert(int[] a, int element, int index, int size){
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
    public void remove(int[] a, int element){
        for(int i = 0; i < a.length; i++){
            if(a[i]==element){
                for(int j = i; j < a.length-1; j++){
                    a[j] = a[j+1];
                }
                a[a.length-1] = 0;
            }
        }
    }
}