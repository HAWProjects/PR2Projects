package haw.pr2.jgame.impl;

import haw.pr2.jgame.Factory;
import haw.pr2.jgame.interfaces.Acc;
import haw.pr2.jgame.interfaces.Length;
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
		return fromPrototype(Factory.timeInSec(this.value()).value() / other);
	}


	@Override
	public TimeDiff mul(double other) {
		return fromPrototype(Factory.timeInSec(this.value()).value() * other);
	}


	@Override
	public Length mul(Speed speed) {
		return LengthImpl.valueOf(Factory.timeInSec(this.value()).value() * speed.value());
	}


	@Override
	public Speed mul(Acc acc) {
		return SpeedImpl.valueOf(Factory.timeInSec(this.value()).value() * acc.value());
	}

}
