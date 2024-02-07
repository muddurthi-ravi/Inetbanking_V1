package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig
{
	Properties pro;

	public Readconfig()
	{
		File src = new File("./Configrations/config.properties");
		try {
			FileInputStream fi=new FileInputStream(src);
			pro = new Properties();
			pro.load(fi);
		} catch (Exception e) {
			System.out.println("Exceptions is"+ e.getMessage());
		}
	}
	
	public String getApplicationUrl()
	{
		String Url= pro.getProperty("Url");
		return Url;
	}
	
	public String getUserName()
	{
		String uname= pro.getProperty("uname");
		return uname;
	}
	
	public String getPassword()
	{
		String pwd= pro.getProperty("pwds");
		return pwd;
	}
		
	public String getChromePath()
	{
		String path= pro.getProperty("chromepath");
		return path;
	}
	
	public String getFirefoxPath()
	{
		String path= pro.getProperty("firefoxpath");
		return path;
	}
	
	public String getEdgePath()
	{
		String path= pro.getProperty("msedgepath");
		return path;
	}
	
	
	
	
	
	
	
	
	
	

}
