package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sakila.query.StaffQuery;
import sakila.vo.Staff;

public class StaffDao {
	public Staff selectStaffByKey(Connection conn,Staff staff) throws Exception {
		Staff returnStaff = null;
		
		PreparedStatement stmt = conn.prepareStatment(StaffQuery.SELECT_STAFF_BY_KEY);
		stmt.setSring(1,staff.getEmail());
		stmt.setString(1,staff.getPassword());
		
		ResultSet rs = stmt.executeQuery();
		System.out.println("Debug: rs("+rs+")");
		
		if(rs.next()) {
			returnStaff = new Staff();
			returnStaff.setEmail(rs.getString("email"));
			System.out.println("Debug: email("+rs.getString("email")+")");
			returnStaff.setUsername(rs.getSring("username"));
			System.out.println("Debug: username("+rs.getString("username")+")");
			
		}
	}
}

