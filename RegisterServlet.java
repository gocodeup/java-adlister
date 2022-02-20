package com.lnt.register;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		
		try{
			PrintWriter pw = response.getWriter();
			Class.forName("org.h2.Driver");
			Connection con =
					DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","root");
			PreparedStatement pstmt = 
					con.prepareStatement("insert into Loguser values(?,?,?);");
		
			String ser_uname  = request.getParameter("uname");
			String ser_pwd = request.getParameter("pwd");
			String ser_mob = request.getParameter("number");
			pstmt.setString(1, ser_uname);
			pstmt.setString(2, ser_pwd);
			pstmt.setString(3,ser_mob);
			
			int i = pstmt.executeUpdate();
			
			if(i>0)
			{
				pw.print("registered succssfully");
			}
			else
			{
				pw.print("not registered");
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
