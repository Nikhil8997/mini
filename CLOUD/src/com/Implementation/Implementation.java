package com.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Bean.AdminBean;
import com.Bean.UploadFileBean;
import com.Bean.UserBean;
import com.Connections.Connections;
import com.Interfaces.Interface;

public class Implementation implements Interface{
	PreparedStatement ps=null;
	PreparedStatement ps1=null;
	Connection con=null;
	@Override
	public int adminRegister(AdminBean bean) {
		int i=0;
		try {
			con=Connections.con();
			String query="insert into admin values(?,?,?,?,?,?,?)";
			String query1="insert into attacker values(sno,?,?,?,?)";
			ps=con.prepareStatement(query);
			ps1=con.prepareStatement(query1);
			
			ps.setString(1, bean.getId());
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getPassword());
			ps.setString(4, bean.getMobile());
			ps.setString(5, bean.getAddress());
			ps.setString(6, bean.getCity());
			ps.setString(7, bean.getMail());
			
			ps1.setString(1, "---");
			ps1.setString(2, "deactive");
			ps1.setString(3, "off");
			ps1.setString(4, bean.getId());
			
			i=ps.executeUpdate();
			int j=ps1.executeUpdate();
			System.out.println("Status="+i+"  "+j);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return i;
	}

	@Override
	public int adminLogin(AdminBean bean) {
		
		int result=0;
		
		try {
			con=Connections.con();
			
				String query1="select * from admin where office_id='"+bean.getId()+"' and password='"+bean.getPassword()+"'";
				System.out.println(query1);
				Statement st1=con.createStatement();
				ResultSet rs1=st1.executeQuery(query1);
		        System.out.println("Result="+result);
				if(rs1.next())
				{
					result=1;
				}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result="+result);
		return result;
	}

	@Override
	public int adminUpload(UploadFileBean ufb) {
		// TODO Auto-generated method stub
		
		
		PreparedStatement statement;
		int status = 0;
		
		try {
			con=Connections.con();
		
		
			con=Connections.con();
			System.out.println("name=" + ufb.getFilename());
			System.out.println("type=" + ufb.getType());
			System.out.println("size=" + ufb.getSize());
			System.out.println("path=" + ufb.getPath());
			System.out.println("key=" + ufb.getKey());
		    System.out.println("office_i=" + ufb.getId());
		//	System.out.println("database" + ufb.getTime());
			String query2 = "insert into adminupload values(?,?,?,?,?,?,?,?)";
			System.out.println(query2);
			statement = con.prepareStatement(query2);
			statement.setString(1, ufb.getFilename());
			statement.setString(2, ufb.getType());
			statement.setString(3, ufb.getSize());
			statement.setString(4, ufb.getPath());
			statement.setString(5, ufb.getKey());
			statement.setString(6, ufb.getId());
			statement.setString(7, "N");
			statement.setBoolean(8, true);
		//	statement.setString(7, "" + ufb.getUsername());
			System.out.println("array list size:" + ufb.getD_passibleOfWords());
			status = statement.executeUpdate();
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
		
		}

	@Override
	public int userRegister(UserBean bean) {
		int i=0;
		try {
			con=Connections.con();
			String query="insert into user values(?,?,?,?,?,?,?,?,?)";
			
			ps=con.prepareStatement(query);
			
			
			ps.setString(1, bean.getId());
			ps.setString(2, bean.getUid());
			ps.setString(3, bean.getName());
			ps.setString(4, bean.getPassword());
			ps.setString(5, bean.getMail());
			ps.setString(6, bean.getMobile());
			ps.setString(7, bean.getAddress());
			ps.setString(8, bean.getCity());
			ps.setString(9, bean.getStatus());
			
			
			
			i=ps.executeUpdate();
			
			System.out.println("Status="+i);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return i;
	}

	@Override
	public String userLogin(UserBean bean) {
int result=0;
		String officeId =null;
		try {
			con=Connections.con();
				String query1="select status, office_id from user where  user_id='"+bean.getUid()+"' and password='"+bean.getPassword()+"'";
				System.out.println(query1);
				Statement st1=con.createStatement();
				ResultSet rs1=st1.executeQuery(query1);
		        System.out.println("Result="+result);
				if(rs1.next())
				{
					if(rs1.getString(1).equalsIgnoreCase("Y")){
						result= 1;
						officeId = rs1.getString(2);
					}
				}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result="+result);
		return officeId;
	}

	@Override
	public int userUpload(UploadFileBean ufb) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		int status = 0;
		
		try {
			con=Connections.con();
	
	
			con=Connections.con();
			System.out.println("name=" + ufb.getFilename());
			System.out.println("type=" + ufb.getType());
			System.out.println("size=" + ufb.getSize());
			System.out.println("path=" + ufb.getPath());
			System.out.println("key=" + ufb.getKey());
		    System.out.println("office_i=" + ufb.getId());
		//	System.out.println("database" + ufb.getTime());
			String query2 = "insert into userupload values(?,?,?,?,?,?,?,?)";
			System.out.println(query2);
			statement = con.prepareStatement(query2);
			statement.setString(1, ufb.getFilename());
			statement.setString(2, ufb.getType());
			statement.setString(3, ufb.getSize());
			statement.setString(4, ufb.getPath());
			statement.setString(5, ufb.getKey());
			statement.setString(6, ufb.getId());
			statement.setString(7, ufb.getUid());
			statement.setBoolean(8, ufb.isSecurityCheck());
			System.out.println("array list size:" + ufb.getD_passibleOfWords());
			status = statement.executeUpdate();
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	

	
}
