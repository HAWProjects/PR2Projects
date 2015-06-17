package haw.pr2.impl.values;

import haw.pr2.interfaces.physicValues.Acc;
import haw.pr2.interfaces.physicValues.Force;
import haw.pr2.interfaces.physicValues.Mass;
import haw.pr2.interfaces.physicValues.Speed;
import haw.pr2.interfaces.physicValues.TimeDiff;
import haw.pr2.interfaces.units.AccUnit;
import haw.pr2.interfaces.units.Multiplier;


class AccImpl extends AbstractValuesImpl<Acc> implements Acc {

	private AccImpl(double value) {
		super(value);
	}
	
	public static Acc valueOf(double inValue) {
		return new AccImpl(inValue);
	}
	
	@Override
	public boolean checkInstance(Object obj) {
		return obj instanceof Acc;
	}

	@Override
	public Acc fromPrototype(double value) {
		return valueOf(value);
	}

	
	@Override
	public Acc div(double other) {
		return Factory.acc(this.value() / other);
	}
	
	@Override
	public Acc mul(double other) {
		return Factory.acc(this.value() * other);
	}

	@Override
	public Force mul(Mass mass) {
		return Factory.force(this.value() * mass.value());
	}

	@Override
	public Speed mul(TimeDiff timeDiff) {
		return Factory.speed(this.value() * timeDiff.value());
	}

	@Override
	public Acc value(AccUnit aunit, Multiplier mult)
	{
		return Factory.acc(this.value(), aunit, mult);
	}
}
