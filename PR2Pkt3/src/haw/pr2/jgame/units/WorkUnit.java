package haw.pr2.jgame.units;

public enum WorkUnit
{
	NEWTONMETER(1.0);

	private double factor;

	private WorkUnit(double factor) {
		this.factor = factor;
	}

	public double getFactor() {
		return factor;
	}
}
