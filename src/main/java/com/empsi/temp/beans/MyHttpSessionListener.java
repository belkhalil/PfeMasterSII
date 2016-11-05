package com.empsi.temp.beans;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
public class MyHttpSessionListener implements HttpSessionListener, ApplicationContextAware {

	@Autowired
	ConnectionModel connectionModel;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext instanceof WebApplicationContext) {
            ((WebApplicationContext) applicationContext).getServletContext().addListener(this);
        } else {
            //Either throw an exception or fail gracefully, up to you
            throw new RuntimeException("Must be inside a web application context");
        }
    }

	

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		//arg0.getSession().setMaxInactiveInterval(10);
		//System.out.println("waw session created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
	
		//System.out.println("waw session destroyed");
		HttpSession httpSession =arg0.getSession();
		UserBean userBean = (UserBean) httpSession.getAttribute("userBean");
		if (userBean!=null) {
			connectionModel.logout(userBean.getIdUser());
		}
	}           
}