package com.superhero.netctoos.enmu;

public enum LoginEnum {
	LOGIN(0),EXIT(1);
	
	private int type;
	
	private LoginEnum(int type){
		this.type = type;
	}

	public int getType() {
		return type;
	}
}
