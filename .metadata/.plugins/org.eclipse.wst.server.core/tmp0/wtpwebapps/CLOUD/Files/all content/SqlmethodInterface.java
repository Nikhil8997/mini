package com.dao;

import java.util.List;

import com.bean.Passwordbean;
import com.bean.RegisterBean;
import com.bean.UploadFileBean;
import com.bean.conjuctBean;

public interface SqlmethodInterface 
{
public int register(RegisterBean  rbb);
public boolean login(RegisterBean log);	
public String login1(RegisterBean log1);
public int fileupload(UploadFileBean ufb);
public void filedownload(UploadFileBean dfb);
public List conjuctQuery(conjuctBean cbb); 
public String getUsername(String mailid);
public List usersec(conjuctBean usoc);
public List userperm(conjuctBean perobj);
public Integer userBased(conjuctBean userobj);
public int delete(String filename);
public Object[] getuserNames();
public int passuudate(Passwordbean passup);
public int down(conjuctBean cbd);
public List userperm1(conjuctBean cdb);


}
