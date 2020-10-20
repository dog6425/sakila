package sakila.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import sakila.dao.StatsDao;
import sakila.vo.Stats;

public class StatsService {
	private StatsDao statsDao;
	private Stats getToday() {
		Calender today = Calender.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-mm-dd");
		String day = formater.format(totday);
		State stats = new Stats();
		stats.setDay(day);
		return stats;
	}
	public Stats getStats() {
		Stats returnStats = null;
		statsDao = new StatsDao();
		final String URL = "";
		final String USER = "root";
		final String PASSWORD = "java1004";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false);
			
			Stats stats = this.getToday();
			
			returnStats = statsDao.selectDay(conn, stats);
			conn.commit();
			}catch(Exception e) {
				try {
					conn.rollback();
				}catch (SQLException e) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return returnStats;
	}
	public void countStats() {
		statsDao = new StatsDao();
		final String URL = "";
		final String USER = "root";
		final String PASSWORD = "java1004";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			conn.setAutoCommit(false);
			
			Stats stats = this.getToday();
			// 
			if(statsDao.selectDay(conn,stats)==null) {
				statsDao.insertStats(conn, stats);
			}else {
				statsDao.updateStats(conn);
			}
			conn.commit();
		}catch(Exception e) {
			try {
				conn.rollback();
			}catch (SQLException e) {
					e1.printStackTrace();
			}
		}	finally {
			try {
				conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
			}
		}
	}
}
			
			
