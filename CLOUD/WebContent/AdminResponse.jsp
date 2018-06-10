<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Metamorphosis Design Free Css Templates</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="styles.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="nivo-slider.css" type="text/css" media="screen" />
</head>
<body>


<%@ page import="java.util.List" %>
 <%@ page import="java.sql.*" %>
  <%@ page import="com.Connections.*" %>
 <%  PreparedStatement ps = null;
 	ResultSet resultSet= null;
Statement st=null;
PreparedStatement ps1 = null;
	ResultSet resultSet1= null;
Statement st1=null;
String query=null;
%>

<% HttpSession session1=request.getSession(false);  
String n=(String)session.getAttribute("uname");   %>
<div id="bg_clouds">
<div id="main">
<!-- header begins -->
<div id="header">
    
	<div id="buttons">
      <a href="index.html" class="but but_t"  title="">Home</a>
      <a href="admin.html" class="but" title="">Admin</a>
     
      <a href="about_us.html"  class="but" title="">About us</a>
      <a href="contact_us.html" class="but" title="">Contact us</a>
       <a href="index.html"  class="but" title="">Logout</a>
    </div>
	
	<div id="logo">
    	<a href="#"><font color="yellow" size=5><b>VIT File Transfer</b></font></a>
      	<h2><a href="#" id="metamorph">CLOUD STORAGE </a></h2>
    </div>
	
</div>
<!-- header ends -->
<div class="top_top"></div>
<div class="top">

 <div id="wrapper">
        <div id="slider-wrapper">        
            <div id="slider" class="nivoSlider">
                <img src="images/top.jpg" alt="" />
                <img src="images/top2.jpg" alt=""/>
                <img src="images/top3.jpg" alt="" />
            </div>        
        </div>

</div>

<script type="text/javascript" src="lib/jquery-1.4.3.min.js"></script>
    <script type="text/javascript" src="lib/jquery.nivo.slider.pack.js"></script>
    <script type="text/javascript">
    $(window).load(function() {
        $('#slider').nivoSlider();
    });
    </script>
</div>
<div class="top_bot"></div>
<div style="height:17px"></div>
        <!-- content begins -->
        		<div class="cont_top"></div>
				<div class="clear"></div>
	<div id="content">
	
	    <div class="line1">
						<div class="col1">
						
		<%
		
		String parameter = request.getParameter("returnParameter");
		if("adminResponse".equalsIgnoreCase(parameter)  ){
			String fileKey = request.getParameter("fileKey");
			String officeId =request.getParameter("officeId");
			String status ="Y";
			query="UPDATE adminupload SET status='"+status+"' where filekey='"+fileKey+"' and office_id='"+officeId+"'";
			ps1=Connections.con().prepareStatement(query);
			ps1.executeUpdate();
		
		
		%>				
						
		<h1>Admin response has been submitted sucessfully</h1>					
			
			<%
		}
			%>				
		
		
		<h2>File List <%=n %></h2>
						<div class="wrapper pad_bot3">
						<br><br><br>
						<center> User Reqested Files
					<table  border="2" bordercolor="gray" width="500"  >
					
					<tr bgcolor="yellow">
					<td><center>Name/Key</center></td><td><center>File</center></td><td><center>Permission</center></td>
					</tr>
							<%
		int total=0;
			
				query="select status from attacker where owner_id='"+n+"'";
				ps1=Connections.con().prepareStatement(query);
				resultSet1=ps1.executeQuery();
				resultSet1.absolute(1);
				String result=resultSet1.getString(1);
				
				if(result.equals("attack"))
				{
					response.sendRedirect("attacked.jsp");
				}
				
				else
				{
					String status = "R";
				String q="select name,path,filekey,  status, office_id from adminupload where office_id='"+n+"' and status='"+status+"'";
				ps=Connections.con().prepareStatement(q);
				resultSet=ps.executeQuery();
				while(resultSet.next())
				{
					
				%>
				
			<tr bgcolor="white">
			
			<td><%=resultSet.getString(3)%></td>
					<td><%=resultSet.getString(1)%></td>
					
			<!-- 	<td>
						<input type="button" onclick="myFunction('<%=resultSet.getString(1)%>')" value="OPEN"></input>
					</td>
				 -->	
					<td><a href="AdminResponse.jsp?fileKey=<%=resultSet.getString(3)%>&officeId=<%=resultSet.getString(5)%>&returnParameter=adminResponse"  title="Click here to reponse"><center>Accept Request</center></a></td>
	
			</tr>
			
		<% 
				}
				}
			
		%>
		</table>
		</br>
		
	<a href="admin_view.jsp"  title="Click here to reponse"><center>Back</center></a>
							
							</div>
						
						
							
							
					
					</div>
				
				</div>
	
	</div>
    <!-- content ends --> 
    <!-- bottom begin -->

<!-- bottom end --> 
<!-- footer begins -->
         
        <!-- footer ends -->
</div>

</div>
</body>
</html>
