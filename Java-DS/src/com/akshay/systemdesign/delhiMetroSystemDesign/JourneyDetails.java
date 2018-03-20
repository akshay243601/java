package com.akshay.systemdesign.delhiMetroSystemDesign;

public class JourneyDetails {
	private Stations startStation;
	private Stations destinationStation;

	public Stations getStartStation() {
		return startStation;
	}

	public void setStartStation(Stations startStation) {
		this.startStation = startStation;
	}

	public Stations getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(Stations destinationStation) {
		this.destinationStation = destinationStation;
	}
}
