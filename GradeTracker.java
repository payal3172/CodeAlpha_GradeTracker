//import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
//class student related information 
class Student{
    private ArrayList<Integer> grades = new ArrayList<>();

    private String studentName;
    private int studentRoll;
    private String studentDepartment;
    //private int studentMarks;
    private int studentGrade;

      public Student(String studentName,int studentRoll,String studentDepartment,int studentGrade){
        this.studentName = studentName;
        this.studentRoll = studentRoll;
        this.studentDepartment = studentDepartment;
        //this.studentMarks = studentMarks;
        this.studentGrade = studentGrade;
    }
    
//call Getter Setter Methods
    public String StudentName(){
        return studentName;
    }
    public int StudentRoll(){
        return studentRoll;
    }
    public String StudentDepartment(){
        return studentDepartment;
    }
    /*public int StudentMarks(){
        return studentMarks;
    }*/
    public int StudentGrade(){
    return studentGrade;
   }


    public void addGrade(int studentGrade){
        grades.add(studentGrade);
    }
    //Average
    public double getAverage(){
        if(grades.isEmpty())
            return 0;
        int sum = 0;
        for(int studentGrade : grades){
            sum += studentGrade;
        }
        return (double)  sum / grades.size();
    }
    //Highest
    public int getHighest(){
        int highest = Integer.MIN_VALUE;
        for(int studentGrade : grades){
            if(studentGrade > highest) highest = studentGrade;
        }
        return highest;
    }
    //Lowest
    public int getLowest(){
        int lowest = Integer.MAX_VALUE;
        for(int studentGrade : grades){
            if(studentGrade < lowest) lowest = studentGrade;
        }
        return lowest;
    }
}
public class GradeTracker{
    
       static Scanner sc = new Scanner(System.in);
        static ArrayList<Student> students = new ArrayList<> ();
        public static void main(String[] args) {
                while(true){
                    System.out.println("============STUDENT GRADE TRACKER============");
                    System.out.println("1.Add student and Grades");
                    System.out.println("2.Display Summary Report");
                    System.out.println("3.Exit");
                    System.out.println("choose an option:");

                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch(choice){
                        case 1 :
                            addStudent();
                            break;
                        case 2 :
                            displaySummary();
                            break;
                        case 3 :
                            System.out.println("Existing Programme");
                            System.exit(0);
                        default : 
                            System.out.println("Invalid choice");
                    }
                }
            }
            private static void addStudent(){
                System.out.println("Enter Student Name:");
                String studentName = sc.nextLine();
                //Student student = new Student(studentName);

                System.out.println("Enter Student Roll Number:");
                int studentRoll = sc.nextInt();
                sc.nextLine();
               // Student student1 = new Student(studentRoll);

                System.out.println("Enter Student Department:");
                String studentDepartment = sc.nextLine();
                sc.nextLine();
                //Student student2 = new Student(studentDepartment);

                System.out.println("Enter Student Grade:");
                int studentGrade = sc.nextInt();
                sc.nextLine();
                //Student student3 = new Student(studentGrade);
                Student student = new Student(studentName, studentRoll, studentDepartment, studentGrade);
               
                System.out.println("Enter grades for"+ studentName +"(type -1 to stop:)");
            
                while(true){
                    System.out.print("Grade:");
                    int grade = sc.nextInt();
                    //sc.nextLine();
                    if (grade == -1) break;
                    if(grade < 0 || grade >100){
                        System.out.println("Invalid Grade . Enter between 0 & 100");
                    }else{
                        student.addGrade(grade);
                    }
                }
                sc.nextLine();
                //Student student = new Student(studentName, studentRoll, studentDepartment, studentGrade);
                students.add(student);
            }
        
            private static void displaySummary(){
                if(students.isEmpty()){
                    System.out.println("No students available");
                    return;
                }
                System.out.println("==========SUMMARY REPORT===========");
                for(Student student : students){
                    System.out.println("Name:"+student.StudentName());//its private so access by Getter methods
                    System.out.println("RollNO:"+student.StudentRoll());
                    System.out.println("Department:"+student.StudentDepartment());
                    System.out.println("Grades:"+student.StudentGrade());
                    System.out.printf("Average:%.2f",+student.getAverage());
                    System.out.println();
                    System.out.println("Highest:"+student.getHighest());
                    System.out.println("Lowest:"+student.getLowest());
                    System.out.println("--------------------------------------");
                
                }

            }
        }
    