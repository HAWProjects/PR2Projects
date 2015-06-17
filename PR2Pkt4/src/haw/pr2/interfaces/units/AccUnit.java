package haw.pr2.interfaces.units;

public enum AccUnit {
	METERINSECQUADRAT(1.0);
	
	private double factor;

	private AccUnit(double factor) {
		this.factor = factor;
	}

	public double getFactor() {
		return factor;
	}
}
