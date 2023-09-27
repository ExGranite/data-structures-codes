import java.util.Arrays;
public class Student{
    private String name;
    private String id;
    private String currentSemester;
    private String[]courses;
    private int i = 0;
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return id;
    }
    
    public void setSemester(String semester){
        currentSemester = semester;
    }
    
    public void createCourses(int x){
        courses = new String[x];
    }
    
    public boolean addCourse(String course){
        if (i<courses.length){
            courses[i] = course;
            i++;
            return true;
        }else{
            System.out.println("Cannot add more courses");
            return false;
        }
    }
    
    public boolean dropCourse(String course){
        int index=-1;
        for(int x = 0; x < courses.length; x++){
            if (course.equals(courses[x])){
                index = x;
                break;
            }
        }
        if (index==-1){
            return false;
        }else{
            for(int x = index;x<courses.length-1;x++){
                courses[x] = courses[x+1];
            }
            courses[courses.length-1] = null;
            i--;
            return true;
        }
    }
    
    public void viewDetails(){
        System.out.println("+++++++++++++++++++++++");
        System.out.println("Name: "+name);
        System.out.println("Id: "+id);
        System.out.println("Current Semester: "+currentSemester);
        System.out.println(Arrays.toString(courses));
        System.out.println("+++++++++++++++++++++++");
    }
}