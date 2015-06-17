package haw.pr2.impl.values;

//import static com.google.common.base.Preconditions.checkNotNull;
import haw.pr2.interfaces.physicValues.Acc;
import haw.pr2.interfaces.physicValues.Force;
import haw.pr2.interfaces.physicValues.Length;
import haw.pr2.interfaces.physicValues.Power;
import haw.pr2.interfaces.physicValues.Speed;
import haw.pr2.interfaces.physicValues.TimeDiff;
import haw.pr2.interfaces.units.LengthUnit;
import haw.pr2.interfaces.units.Multiplier;

class SpeedImpl extends AbstractValuesImpl<Speed> implements Speed {

	public static Speed valueOf(double inValue) {
		return new SpeedImpl(inValue);
	}

	private SpeedImpl(double value) {
		super(value);
	}

	@Override
	public Speed fromPrototype(double value) {
		return valueOf(value);
	}
	
	@Override
	public boolean checkInstance(Object obj) {
		return obj instanceof Speed;
	}
	
	@Override
	public Speed div(double other) { 
//		checkNotNull(other);
//		checkNotNull(other > 0);
		return Factory.speed(this.value() / other);
	}
	@Override
	public Speed mul(double other) { return Factory.speed(this.value() * other);}
	@Override
	public Speed mul(Speed other) { return Factory.speed(this.value() * this.value());}
	@Override
	public Length mul(TimeDiff timeDiff) { return Factory.length(this.value() * timeDiff.value()); }
	@Override
	public Force dragForce(Speed maxSpeed, Power maxPower) { return Factory.force(maxSpeed.value() * maxSpeed.value()* maxSpeed.value()); }
	@Override
	public Acc curveAcc(Length length) { return Factory.acc(this.value * this.value/length.value());}

	@Override
	public Speed value(LengthUnit lunit, Multiplier mult)
	{
		return Factory.speed(value, lunit, mult);
	}
}
