package almata.daw;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class Sortir extends DBAction implements SessionAware {
	
	private SessionMap<String, Object> session;

	public SessionMap<String, Object> getSession() {
		return session;
	}

	

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = (SessionMap<String, Object>) session;	
	}

	public String sortir() {
		
		session.invalidate();
		
		return SUCCESS;
	}
}
