package haw.pr2.jgame.impl;

import static com.google.common.base.Preconditions.checkNotNull;
import haw.pr2.jgame.Factory;
import haw.pr2.jgame.interfaces.Force;
import haw.pr2.jgame.interfaces.Length;
import haw.pr2.jgame.interfaces.Work;

public class WorkImpl extends AbstractValuesImpl<Work> implements Work {
	
public static WorkImpl valueOf(double inValue){
	return new WorkImpl(inValue);
}
	
	private WorkImpl(double value) {
		super(value);
	}

	@Override
	public Work fromPrototype(double value) {
		return valueOf(value);
	}

	@Override
	public boolean checkInstance(Object obj) {
		return obj instanceof Work;
	}
	
	@Override
	public Work div(double other) {
		checkNotNull(other > 0);
		return fromPrototype(Factory.workInNewtonMeter(this.value()).value() / other);
	}

	@Override
	public Work mul(double other) {
		return fromPrototype(Factory.workInNewtonMeter(this.value()).value() * other);
	}
	@Override
	public Length div(Force force)
	{
		return Factory.lengthInMeter(this.value() / force.value());
	}

	@Override
	public Force div(Length length)
	{
		return ForceImpl.valueOf(Factory.workInNewtonMeter(this.value()).value() / length.value());
	}
	


}
