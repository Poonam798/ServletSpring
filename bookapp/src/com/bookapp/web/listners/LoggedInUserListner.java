package com.bookapp.web.listners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class LoggedInUserListner implements HttpSessionListener {
	public static long counter =0;
	
    public void sessionCreated(HttpSessionEvent event)  { 
       counter++;
       System.out.println("new user logged in: "+ counter);
    }

    public void sessionDestroyed(HttpSessionEvent event)  { 
     counter--;
     System.out.println("an user have logged out: "+counter);
    }

	public static long getCounter() {
		return counter;
	}
	
}
