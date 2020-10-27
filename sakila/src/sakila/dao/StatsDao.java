package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sakila.query.StatsQuery;
import sakila.vo.Stats;

public class StatsDao {
	public int selectTotalCount(Connection conn) throws Exception{
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_TOTAL_COUNT);
		ResultSet rs = stmt.executeQuery();
		int totalCount=0;
		if(rs.next()) {
			totalCount = rs.getInt("SUM(count)");
		}
		rs.close();
		stmt.close();
		return totalCount;
	}
	// paramStats의 날짜를 받아와 그날 접속자 판별 메소드
	public Stats selectStatsOne(Connection conn, Stats paramStats) throws Exception {
		System.out.print("debug: method: StatsDao.selectStatsOne()");
		System.out.print("debug: method-parameter: paramStats="+paramStats);
		
		Stats returnStats = null;
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_DAY);
		stmt.setNString(1, paramStats.getDay());
		System.out.print("debug: instance-variable: stmt"+stmt);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			returnStats = new Stats();
			returnStats.setDay(rs.getString("day"));
			returnStats.setCount(rs.getLong("Count"));
		}
		System.out.print("debug: instance-variable: returnStats="+returnStats);
		
		System.out.print("debug: method-end: StatsDao.selectStatsOne()");
		return returnStats;
	}
	public void insertStatsCountOne(Connection conn, Stats paramStats) throws Exception {
		System.out.print("debug: method-begin: StatsDao.insertStats()");
		System.out.print("debug: method-parameter: paramStats="+paramStats);
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.INSERT_STATS);
		stmt.setString(1, paramStats.getDay());
		System.out.println("debug: instance-variable: stmt="+stmt);
		
		int updatedRow = stmt.executeUpdate();
		System.out.println("debug: instance-variable: updatedRow="+updatedRow);

		System.out.println("debug: method-end: StatsDao.insertStats()");
	}
	
	// paramStats로 받아온 날짜의 방문자 수를 1 증가시키는 메서드
	public void updateStatsPlusOne(Connection conn, Stats paramStats) throws Exception {
		System.out.println("debug: method-begin: StatsDao.insertStats()");
		System.out.println("debug: method-parameter: paramStats="+paramStats);
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.UPDATE_STATS);
		stmt.setString(1, paramStats.getDay());
		System.out.println("debug: instance-variable: stmt="+stmt);
		
		int updatedRow = stmt.executeUpdate();
		System.out.println("debug: instance-variable: updatedRow="+updatedRow);
		
		System.out.println("debug: method-end: StatsDao.insertStats()");
	}
	}	