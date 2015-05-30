package haw.pr2.jgame.interfaces;

public interface Work extends AbstractValue<Work> {
	public Length div(Force force); 
	public Force div(Length length);
}
