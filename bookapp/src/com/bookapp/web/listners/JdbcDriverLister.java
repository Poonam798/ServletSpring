package com.bookapp.web.listners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class JdbcDriverLister implements ServletContextListener {
  
    public void contextInitialized(ServletContextEvent event)  { 
        String driverName=event.getServletContext().getInitParameter("jdbc.driverName");
        System.out.println("driver is loaded...");
        try {
			Class.forName(driverName);
		} catch (ClassNotFoundException ex) {
		}
    }
    
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

}
