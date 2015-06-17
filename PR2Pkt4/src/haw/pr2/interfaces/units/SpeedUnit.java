package haw.pr2.interfaces.units;

public enum SpeedUnit
{
	METERPROSEC(1.0);

	private double factor;

	private SpeedUnit(double factor) {
		this.factor = factor;
	}

	public double getFactor() {
		return factor;
	}
}
