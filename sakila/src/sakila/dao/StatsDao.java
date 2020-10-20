package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sakila.vo.Stats;

public class StatsDao {
	// rs.next()있으면 true, 없으면 false
	public Stats selectDay(Connection conn, Stats stats) throws Exception {
		System.out.print("debug: method-begin: StatsDao.selectStatsOne()");
		System.out.print("debug: method-parameter: paramStats="+paramStats);
		
		Stats returnStats = null;
		
		PreparedStatememt stmt = conn.prepareStatememt(StatsQuery.SELECT_DAY);
		stmt.setString(1, paramStats.getDay());
		System.out.print("debug: instace-variable: stmt="+stmt");
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			returnStats = new Stats();
			returnStats.setDay(rs.getNString("day"));
			returnStats.setCount(rs.getLong("count"));
		}
		System.out.print("debug: method instance-variable: returnStats="returnStats);
		System.out.print("debug: method-end: StatsDao.selectStatsOne()");
		return returnStats; // insert
	}
	
	// paramStats 로 받아온 날짜의 방문자 수를 1로 초기화
	public void insertStats(Connection conn, Stats stats) throws Exception {
		System.out.print("debug: method-begin: StatsDao.insertStats()");
		System.out.print("debug method-parameter: paramStats"+paramStats);
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.UPDATE_STATS);
		stmt.setNString(1, paramStats.getDay());
		System.out.println("debug: instance-variable: stmt="+stmt);
		
		int updatedRow = stmt.executeUpdate();
		System.out.print("debug: instance-variable: updateRow"+updatedRow);
		
		System.out.print("debig: method-end: StatsDao.insertStats()");
		
	}
}
	//
	