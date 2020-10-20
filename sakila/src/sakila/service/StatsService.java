package sakila.service;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import sakila.dao.StatsDao;
import sakila.util.DBUtil;
import sakila.vo.Stats;



public class StatsService {
	StatsDao statsDao;
	
	//오늘의 방문자 수를 조회하는 메소드
	//stats 객체를 반환: stats.getDay() 메소드로 방문날짜 , stats.getCount()로 방문횟수 조회 가능
	public Stats getStats() {
		System.out.print("debug: method-begin: StatsService.getStats()");
		statsDao = new StatsDao();
		
		//리스너에서 Class.forName()을 이미 호출하여 JDBC를 로드했으므로 따로 적을 필요는 없음
		Connection conn=null;
		Stats returnStats=null;
				
		try {
			//DBUtil을 사용해 DB에 연결
			//연결 실패 시 Exception을 던짐
			DBUtil dbutil = new DBUtil();
			conn = dbUtil.getConnection();
			
			//현재 날짜를 이용해 statsDao에 전달할 피라미터 객체를 만든 뒤
			Stats paramStats = new Stats();
			paramStats.setDay(this.getFormattedToday());
			System.out.print("debug: instance-variable: paramStats="+paramStats);\
			
			//현재 날짜에 대한 방문자 수 정보를 가져옴
			Stats todayStats = statsDao.selectOne(conn, paramStats);
			System.out.print("debug: instance-variable: todayStats="+todayStats);
			
			System.out.print("debug: message: 'Excute SQL transection...'");
			returnStats = statsDao.selectStatsOne(conn, todayStats);
			System.out.print("debug: instance-variable: returnStats="+returnStats);
			
			conn.commit();
			System.out.println("debug: message: 'Execute successfully: Connect DB and SQL transection'");
		} catch (Exception e) { // DB 연결 혹은 쿼리 작업 중 예외 발생 시
			e.printStackTrace();
			System.out.println("debug: message: 'Execute failed: Connect DB and SQL transection'");

			try {
				System.out.println("debug: message: 'Execute rollback...'");
				conn.rollback();
				System.out.println("debug: message: 'Execute successfully: rollback'");
			} catch (Exception e2) { // 롤백 실패 시
				e2.printStackTrace();
				System.out.println("debug: message: 'Execute failed: rollback'");
			}
		} finally { // 어쩌나 저쩌나 작업이 중도 실패됐든 작업이 정상 종료 되었든간에 conn.close()로 자원 수동 반환
			try {
				System.out.println("debug: message: 'Close conn...'");
				conn.close();
				System.out.println("debug: message: 'Close successfully: conn'");
			} catch (Exception e) { // conn.close() 실패 시
				e.printStackTrace();
				System.out.println("debug: message: 'Close failed: conn'");
			}
		}

		System.out.println("debug: method-end: StatsService.getStats()");
		return returnStats;
	}
	//방문자 수를 1 더하는 메소드
	public void addStats();{
		System.out.print("debug: method-begin: StatsService.addStats()");
		
		statsDao = new StatsDao();
		
		Connection conn = null;
		try {
			//DBUtil을 사용해 DB에 연결함
			//연결 실패 시 Exception을 던짐 
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConntecion();
			
			//현재 날짜를 이용해 statsDao에 전덜할 피라미터 객체를 만든 뒤
			Stats paramStats = new Stats();
			
		}
	}

			
			
