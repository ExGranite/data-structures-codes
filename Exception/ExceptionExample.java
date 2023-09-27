public class ExceptionExample{
  public static void main(String [] args){
//    int [] x = new int[5];
//    for(int i = 0;i<=x.length;i++){
//     // System.out.println(x[i]);
//    }
    int b = 10;
    try{
//      int c = b/0;
      System.out.println("Try block");
      methodA();
    }
    catch(ArithmeticException e){
      //e.printStackTrace();
      System.out.println(e + " Artihmetic");
    }catch(MyException d){
      System.out.println(d + " MyException");
    }   
    catch(Exception e){
      System.out.println(e + "General Exception");
    } 
    finally{
      System.out.println("finally block");
    }
    System.out.println("Hello");
  }


public static void methodA() throws MyException{
  int y = 5;
  try{
    if(y==5){
      throw new MyException();
    }
  }finally{
    System.out.println("method finally block");
  }
}
}