package sakila.service;


public class StatsQuery {
	public static final String SELECT_DAY = "SELECT day FROM stats WHERE day=?";
	public static final String INSERT_STATS = "INSERT INT stats(day.count) VALUES(?,1)";
	public static final String UPDATE_STATS = "UPDATE stats SET count=count+1 WHERE day=?";
}
