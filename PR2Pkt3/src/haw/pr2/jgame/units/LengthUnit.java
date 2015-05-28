package haw.pr2.jgame.units;

public enum LengthUnit {
	METER(1.0),
	FEET(0.3048), 
	MILES(1609.0);
	

	private double factor;

	private LengthUnit(double factor) {
		this.factor = factor;
	}

	public double getFactor() {
		return factor;
	}

}
