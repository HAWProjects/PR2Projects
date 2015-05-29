package haw.pr2.jgame.impl;

import haw.pr2.jgame.interfaces.AbstractValue;
import haw.pr2.jgame.interfaces.Length;
import haw.pr2.jgame.interfaces.Speed;
import haw.pr2.jgame.interfaces.TimeDiff;

public class SpeedImpl extends AbstractValuesImpl<Speed> implements Speed {
	
	  public static Speed valueOf(double inValue) {
	        return new SpeedImpl(inValue);
	    }
	
	private SpeedImpl(double value) {
		super(value);
	}

	@Override
	public Speed div(double other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Speed mul(double other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Speed fromPrototype(double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Length mul(TimeDiff timeDiff) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
