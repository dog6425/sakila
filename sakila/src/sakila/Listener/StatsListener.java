package sakila.Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import sakila.service.StatsService;


@WebListener
public abstract class StatsListener implements HttpSessionListener {	
	private StatsService statsService;
		public StatsListener() {}
		public void seesionCreated(HttpSessionEvent se) {
			System.out.print("StatsListener.sessionCreated()");
			if(se.getSession().isNew()) {
				statsService = new StatsService();
				statsService.addStats();
			}
		}
		public void sessionDestroyed(HttpSessionEvent se) {}

}
