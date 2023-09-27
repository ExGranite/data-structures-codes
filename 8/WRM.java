class WRM {
    int id = 0;
    Patient[] array = new Patient[99];
    int size = 0, start = 1;
    
    void RegisterPatient(Patient a){
        array[++id] = a; size++;
        System.out.println("Patient "+a.name +" with ID "+ id +": Please wait in queue.");
    }
    void ServePatient(){
        Patient temp = array[start];
        array[start] = null; start++; size--;
        System.out.printf("Call %s ID %s.%n", temp.name, start-1);
    }//:This method calls a patient to provide hospital service to him/her.
    void CancelAll(){//dequeue all
        array = null; size = 0;
        System.out.println("All further appointments have been cancelled.");
    }//:This method cancels all appointments of the patients so that the doctor can go to lunch.
    boolean CanDoctorGoHome(){
        if(size>0){
            return false;
        }
        return true;
    }//:This method returns true if no one is waiting, otherwise, returns false.
    void ShowAllPatient(){
        System.out.print("IDs sorted according to name of Patients:");
        Patient[] temp = new Patient[array.length];
        for(int i = 0; i < array.length; i++){
            temp[i] = array[i];
        }
        int a = start;
        
        for(int i = 0; i < size; i++){
            int index = a;
            for(int j = index+1; j < start+size; j++){
                if(temp[j]==null){
                    continue;
                }
                if(temp[j].name.compareTo(temp[index].name) < 0){
                    index = j;
                }
            }
            temp[index] = null;
            if(index==a){
                a++;
            }
            
            System.out.print(index + " ");
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