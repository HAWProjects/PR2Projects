package haw.pr2.impl.values;

//import static com.google.common.base.Preconditions.checkNotNull;
import haw.pr2.interfaces.physicValues.Force;
import haw.pr2.interfaces.physicValues.Length;
import haw.pr2.interfaces.physicValues.Work;

class WorkImpl extends AbstractValuesImpl<Work> implements Work {
	
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
//		checkNotNull(other > 0);
		return Factory.work(this.value() / other);
	}

	@Override
	public Work mul(double other) {
		return Factory.work(this.value() * other);
	}
	@Override
	public Length div(Force force)
	{
		return Factory.length(this.value() / force.value());
	}

	@Override
	public Force div(Length length)
	{
		return Factory.force(this.value() / length.value());
	}
}
