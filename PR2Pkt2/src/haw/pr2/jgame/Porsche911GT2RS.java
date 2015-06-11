package haw.pr2.jgame;




public class Porsche911GT2RS extends Car
{
	private static final double MASS = 1445.0; // Kilogramm [Kg]
	private static final double POWERPROPMAX = 456 * Konstants.KILOWATTINWATT ; // 456 * 1000; // Watt [W]
	private static final double SPEEDMAX = 330.0 / (Konstants.SECONDSINHOUR / Konstants.KILOMETERINMETERS); // Hoechsgeschwindigkeit [m/s]
	private static final double DRAGCONST = Math.abs(POWERPROPMAX / (Math.pow(SPEEDMAX, 3.0)));  // [kg*m/s**2] 
	private static final double CURVE_RADIUS = 10.9; // / 2; // Meters [m]

	
	public Porsche911GT2RS(){
		this(0.0,0.0,0.0,0.0,0.0, 0.0, true,true);
	}
	public Porsche911GT2RS(double time, double posX, double posY, double speed, double proplevel, double brakelevel, boolean abs,boolean asr) 
	{
		super(time, posX,posY, speed, proplevel, brakelevel, 0.0);
	}
	
	public double getMass(){		
		return MASS;
	}
	
	public double getPowerPropMax(){
		
		return POWERPROPMAX;
	}
	
	public double getSpeedMax(){
		
		return SPEEDMAX;
	}
	
	public double getdragConst()
	{
		return DRAGCONST;
	}
	

	public double getCurveRadius(){
		return CURVE_RADIUS;
	}
	
	
}
