package haw.pr2.jgame.impl;

import haw.pr2.jgame.Factory;
import haw.pr2.jgame.interfaces.Force;
import haw.pr2.jgame.interfaces.Power;
import haw.pr2.jgame.interfaces.Speed;

public class PowerImpl extends AbstractValuesImpl<Power> implements Power {

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
		return fromPrototype(Factory.powerInWatt(this.value).value() / other);
	}
	
	@Override
	public Power mul(double other)
	{
		return fromPrototype(Factory.powerInWatt(this.value).value() * other);
	}
	@Override
	public Speed div(Force force)
	{
		return SpeedImpl.valueOf(Factory.powerInWatt(this.value).value() / force.value());
	}

}
