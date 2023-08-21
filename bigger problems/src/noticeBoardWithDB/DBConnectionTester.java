package noticeBoardWithDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionTester {
	public static void main(String[] args) {
		Connection cnx = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			cnx = DriverManager.getConnection("jdbc:mysql://localhost: 3306/myDB", "ankan2001prodapt", "we1c@me1");
			stmt = cnx.createStatement();
			rs = stmt.executeQuery("SELECT  * from Notices, contacts where Notices.contactId = contacts.id ORDER BY Notices.date_created DESC");
			System.out.println("Title       Content     Contact-Name     Contact-Phone");
			while(rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				System.out.println(title + "  " + content + "  " + name + "  " + phone);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} 
	}
}