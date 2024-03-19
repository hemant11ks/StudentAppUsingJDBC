import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException {
		
	   // Load the driver class.
	   // Create connection using DriverManager.
	   // Use Connection to fire queries {Statement is used for static queries whereas PreparedStament is used for
	   // dynamic queries}
	   // Process the result or ResultSet.
	   // Close the connection
		
		System.out.println("Hello Welcome to the Studentmanagement App !");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			System.out.println("PRESS 1 to ADD Student");
			System.out.println("PRESS 2 to Delete Student");
			System.out.println("PRESS 3 to Update Student");
			System.out.println("PRESS 4 to Display Student");
			System.out.println("PRESS 5 to Exit Student App");
			int c = Integer.parseInt(br.readLine());
			
			if(c==1) {
				// Add Student
				System.out.println("Enter Student Id :");
				int id = Integer.parseInt(br.readLine());
				
				System.out.println("Enter Student Name :");
				String name = br.readLine();
				
				System.out.println("Enter Student Phone :");
				String phone = br.readLine();
				
				System.out.println("Enter Student City :");
				String city = br.readLine();
				
				
				// Create student object to store student
				Student st = new Student(id,name,phone,city);
				boolean answer  = StudentDao.insertStudentToDB(st);
				if(answer) {
					System.out.println("Student is added successfully...");
				}
				else {
					System.out.println("Something went wrong try again...");
				}
				System.out.println(st);
					
				
			}
			else if(c==2) {
				// Delete Student
				System.out.println("Enter student id to delete: ");
				int userId = Integer.parseInt(br.readLine());
				boolean f =  StudentDao.deleteStudent(userId);
				if(f) {
					System.out.println("Student is Deleted successfully...");
				}
				else {
					System.out.println("Something went wrong try again...");
				}
				
			}
			else if(c==3) {
				 System.out.println("Enter Student Id you want to update:");
				    Scanner scanner1 = new Scanner(System.in);
				    int sid = scanner1.nextInt(); 
				    boolean updated = StudentDao.updateStudentInDB(sid); // Pass sid as an argument
				    if(updated) {
				        System.out.println("Student information updated successfully.");
				    } else {
				        System.out.println("Failed to update student information.");
				    }
				
			}
			else if(c==4) {
				// Display Student
				StudentDao.showAllStudent();
				
			}
			else if(c==5) {
				// Exit Studentapp
				break;
			}else {
				
			}
		}
        System.out.println("Thankyou for using the Application");
        System.out.println("See you soon...");


	}

}
