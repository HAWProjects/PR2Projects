package haw.pr2.jgame.impl;

import haw.pr2.jgame.interfaces.Acc;
import haw.pr2.jgame.interfaces.Length;
import haw.pr2.jgame.interfaces.Mass;
import haw.pr2.jgame.interfaces.Speed;
import haw.pr2.jgame.interfaces.TimeDiff;

public class TimeDiffImpl extends AbstractValuesImpl<TimeDiff> implements TimeDiff {

	   public static TimeDiff valueOf(double inValue) {
	        return new TimeDiffImpl(inValue);
	    }
	
	
	private TimeDiffImpl(double value) {
		super(value);
	}

	@Override
	public TimeDiff fromPrototype(double value) {
		return valueOf(value);
	}

	@Override
	public boolean checkInstance(Object obj) {
		return obj instanceof TimeDiff;
	}


	@Override
	public TimeDiff div(double other) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public TimeDiff mul(double other) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Length mul(Speed speed) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Speed mul(Acc acc) {
		// TODO Auto-generated method stub
		return null;
	}

}
