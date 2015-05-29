package haw.pr2.jgame.impl;

import haw.pr2.jgame.interfaces.Acc;
import haw.pr2.jgame.interfaces.Force;
import haw.pr2.jgame.interfaces.Mass;

public class ForceImpl extends AbstractValuesImpl<Force> implements Force {

	protected ForceImpl(double value) {
		super(value);
	}

	@Override
	public Force div(double other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Force mul(double other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Force fromPrototype(double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acc div(Mass mass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mass div(Acc acc) {
		// TODO Auto-generated method stub
		return null;
	}
}
