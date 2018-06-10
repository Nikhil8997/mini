package com.Implementation;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.Bean.Bean;
import com.Connections.Connections;
import com.Interface.Interfaces;

public class Implementation implements Interfaces{

	Connection connection=null;
	PreparedStatement ps=null;
	
	Statement st=null;
	@Override
	public int attack(Bean bean) {
		int i=0;
		String ip=null;
		try {
		 ip=InetAddress.getLocalHost().getHostAddress();
			
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connection=Connections.con();
			ps=connection.prepareStatement("update attacker set status='attack',ip='"+ip+"' where security='off' and owner_id=?");
			
		ps.setString(1, bean.getId());
		
		 i=ps.executeUpdate();
		
			
			
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}
