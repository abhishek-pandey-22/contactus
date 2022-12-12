package com.abhi.model;
public class Request {
	private String uname, email, messege, activity;
	private int id;
	private String time;
	public Request(String uname, String email, String messege, String activity) {
		
		this.uname = uname;
		this.email = email;
		this.messege = messege;
		this.activity = activity;
	}

	public Request() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}



	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}

