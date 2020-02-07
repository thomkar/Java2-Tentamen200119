package se.miun.thka1901.dt007g.ship;

public class Cargo {
	
	String name;
	float weight;
	boolean highRisk;
	
	public Cargo(String name, float weight, boolean highRisk) {
		super();
		this.name = name;
		this.weight = weight;
		this.highRisk = highRisk;
	}
	
	public Cargo(String name, float weight) {
		this(name, weight, false);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public boolean isHighRisk() {
		return highRisk;
	}

	public void setHighRisk(boolean highRisk) {
		this.highRisk = highRisk;
	}

	@Override
	public String toString() {
		return "Cargo [name=" + name + ", weight=" + weight + "]";
	}

}
