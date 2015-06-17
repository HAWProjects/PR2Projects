package haw.pr2.interfaces.units;

public enum PowerUnit
{
	WATT(1.0), // [W]
	KILOMETERPROSEKUNDE(0.102);

	private double factor;

	private PowerUnit(double factor) {
		this.factor = factor;
	}

	public double getFactor() {
		return factor;
	}
}
