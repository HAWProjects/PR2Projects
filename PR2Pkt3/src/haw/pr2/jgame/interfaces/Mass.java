package haw.pr2.jgame.interfaces;

public interface Mass extends AbstractValue<Mass> {
	public Force mul(Acc acc);
}
