package com.blackteam.tictactoextrem;

public class Player {

	private int id;
	private String nickName;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public Player(int id, String nickName) {
		super();
		this.id = id;
		this.nickName = nickName;
	}
}
