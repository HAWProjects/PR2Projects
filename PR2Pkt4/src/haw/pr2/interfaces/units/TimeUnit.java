package haw.pr2.interfaces.units;

public enum TimeUnit {
	HOUR(1.0),
	MIN(1.0),
	SEC(1.0);
	
	private double factor;

	private TimeUnit(double factor) {
		this.factor = factor;
	}

	public double getFactor() {
		return factor;
	}
}
