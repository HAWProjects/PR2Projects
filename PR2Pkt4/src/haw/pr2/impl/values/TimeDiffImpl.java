package haw.pr2.impl.values;

import haw.pr2.interfaces.physicValues.Acc;
import haw.pr2.interfaces.physicValues.Length;
import haw.pr2.interfaces.physicValues.Speed;
import haw.pr2.interfaces.physicValues.TimeDiff;

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
		return Factory.time(this.value() / other);
	}


	@Override
	public TimeDiff mul(double other) {
		return Factory.time(this.value() * other);
	}


	@Override
	public Length mul(Speed speed) {
		return Factory.length(this.value() * speed.value());
	}

	@Override
	public Speed mul(Acc acc) {
		return Factory.speed(this.value() * acc.value());
	}

}
