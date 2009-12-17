package cn.geodata.models.ecoserv.models;

import java.util.Date;

public class Simulation {
	private int id;
	private String username;
	private Date createDate;
	
	public Simulation(int id, String username, Date createDate) {
		super();
		this.id = id;
		this.username = username;
		this.createDate = createDate;
	}
	
	public Simulation(){
		this(-1, null, new Date());
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
