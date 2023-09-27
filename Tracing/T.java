class C {
    void t() {
        System.out.println("w");
    }
    protected void p(String p) {
        System.out.println(p);
    }
}
class L extends C {
    void t(String m) {
        System.out.println("q");
    }
}
class B extends C {
    String p;
    B(String p) { 
        this.p = p; 
    }
    protected void t() {
        System.out.println("e");
    }
    protected void p() {
        super.p(p);
        System.out.println("n");
    }
}
public class T {
    public static void main(String[] args) {
        L i = new L();
        i.t();
        C s = new B("r");
        s.t();
        ((B) s).p();
        new L().t("a");
    }
}