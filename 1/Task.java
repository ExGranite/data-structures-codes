public class Task {
    public static void main(String[] a){
        int[] k = {64, 6, 2, 77, 2324};
        for(int i =0; i < k.length-1; ++i){
            for(int j = i+1; j<k.length; ++j){
                if(k[i]>k[j]){
                    int temp = k[i];
                    k[i] = k[j];
                    k[j] = temp;
                }
            }
        }
        for(int i = 0; i < k.length; i++){
            System.out.println(k[i]);
        }
    }
}