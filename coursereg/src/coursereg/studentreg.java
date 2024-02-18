package coursereg;
import java.util.*;
import java.sql.*;
public class studentreg {
	static Scanner sc=new Scanner(System.in);
	public static class login{
		private static String username;
		private static String password;
		
		public static String getUsername() {
			System.out.println("Enter your username ");
			username=sc.nextLine();
			return username;
		}
		
		public static String getPassword() {
			System.out.println("Enter your password");
			password=sc.nextLine();
			return password;
		}
				}
		public static class studentregister{
			private int stuid;
			private String stuname;
			private String courseid;
			public int getStuid() {
				System.out.println("Enter the student id: ");
				stuid=sc.nextInt();
				return stuid;
			}
			public String getStuname() {
				System.out.println("Enter the student name: ");
				stuname=sc.next();
				return stuname;
			}
			public String getCourseid() {
				System.out.println("Enter the course id you want to register");
				courseid=sc.next();
				return courseid;
			}
			
			
			
			
			
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		login l=new login();
		String username=l.getUsername();
		String password=l.getPassword();

		String url="jdbc:mysql://localhost:3306/student"; //database name";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
					//try/catch blocks are to catch exception for above driver class forname
					try {
				Connection con=DriverManager.getConnection(url, username, password);
				System.out.println("student has logged in sucessfully");
				
				String courseshow="Select * from course";
				String insertquery="insert into student_db values(?, ?, ?)";
				String deletequery="Delete from student_db where stu_id= ?";
				String showquery="select * from student_db where stu_id= ?";
				
				while(true) {
				System.out.println("Enter your choice\n");
				System.out.println("Enter 1 to show the available courses to students\n");
				System.out.println("Enter 2 to register a course\n");
				System.out.println("Enter 3 to delete the registered course\n");
				System.out.println("Enter 4 to show the student registered course\n");
				System.out.println("Enetr 5 to exit from the program\n");
				int ch=sc.nextInt();
					
					if(ch==1) {
						PreparedStatement ps=con.prepareStatement(courseshow);
						ResultSet rs=ps.executeQuery();
						System.out.println("Available courses are");
						while(rs.next()) {
							int courseid=rs.getInt(1);
							String title=rs.getString(2);
							//String Startfrom=rs.getString(3);
							String upto=rs.getString(4);
							int capacity=rs.getInt(5);
							
							System.out.println("corse id: "+courseid);
							System.out.println("title of course is: "+title);
							System.out.println("course start from: "+rs.getString(3));
							System.out.println("course is up to: "+upto);
							System.out.println("the capacity of course is: "+capacity);
							System.out.println("-----------------");
						}
						rs.close();
						
					}else if(ch==2) {
						PreparedStatement ps=con.prepareStatement(insertquery);
						studentregister sr=new studentregister();
						int stuid=sr.getStuid();
						String stuname=sr.getStuname();
						String courseid=sr.getCourseid();
						System.out.println("Enter the details of student");
						ps.setInt(1, stuid);
						ps.setString(2, stuname);
						ps.setString(3, courseid);
						int m=ps.executeUpdate();
						if(m>0) {
							System.out.println("record was added successfully ");
						} else {
							System.out.println("No record was added  ");
						}
						System.out.println("----------");
						
					} else if(ch==3) {
						PreparedStatement ps=con.prepareStatement(deletequery);
						System.out.println("Enter the nuber to delete student record ");
						int stu_id=sc.nextInt();
						ps.setInt(1, stu_id);
						int n=ps.executeUpdate();
						if(n>0) {
							System.out.println("row was deleted successfully");
						} else {
							System.out.println("no record was deleted");
						}
						System.out.println("----------");
						
					} else if(ch==4) {
						PreparedStatement ps=con.prepareStatement(showquery);
						System.out.println("Enter the student id to view details \n ");
						int stu_id=sc.nextInt();
						ps.setInt(1, stu_id);
						ResultSet rs=ps.executeQuery();
						System.out.println("all details ofstudent in database ");
						while(rs.next()) {
							System.out.println("student id: "+rs.getInt(1));
							System.out.println("student name: "+rs.getString(2));
							System.out.println("registered courses: "+rs.getString(3));
							System.out.println("-------------");
						}
						
					} else if(ch==5) {
						System.out.println("the program is terminated \n");
						break;
					} else {
						System.out.println("you entered invalid option ");
					}
										
					
					}
							
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("SQL Exception "+e.getMessage());
				
				//e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Class exception "+e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
