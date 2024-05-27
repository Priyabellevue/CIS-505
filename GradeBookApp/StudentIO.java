package GradeBookApp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.opencsv.CSVWriter;

/* Begin StudentIO Class. */
public class StudentIO {
    /* This sets the file name and creates the file. */
    final private static String FILE_NAME = "grades.csv";
    private static File file = new File(FILE_NAME);

    /* This inserts the entered data into the file. */

    public static void insert(ArrayList<Student> students) throws IOException {
        boolean append = file.exists();
        try (FileWriter output = new FileWriter(FILE_NAME, append);
            CSVWriter writer = new CSVWriter(output)) {
    
            // If file is new, write the header
            if (!append) {
                String[] headers = {"First Name", "Last Name", "Course", "Grade"};
                writer.writeNext(headers);
            }
    
            // Record student data fields for every student
            for (Student student : students) {
                String[] studentData = {
                    student.getFirstName(),
                    student.getLastName(),
                    student.getCourse(),
                    student.getGrade()
                };
                writer.writeNext(studentData);
            }
        } catch (IOException e) {
            throw new IOException("Error writing to the file: " + FILE_NAME, e);
        }
    }
    

        /* This finds all the students and sets those data fields. */
    public static ArrayList<Student> findAll() throws IOException {
        ArrayList<Student> students = new ArrayList<>();
    
        try (Scanner input = new Scanner(new File(FILE_NAME))) {
            boolean isHeader = true;
    
            while (input.hasNextLine()) {
                if (isHeader) {
                    input.nextLine(); // Skip the header line
                    isHeader = false;
                    continue;
                }
    
                String studentLine = input.nextLine();
                String[] studentGrade = studentLine.split(",");
                if (studentGrade.length == 4) {
                    Student student = new Student();
                    student.setFirstName(studentGrade[0]);
                    student.setLastName(studentGrade[1]);
                    student.setCourse(studentGrade[2]);
                    student.setGrade(studentGrade[3]);
                    students.add(student);
                }
            }
        } catch (IOException e) {
            throw new IOException("Error reading from the file: " + FILE_NAME, e);
        }
    
        return students;
    }
    
} /* End Student IO Class. */