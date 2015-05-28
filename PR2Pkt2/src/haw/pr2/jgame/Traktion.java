package haw.pr2.jgame;

public enum Traktion {
	
	ICE(0.1),
	SNOW(0.3),
	WET(0.7),
	NORMAL(1.0);

	private final double value;
	
	private Traktion(double value){
		this.value = value;
	}
	
	public double getValue(){
		return value;
	}
	
}
