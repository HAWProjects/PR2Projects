package haw.pr2.jgame;

import haw.pr2.jgame.impl.LengthImpl;
import haw.pr2.jgame.impl.MassImpl;
import haw.pr2.jgame.interfaces.Length;
import haw.pr2.jgame.interfaces.Mass;
import haw.pr2.jgame.units.LengthUnit;
import haw.pr2.jgame.units.MassUnit;
import haw.pr2.jgame.units.Multiplier;

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
}
