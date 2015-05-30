package haw.pr2.jgame;

import haw.pr2.jgame.impl.LengthImpl;
import haw.pr2.jgame.impl.MassImpl;
import haw.pr2.jgame.impl.PowerImpl;
import haw.pr2.jgame.impl.SpeedImpl;
import haw.pr2.jgame.impl.TimeDiffImpl;
import haw.pr2.jgame.impl.WorkImpl;
import haw.pr2.jgame.interfaces.Length;
import haw.pr2.jgame.interfaces.Mass;
import haw.pr2.jgame.interfaces.Power;
import haw.pr2.jgame.interfaces.Speed;
import haw.pr2.jgame.interfaces.TimeDiff;
import haw.pr2.jgame.interfaces.Work;
import haw.pr2.jgame.units.LengthUnit;
import haw.pr2.jgame.units.MassUnit;
import haw.pr2.jgame.units.Multiplier;
import haw.pr2.jgame.units.PowerUnit;
import haw.pr2.jgame.units.TimeUnit;
import haw.pr2.jgame.units.WorkUnit;

public class Factory {
	
	private Factory(){}
	
	/******************************Length*********************/
    public static Length lengthInMeter(double meter) {
        return length(meter, LengthUnit.METER, Multiplier.NONE);
    }
    
    public static Length lengthInFeet(double meter) {
    	return length(meter, LengthUnit.FEET, Multiplier.NONE);
    }
    
    public static Length lengthInKm(double meter) {
    	return length(meter, LengthUnit.METER, Multiplier.MILLI);
    }

    public static Length length(double value, LengthUnit unit, Multiplier multiplier) {
        return LengthImpl.valueOf(value * unit.getFactor() * multiplier.getMultiplier());
    }
    
    /******************************Mass**********************/
    public static Mass massInKilogramm(double kilogramm) {
        return mass(kilogramm, MassUnit.KILOGRAMM, Multiplier.NONE);
    }
    
    public static Mass massInGramm(double kilogramm) {
    	return mass(kilogramm, MassUnit.KILOGRAMM, Multiplier.MILLI);
    }
    
    public static Mass mass(double value, MassUnit unit, Multiplier multiplier){
    	return MassImpl.valueOf(value * unit.getFactor() * multiplier.getMultiplier());
    }
    
    
    /******************************Time*********************/
    public static TimeDiff timeInSec(double s) {
    	return time(s, TimeUnit.SEC, Multiplier.NONE);
    }
    
    public static TimeDiff timeInHour(double h) {
    	return time(h, TimeUnit.HOUR, Multiplier.NONE);
    }
    
    public static TimeDiff timeHourInSec(double h) {
    	return time(h, TimeUnit.HOUR, Multiplier.HOURINSEC);
    }
    
    public static TimeDiff time(double value, TimeUnit unit, Multiplier multiplier){
    	return TimeDiffImpl.valueOf(value * unit.getFactor() * multiplier.getMultiplier());
    }
    
    /******************************Power*********************/
    public static Power powerInWatt(double watt) {
    	return power(watt, PowerUnit.WATT, Multiplier.NONE);
    }
    
    public static Power powerInKiloWatt(double watt) {
    	return power(watt, PowerUnit.WATT, Multiplier.KILO);
    }
    
    public static Power power(double value, PowerUnit unit, Multiplier multiplier){
    	return PowerImpl.valueOf(value * unit.getFactor() * multiplier.getMultiplier());
    }
    
    /******************************Speed*********************/
    public static Speed speedInMeterProSeKunde(double meterProSec) {
    	return speed(meterProSec, LengthUnit.METER, Multiplier.NONE);
    }
    
    public static Speed speedInMeterProSeKundeVonKmProStunde(double kmProHour) {
    	return speed(kmProHour, LengthUnit.METER, Multiplier.KMPROSTUNDEINMETERPROSEKUNDE);
    }
    
    public static Speed speed(double value, LengthUnit unit, Multiplier multiplier){
    	return SpeedImpl.valueOf(value * unit.getFactor() * multiplier.getMultiplier());
    }
    
    
    /******************************Work*********************/
    
    public static Work workInNewtonMeter(double kmProHour) {
    	return work(kmProHour, WorkUnit.NEWTONMETER, Multiplier.NONE);
    }
    
    public static Work work(double value, WorkUnit unit, Multiplier multiplier){
    	return WorkImpl.valueOf(value * unit.getFactor() * multiplier.getMultiplier());
    }
}
