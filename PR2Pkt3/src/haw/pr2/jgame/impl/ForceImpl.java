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
		return fromPrototype(Factory.forceInNewton(this.value()).value() / other);
	}

	@Override
	public Force mul(double other)
	{
		return fromPrototype(Factory.forceInNewton(this.value()).value() * other);
	}


	@Override
	public Acc div(Mass mass)
	{	
		return Factory.accInMeterProSeKundeQuadrat(Factory.forceInNewton(this.value()).value() / Factory.massInKilogramm(mass.value()).value());
//		return AccImpl.valueOf(Factory.forceInNewton(this.value()).value() / Factory.massInKilogramm(mass.value()).value());
	}

	@Override
	public Mass div(Acc acc)
	{
		return Factory.massInKilogramm(Factory.forceInNewton(this.value()).value() / Factory.accInMeterProSeKundeQuadrat(acc.value()).value());
//		return MassImpl.valueOf(Factory.forceInNewton(this.value()).value() / Factory.accInMeterProSeKundeQuadrat(acc.value()).value());
	}

	@Override
	public Force mul(Speed speed) {
		return Factory.forceInNewton(Factory.forceInNewton(this.value()).value() * Factory.speedInMeterProSeKunde(speed.value()).value());
	}

	@Override
	public Force value(ForceUnit funit, Multiplier mult)
	{
		return Factory.force(value, funit, mult);
	}
}
