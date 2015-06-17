package haw.pr2.interfaces.physicValues;

public interface Work extends AbstractValue<Work> {
	public Length div(Force force); 
	public Force div(Length length);
}
