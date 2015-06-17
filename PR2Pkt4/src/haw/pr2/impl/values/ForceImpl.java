package haw.pr2.impl.values;

import haw.pr2.interfaces.physicValues.Acc;
import haw.pr2.interfaces.physicValues.Force;
import haw.pr2.interfaces.physicValues.Mass;
import haw.pr2.interfaces.physicValues.Speed;
import haw.pr2.interfaces.units.ForceUnit;
import haw.pr2.interfaces.units.Multiplier;


class ForceImpl extends AbstractValuesImpl<Force> implements Force
{

	public static Force valueOf(double inValue)
	{
		return new ForceImpl(inValue);
	}

	private ForceImpl(double value)
	{
		super(value);
	}

	@Override
	public boolean checkInstance(Object obj) {
		return obj instanceof Force;
	}
	
	@Override
	public Force fromPrototype(double value)
	{
		return valueOf(value);
	}

	@Override
	public Force div(double other)
	{
		return Factory.force(this.value() / other);
	}

	@Override
	public Force mul(double other)
	{
		return Factory.force(this.value() * other);
	}

	@Override
	public Acc div(Mass mass)
	{	
		return Factory.acc(this.value() / mass.value());
	}

	@Override
	public Mass div(Acc acc)
	{
		return Factory.mass(this.value() / acc.value());
	}

	@Override
	public Force mul(Speed speed) {
		return Factory.force(this.value() * speed.value());
	}

	@Override
	public Force value(ForceUnit funit, Multiplier mult)
	{
		return Factory.force(value, funit, mult);
	}
}
