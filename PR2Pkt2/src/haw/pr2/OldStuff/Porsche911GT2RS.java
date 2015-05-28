package haw.pr2.OldStuff;

public class Porsche911GT2RS extends Car
{
	private static final double MASS = 1445.0; // Kilogramm [Kg]
	private static final double POWERPROPMAX = 456 * Konstants.KILOWATTINWATT ; // 456 * 1000; // Watt [W]
	private static final double SPEEDMAX = 330.0 / (Konstants.SECONDSINHOUR / Konstants.KILOMETERINMETERS); // Hoechsgeschwindigkeit [m/s]
	private static final double DRAGCONST = Math.abs(POWERPROPMAX / (Math.pow(SPEEDMAX, 3.0)));  // [kg*m/s**2] 
	
	public Porsche911GT2RS(double time, double pos, double speed, double proplevel) 
	{
		super(time,  pos, speed, proplevel);
	}
	
	public double getMass(){		
		return MASS;
	}
	
	public double powerPropMax(){
		
		return POWERPROPMAX;
	}
	
	public double speedMax(){
		
		return SPEEDMAX;
	}
	
	public double getdragConst()
	{
		return DRAGCONST;
	}
}
