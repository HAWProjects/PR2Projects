package haw.pr2.jgame.impl;

import haw.pr2.jgame.interfaces.Acc;
import haw.pr2.jgame.interfaces.Force;
import haw.pr2.jgame.interfaces.Length;
import haw.pr2.jgame.interfaces.Mass;
import haw.pr2.jgame.interfaces.Speed;
import haw.pr2.jgame.units.ForceUnit;
import haw.pr2.jgame.units.Multiplier;

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
