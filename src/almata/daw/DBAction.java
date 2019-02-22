package almata.daw;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;



public class DBAction extends ActionSupport implements ServletContextAware  {
	
	protected GestorBd db = null;
	private ServletContext servletContext;
	
	protected void loadDB(){
		String hostname = (String) servletContext.getInitParameter("dbserver");;
		String database = (String) servletContext.getInitParameter("database");
		String user = (String) servletContext.getInitParameter("user");
		String passwd = (String) servletContext.getInitParameter("passwd");
		db = new GestorBd(hostname, database, user, passwd);
	}
	
	 @Override
	 public void setServletContext(ServletContext context) {
	        this.servletContext = context;
	}

}
