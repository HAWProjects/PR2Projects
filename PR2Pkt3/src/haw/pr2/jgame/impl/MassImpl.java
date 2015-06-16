package haw.pr2.jgame.impl;

import haw.pr2.jgame.interfaces.Acc;
import haw.pr2.jgame.interfaces.Force;
import haw.pr2.jgame.interfaces.Mass;
import haw.pr2.jgame.units.MassUnit;
import haw.pr2.jgame.units.Multiplier;

class MassImpl extends AbstractValuesImpl<Mass> implements Mass{
	  
	public static Mass valueOf(double inValue) {
	        return new MassImpl(inValue);
	    }
	
	private MassImpl(double value) {
		super(value);
	}

		@Override
	public Mass fromPrototype(double value) {
		return valueOf(value);
	}

	@Override
	public boolean checkInstance(Object obj) {
		return obj instanceof Mass;
	}

	@Override
	public Mass div(double other) {
		return Factory.mass(this.value()/ other);
	}

	@Override
	public Mass mul(double other) {
		return Factory.mass(this.value() * other);
	}

	@Override
	public Force mul(Acc acc) {
		return Factory.force(this.value() * acc.value());
	}

	@Override
	public Mass value(MassUnit munit, Multiplier mult)
	{
		return Factory.mass(value, munit, mult);
	}

}
