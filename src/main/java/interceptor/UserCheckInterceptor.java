package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest req,HttpServletResponse resp,Object handler) throws Exception{
		HttpSession session =req.getSession(false);
		if(session!=null) {
			Object user = session.getAttribute("user");
			if(user != null) {
				return true;
			}
		}
		resp.sendRedirect(req.getContextPath()+"/user/login");
		return false;
	}

}
