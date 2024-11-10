package Java_mysql;
import java.sql.*;
import java.util.Scanner;

public class connect {
	public static void main(String args[]){
		Connection c = null;
		Statement sm = null;
		String query;
		String USER = "root";
		String PASS = "Jenil_7828";
		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost:3306/classroom";
		try{
			Class.forName(JDBC_DRIVER);
			c=DriverManager.getConnection(DB_URL,USER,PASS);
			sm = c.createStatement();
			int ch;
			String sql;
			Scanner s = new Scanner(System.in);
			do {
				System.out.println("Enter Choice\n 1.Insert \n 2.Select \n 3.Update \n 4.Delete \n 5.Exit");
				ch=s.nextInt();
				switch (ch) {
					case 1:
						sql ="Insert into Student values (1, 'Jenil')";
						sm.executeUpdate(sql);
						System.out.println("Record is Inserted");
						break;
					case 2:
						sql ="Select * FROM Student";
						ResultSet rs = sm.executeQuery(sql);
						while(rs.next()){
						int rno1 = rs.getInt("Stud_ID");
						String name1 = rs.getString("Stud_Name");
						System.out.println("Stud_ID:" + rno1);
						System.out.println("Stud_Name:" + name1);
						}
						break;
					case 3:
						sql ="UPDATE Student set Stud_Name='Manas' where Stud_ID= 1";
						sm.executeUpdate(sql);
						System.out.println("Record is Updated");
						break;
					case 4:
						sql ="delete from studENT where Stud_ID = 1";
						sm.executeUpdate(sql);
						System.out.println("Record is Deleted");
						break;
				}
			}while(ch<5);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}