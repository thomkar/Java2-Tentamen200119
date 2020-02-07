package se.miun.thka1901.dt007g.ship;

public abstract class Ship {
	
	private final String name;
	private final int maxWeight;
	private final int crew;
	private final ShipType type;
	
	protected final int CREWWEIGHT = 100;
	
	public Ship(String name, int maxWeight, int crew, ShipType type) {
		super();
		this.name = name;
		this.maxWeight = maxWeight;
		this.crew = crew;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public int getCrew() {
		return crew;
	}

	public ShipType getType() {
		return type;
	}

	public abstract int getCurrentWeight();

}
