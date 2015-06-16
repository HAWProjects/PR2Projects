package haw.pr2.jgame;

import haw.pr2.jgame.impl.Factory;
import haw.pr2.jgame.interfaces.*;




public class Porsche911GT2RS extends Car
{
	private static final Mass MASS = Factory.massInKilogramm(1445.0); // Kilogramm [Kg]
	private static final Power POWERPROPMAX = Factory.powerKilowattInWatt(456);//456 * Konstants.KILOWATTINWATT ; // 456 * 1000; // Watt [W]
	private static final Speed SPEEDMAX = Factory.speedInMeterProSeKundeVonKmProStunde(330.0); // / (Konstants.SECONDSINHOUR / Konstants.KILOMETERINMETERS); // Hoechsgeschwindigkeit [m/s]
	private static final Force DRAGCONST = (POWERPROPMAX.div(SPEEDMAX.mul(SPEEDMAX).mul(SPEEDMAX))).abs();  // [kg*m/s**2] 
	private static final Length CURVE_RADIUS = Factory.lengthInMeter(10.9); // / 2; // Meters [m]
	private boolean abs;
	private boolean asr;
	
	public Porsche911GT2RS(){
		this(Factory.time(0.0),Factory.length(0.0),Factory.length(0.0),Factory.speed(0.0),0.0, 0.0, true,true);
	}
	public Porsche911GT2RS(TimeDiff time, Length posX, Length posY, Speed speed, double proplevel, double brakelevel, boolean abs,boolean asr) 
	{
		super(time, posX,posY, speed, proplevel, brakelevel, 0.0);
		this.abs = abs;
		this.asr = asr;
	}
	
	public Mass getMass(){		
		return MASS;
	}
	
	public Power getPowerPropMax(){
		
		return POWERPROPMAX;
	}
	
	public Speed getSpeedMax(){
		
		return SPEEDMAX;
	}
	
	public Force getdragConst()
	{
		return DRAGCONST;
	}
	
	public void toggleABS(){
		this.abs = !abs;
	}
	
	public void toggleASR(){
		this.asr = !asr;
	}
	
    @Override
	public boolean isASRActive(){
		return asr;
	}
    @Override
    public boolean isABSActive(){
    	return abs;
    }
	
	public Length getCurveRadius(){
		return CURVE_RADIUS;
	}
	
	
}
