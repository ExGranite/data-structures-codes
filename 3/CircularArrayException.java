public class CircularArrayException extends Exception {
    public String s;
    public CircularArrayException(String a){
        s = a;
    }
    public String toString(){
        return s;
    }
}