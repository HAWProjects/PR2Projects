package haw.pr2.jgame.units;

public enum ForceUnit {
	NEWTON(1.0);
	
	private double factor;

	private ForceUnit(double factor) {
		this.factor = factor;
	}

	public double getFactor() {
		return factor;
	}
}
