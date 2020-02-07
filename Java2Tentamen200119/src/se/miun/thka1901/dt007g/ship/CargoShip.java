package se.miun.thka1901.dt007g.ship;

import java.util.ArrayList;
import java.util.List;


public class CargoShip extends Ship {
	
	private ArrayList<Cargo> cargoList = new ArrayList<>();
	
	public CargoShip(String name, int maxWeight, int crew) {
		super(name, maxWeight, crew, ShipType.CARGO);
	}
	
	public void addCargo(Cargo cargo) throws OverloadException {
		if ( getCurrentWeight() + (int) cargo.getWeight() > getMaxWeight())
			throw new OverloadException("To heavy cargo, could not be loaded");
		cargoList.add(cargo);
	}
	
	public ArrayList<Cargo> getCargoList() {
		return cargoList;
	}

	@Override
	public int getCurrentWeight() {
		float cargoWeight=0;
		for ( Cargo c : cargoList) {
			cargoWeight += c.getWeight();	
		}
		
		return (int) cargoWeight + getCrew()*CREWWEIGHT;
	}

	@Override
	public String toString() {
		return "CargoShip [getCurrentWeight()=" + getCurrentWeight() + ", getName()=" + getName() + "]";
	}

}
