package com.sapient.metro.system;

public class MetroStation {

	Command command;
	
	public void setCommand(Command Cmd){
		this.command=Cmd;
	}
	
	public void SwipeCard() throws Exception{
		try {
			command.execute();
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		}
	}
	
}

