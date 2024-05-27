/* Zuck, C. (2022). CIS 505 Intermediate Java Programming. Bellevue University. */

package GradeBookApp;
/* Begin Student class. */
public class Student {
    /* These are the attributes of a student. */
    private String firstName;
    private String lastName;
    private String course;
    private String grade;

    /* This is the default constructor. */
    public Student(){
    }

    /* This is an argument constructor. */
    public Student (String studentFName, String studentLName, String studentCourse, String studentGrade){
        this.firstName = studentFName;
        this.lastName = studentLName;
        this.course = studentCourse;
        this.grade = studentGrade;
    }

    /* Mutator Methods. */
    /* This method sets a student's first name. */
    public void setFirstName(String newFName){
        this.firstName = newFName;
    }
    /* This method sets a student's last name. */
    public void setLastName(String newLName){
        this.lastName = newLName;
    }
    /* This method sets the course the student is in. */
    public void setCourse(String newCourse){
        this.course = newCourse;
    }
    /* This method sets the student's grade. */
    public void setGrade(String newGrade){
        this.grade = newGrade;
    }

    /* Accessor Methods. */
    /* This method gets the student's first name. */
    public String getFirstName(){
        return firstName;
    }
    /* This method gets the student's last name. */
    public String getLastName(){
        return lastName;
    }
    /* This method gets the student's course. */
    public String getCourse(){
        return course;
    }
    /* This method gets the student's grade. */
    public String getGrade(){
        return grade;
    }

    /* This overrides the toString method. */
    public String toString(){
        return "First Name: "+firstName+"\nLast Name: "+lastName+"\nCourse: "+course+"\nGrade: "+grade;
    }
} /* End Student class. */