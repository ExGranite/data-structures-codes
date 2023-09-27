public class Test {
    public static void main(String[] args) {
        A1 a = new A1();
        int[] t = {1,-5,-9,2,-6,8};
        a.alternateArray (t);
        for(int i = 0; i < t.length; i++){
        System.out.println(t[i]);
        }
    }
}