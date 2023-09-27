public class Tester{
    public static void main(String []args){
        CircularList circu = new CircularList();
        int[] cir = {4, -1, -1, 3, 2, 1};
        circu.buildFromArray(cir, 3, 4);
        circu.print();//3 2 1 4
        circu.buildReverse();
        circu.print();//4 1 2 3
        circu.addElement(7, 0);
        circu.print();//7 4 1 2 3
        circu.addElement(8, 4);
        circu.print();//7 4 1 2 8 3
        circu.deleteElement(5);
        circu.print();//7 4 1 2 8
    }
}