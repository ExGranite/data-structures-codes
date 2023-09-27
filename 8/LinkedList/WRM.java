class WRM {
    Node head;
    Node tail;
    int id = 0;
    int size = 0;
    
    void RegisterPatient(Patient a){
        Node n = new Node(a, null, ++id);
        if(head == null){
            head = n; tail = n;
        } else {
            tail.next = n; tail = n;
        }
        size++;
        System.out.printf("Patient %s with ID %d: Please wait in queue.%n", n.e.name, n.id);
    }
    void ServePatient(){
        System.out.printf("Call Patient %s with ID %d.%n", head.e.name, head.id);
        Node temp = head;
        head = head.next;
        temp = null;
    }
    void CancelAll(){//dequeue all
        head = null;
        tail = null;
        size = 0;
        System.out.println("All further appointments have been cancelled.");
    }
    boolean CanDoctorGoHome(){
        if(size>0)
            return false;
        return true;
    }
    void ShowAllPatient(){
        System.out.print("IDs of remaining patients in accordance to their names: ");
        for(Node n = head; n != null; n=n.next){
            Node temp = n;
            for(Node a = n.next; a != null; a=a.next){
                if(a.e.name.compareTo(n.e.name) < 0){
                    temp = a;
                }
            }
            System.out.print(temp.id + " ");
        }
        System.out.println();
    }//:This method shows all ids of the waiting patients in SORTED order. (Hint: use the sorting methods learnt in class using the appropriate data-structure for each task) [Sorted according to their names]
}

class Patient {
    String name, blood;
    int age;
    Patient(String n, int a, String b){
        name = n; age = a; blood = b;
    }
}

class Node {
    Patient e;
    Node next;
    int id;
    Node(Patient element, Node n, int i){
        e = element; next = n; id = i;
    }
}