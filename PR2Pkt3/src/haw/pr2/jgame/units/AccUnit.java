package haw.pr2.jgame.units;

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
