package se.miun.thka1901.dt007g.ship;

public class PassengerShip extends Ship {
	
	int maxPassengers;
	int passengers;
	
	private final int PASSENGERWEIGHT = 150;
	
	

	public PassengerShip(String name, int maxWeight, int crew, int maxPassengers) {
		super(name, maxWeight, crew, ShipType.PASSENGER);
		this.maxPassengers = maxPassengers;
	}


	public void setPassengers(int passengers) throws OverloadException {
		if ( passengers < 0 || getCrew() * CREWWEIGHT + passengers * PASSENGERWEIGHT > getMaxWeight())
			throw new OverloadException("To many passengers");
		this.passengers = passengers;
	}


	@Override
	public int getCurrentWeight() {
		
		return getCrew()*CREWWEIGHT + passengers*PASSENGERWEIGHT;
	}


	@Override
	public String toString() {
		return "PassengerShip [passengers=" + passengers + ", getCurrentWeight()=" + getCurrentWeight() + ", getName()="
				+ getName() + "]";
	}

}
