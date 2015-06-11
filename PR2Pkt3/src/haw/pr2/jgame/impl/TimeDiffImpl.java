package haw.pr2.jgame.impl;

import haw.pr2.jgame.interfaces.Acc;
import haw.pr2.jgame.interfaces.Length;
import haw.pr2.jgame.interfaces.Speed;
import haw.pr2.jgame.interfaces.TimeDiff;

class TimeDiffImpl extends AbstractValuesImpl<TimeDiff> implements TimeDiff {

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
		return Factory.lengthInMeter(Factory.timeInSec(this.value()).value() * Factory.speedInMeterProSeKunde(speed.value()).value());
//		return LengthImpl.valueOf(Factory.timeInSec(this.value()).value() * speed.value());
	}


	@Override
	public Speed mul(Acc acc) {
		return Factory.speedInMeterProSeKunde(Factory.timeInSec(this.value()).value() * Factory.accInMeterProSeKundeQuadrat(acc.value()).value());
//		return SpeedImpl.valueOf(Factory.timeInSec(this.value()).value() * acc.value());
	}

}
