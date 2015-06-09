package haw.pr2.jgame.impl;

import haw.pr2.jgame.interfaces.Length;
import haw.pr2.jgame.interfaces.Speed;
import haw.pr2.jgame.interfaces.TimeDiff;

public class LengthImpl extends AbstractValuesImpl<Length> implements Length {

   public static Length valueOf(double inValue) {
        return new LengthImpl(inValue);
    }
    
	private LengthImpl(double value) {
		super(value);
	}

	@Override
	public Length fromPrototype(double value) {
		return valueOf(value);
	}

	@Override
	public boolean checkInstance(Object obj) {
		return obj instanceof Length;
	}
	
	@Override
	public Length div(double other) {
		return fromPrototype(Factory.lengthInMeter(this.value()).value() / other);
	}

	@Override
	public Length mul(double other) {
		return fromPrototype(Factory.lengthInMeter(this.value()).value() * other);
	}

	@Override
	public TimeDiff div(Speed speed) {
		
		return Factory.timeInSec(Factory.lengthInMeter(this.value()).value() / Factory.speedInMeterProSeKunde(speed.value()).value());
//		return TimeDiffImpl.valueOf(Factory.lengthInMeter(this.value()).value() / (speed.value()));
	}

	@Override
	public Speed div(TimeDiff timeDiff) {
		return	Factory.speedInMeterProSeKunde(Factory.lengthInMeter(this.value()).value()  / Factory.timeInSec(timeDiff.value()).value());
//		return SpeedImpl.valueOf(Factory.lengthInMeter(this.value()).value() / (timeDiff.value()));
	}
}
