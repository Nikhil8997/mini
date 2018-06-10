package com.Bean;



import java.io.FileInputStream;
import java.util.ArrayList;

public class UploadFileBean 
{
	
	private String filename;
	private String type;
	private String size;
	private String path;
	private String key;
	
	
	private FileInputStream uploadcontent;
	private  String D_passibleOfWords;
	private String time;
	private String id;
	private String uid;
	
	private boolean securityCheck;
	
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key2) {
		this.key = key2;
	}
	public String getD_passibleOfWords() {
		return D_passibleOfWords;
	}
	public void setD_passibleOfWords(String key2) {
		D_passibleOfWords = key2;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public FileInputStream getUploadcontent() {
		return uploadcontent;
	}
	public void setUploadcontent(FileInputStream uploadcontent) {
		this.uploadcontent = uploadcontent;
	}
	public boolean isSecurityCheck() {
		return securityCheck;
	}
	public void setSecurityCheck(boolean securityCheck) {
		this.securityCheck = securityCheck;
	}
	
	
	
	
}
