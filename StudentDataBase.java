import java.util.Random;
import java.util.Scanner;
public class StudentDataBase{

    private Student[] students;

    //students array[n]
    public StudentDataBase(int n){
        this.students= new Student[n];
    }

    //elegxos an duo mathites einai idioi kai prosthiki ston pinaka
    public boolean add(Student student){
        boolean added=false;

        for(int i=0; i<this.students.length; i++){
            if(this.students[i] !=null){
                if(this.students[i].getAm().equals(student.getAm())){
                    return false;
                }
            }
        }

        for(int i=0; i<this.students.length; i++){
            if(this.students[i]==null){
                this.students[i]=student;
                added=true;
                break;
            }
        }
        return added;
    }

    //anazitisi me basi to surname
    public Student searchBySurname(String surname){
        for(int i=0; i<this.students.length; i++){
            if(this.students[i]!=null && this.students[i].getSurname().equalsIgnoreCase(surname)){
                return this.students[i];
            }
        }
        return null;
    }

    //diagrafi foithtwn
    public boolean removeStudent(int index){
        if(this.students[index]!=null){
            this.students[index]=null;
            return true;
        }
        return false;
    }

    // count
    public int getStudentCount(){
        int count=0;

        for(int i=0; i<this.students.length; i++){
            if(this.students[i]!=null){
                count+=1;
            }
        }
        return count;
    }

    //toString
    public String toString(){
        String retVal="";
        for(int i=0; i<this.students.length; i++){
            if(this.students[i]!=null){
                retVal+="student["+i+"]= "+this.students[i].toString();
            }
        }
        return retVal;
    }

    //random AM
    public static String generateRandomAM(){
        Random rand = new Random();
        int num = rand.nextInt(900) + 100;
        return Integer.toString(num);
    }

    //random name apo katalogo
    public static String generateRandomFirstNames(){
        String[] firstNames = {"Annie", "Bob", "Olympia", "Eva", "John", "Jacob", "Isabelle", "James","Aspyn"};
        Random rand = new Random();
        String name = firstNames[rand.nextInt(firstNames.length)];
        return name;
    }

    //scan surnames
    public static String[] scanSurNames(int n){
        String[] surnames = new String[n];
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<n; i++){
            System.out.print("Enter complete surname of student " + (i + 1) + ": ");
            String surname = scanner.nextLine();
            surnames[i] = surname;
        }
        return surnames;
    }
    
    //main
    public static void main(String[] args){
    
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        StudentDataBase array = new StudentDataBase(n);
    
        String[] surnames = scanSurNames(n);
    
        for (int i = 0; i < n; i++) {
            String am = generateRandomAM();
            String na = generateRandomFirstNames();
            Student s = new Student(na, surnames[i], rand.nextInt(10) + 18, am);
            Student foundStudent = array.searchBySurname(surnames[i]);
            if (foundStudent != null) {
                System.out.println("Found student: " + foundStudent.toString());
            } else {
                boolean added = array.add(s);
                System.out.println("Added student with surname " + surnames[i] + "? " + added);
            }
        }

        System.out.println("Database contents:\n" + array.toString());

        Student s4 = new Student("Alice", "Wonderland", 22, "001");
        boolean added4 = array.add(s4);
        System.out.println("Added student 4? " + added4);


        System.out.println("Student count: " + array.getStudentCount());
        System.out.println("Database contents:\n" + array.toString());


        boolean removed2 = array.removeStudent(1);
        System.out.println("Removed student 2? " + removed2);

        System.out.println("Student count: " + array.getStudentCount());
        System.out.println("Database contents:\n" + array.toString());

    }


}