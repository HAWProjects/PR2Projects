package haw.pr2.jgame.impl;

import haw.pr2.jgame.Factory;
import haw.pr2.jgame.interfaces.Acc;
import haw.pr2.jgame.interfaces.Force;
import haw.pr2.jgame.interfaces.Length;
import haw.pr2.jgame.interfaces.Mass;

public class AccImpl extends AbstractValuesImpl<Acc> implements Acc {

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
		return fromPrototype(Factory.accInMeterProSeKundeQuadrat(this.value).value() / other);
	}
	
	@Override
	public Acc mul(double other) {
		return fromPrototype(Factory.accInMeterProSeKundeQuadrat(this.value).value() * other);
	}

	@Override
	public Force mul(Mass mass) {
		return ForceImpl.valueOf(Factory.accInMeterProSeKundeQuadrat(this.value()).value() * Factory.massInKilogramm(mass.value()).value());
	}
}
