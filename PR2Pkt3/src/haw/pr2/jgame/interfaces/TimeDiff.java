package haw.pr2.jgame.interfaces;

public interface TimeDiff extends AbstractValue<TimeDiff> {
	public Length mul(Speed speed);
	public Speed mul(Acc acc);
	
}
