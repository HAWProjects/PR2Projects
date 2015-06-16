package haw.pr2.jgame.impl;

import haw.pr2.jgame.interfaces.Force;
import haw.pr2.jgame.interfaces.Power;
import haw.pr2.jgame.interfaces.Speed;
import haw.pr2.jgame.units.Multiplier;
import haw.pr2.jgame.units.PowerUnit;

class PowerImpl extends AbstractValuesImpl<Power> implements Power {

	public static Power valueOf(double inValue){
		return new PowerImpl(inValue);
	}
	private PowerImpl(double value) {
		super(value);
	}

	@Override
	public Power fromPrototype(double value) {
		return valueOf(value);
	}

	@Override
	public boolean checkInstance(Object obj) {
		return obj instanceof Power;
	}
	
	@Override
	public Power div(double other)
	{
		return Factory.power(this.value() / other);
	}
	
	@Override
	public Power mul(double other)
	{
		return Factory.powerInWatt(this.value() * other);
	}
	@Override
	public Speed div(Force force)
	{
		return Factory.speed(this.value() / force.value());
	}
	@Override
	public Force div(Speed speed) {
		return Factory.force(this.value() / speed.value());
	}
	@Override
	public Power value(PowerUnit punit, Multiplier mult)
	{
		return Factory.power(value, punit, mult);
	}
	

}
