package sakila.dao;

import java.sql.Connection;
import sakila.vo.Stats;

public class StatsDao {
	// rs.next()있으면 true, 없으면 false
	public Stats selectDay(Connection conn, Stats stats) throws Exception {
		
		Stats returnStats = new Stats();
		if(rs.next()) {
			returnStats = new Stats();
			
		}
		return returnStats; // insert
	}
	//
	public void insertStats(Connection conn, Stats stats) throws Exception {
		
	}
	//
	public void updateStats(Connection conn) throws Exception {
		
	}
}