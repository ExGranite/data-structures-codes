public class Tester {
    public static void main(String[] args) {
        Patient a = new Patient("A", 2, "A+");
        Patient b = new Patient("B", 63, "B+");
        Patient c = new Patient("C", 55, "O+");
        Patient d = new Patient("D", 42, "A-");
        Patient e = new Patient("E", 82, "B-");
        Patient f = new Patient("F", 25, "O-");
        Patient g = new Patient("G", 26, "AB+");
        Patient h = new Patient("H", 96, "AB-");
        
        WRM manage = new WRM();
        
        manage.RegisterPatient(a);
        manage.RegisterPatient(f);
        manage.RegisterPatient(e);
        manage.ShowAllPatient();
        manage.ServePatient();
        manage.ShowAllPatient();
        System.out.println(manage.CanDoctorGoHome());
        manage.RegisterPatient(c);
        manage.RegisterPatient(g);
        manage.ShowAllPatient();
        manage.ServePatient();
        manage.ServePatient();
        manage.ShowAllPatient();
        System.out.println(manage.CanDoctorGoHome());
        manage.CancelAll();
        System.out.println(manage.CanDoctorGoHome());
    }
}