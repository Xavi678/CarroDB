package almata.daw;

import java.util.Map;

import javax.xml.ws.Response;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor  extends AbstractInterceptor {

        @Override
        public String intercept(ActionInvocation invocation) throws Exception {
                Map<String, Object> session = invocation.getInvocationContext().getSession();

               Usuari user = (Usuari) session.get("loginId");
               
              
                if (user== null) 
                {
                        return Action.LOGIN;
                        

                        
                } 
                else 
                {
                        return invocation.invoke();
                }
        }
}