public class Tester {
    public static void main(String[] ok){
        ListStack st = new ListStack();
        try{
            st.push(4);
            st.push("Hello");
            st.push(55);
            System.out.println(st.peek());
            System.out.println(st.pop());
            System.out.println();
            Object[] a = st.toArray();
            for(int i = 0; i < a.length; i++){
                System.out.println(a[i]);
            }
            System.out.println();
            System.out.println(st.toString());
        }
        catch(Exception e){}
        System.out.println();
        System.out.println(st.size);
        System.out.println();
        parenthesisCheck("1+b*[(2/4)-{6+2}]+2");
        parenthesisCheck("1+b*(2/4)-{6+2]+2");
        parenthesisCheck("1+b*[(2/3)+2");
        parenthesisCheck("1+b*2/4-6)+2+2");
    }
    static void parenthesisCheck(String e) {
        ListStack st = new ListStack();
        for (int i = 0; i < e.length(); i++){
            if (e.charAt(i)=='{'||e.charAt(i)=='('||e.charAt(i)=='['){
                try{
                    st.push(e.charAt(i));
                }
                catch(Exception a){}
            } else if (e.charAt(i)=='}'||e.charAt(i)==')'||e.charAt(i)==']'){
                if (st.size!=0){
                    try {
                        Object u = st.pop();
                        if ((u.toString().charAt(0)=='{'&&e.charAt(i)=='}') || (u.toString().charAt(0)=='('&&e.charAt(i)==')') || (u.toString().charAt(0)=='['&&e.charAt(i)==']')){
                            
                        } else {
                            break;
                        }
                    }
                    catch(Exception a){}
                }else{
                    break;
                }
            } else {
                continue;
            }
        }
        if (st.size==0){
            System.out.println("Correct Expression");
        }else{
            System.err.println("Incorrect Expression");
        }
    }
}