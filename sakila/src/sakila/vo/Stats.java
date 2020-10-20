package sakila.vo;

public class Stats {
	private String day;
	private long count;
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "Stats [day=" + day + ", count=" + count + "]";
	}
}
