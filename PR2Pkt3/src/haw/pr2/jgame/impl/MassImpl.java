package haw.pr2.jgame.impl;

import haw.pr2.jgame.interfaces.Acc;
import haw.pr2.jgame.interfaces.Force;
import haw.pr2.jgame.interfaces.Mass;

public class MassImpl extends AbstractValuesImpl<Mass> implements Mass{
	  
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mass mul(double other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Force mul(Acc acc) {
		// TODO Auto-generated method stub
		return null;
	}

}
