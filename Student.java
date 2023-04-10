

public class Student{
    private int age;
    private String name, surname, am;

    //Constructor
    public Student(String name, String surname, int age, String am){
        this.age=age;
        this.name=name;
        this.surname=surname;
        this.am=am;
    }

    //Accessor
    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getAm(){
        return am;
    }

    //Mutators
    public void setAge(){
        this.age=age;
    }

    public void setName(){
        this.name=name;
    }

    public void setSurname(){
        this.surname=surname;
    }

    public void setAm(){
        this.am=am;
    }

   
    //toString
    public String toString(){
        String s;
        s="Student{"+" age= "+age+", name= "+name+", surname= "+surname+", am= "+am+"}"+"\n";
        return s;
    }

}