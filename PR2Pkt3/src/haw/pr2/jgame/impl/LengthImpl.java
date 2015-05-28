package haw.pr2.jgame.impl;

import haw.pr2.jgame.interfaces.Length;
import haw.pr2.jgame.interfaces.Mass;

public class LengthImpl extends AbstractValuesImpl<Length> implements Length {

   public static Length valueOf(double inValue) {
        return new LengthImpl(inValue);
    }
    
	private LengthImpl(double value) {
		super(value);
	}

	@Override
	public Length add(Length other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Length fromPrototype(double value) {
		return valueOf(value);
	}

	@Override
	public boolean checkInstance(Object obj) {
		return obj instanceof Length;
	}



}
