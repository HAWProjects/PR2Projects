package haw.pr2.jgame.interfaces;

public interface Speed extends AbstractValue<Speed> {
	public Length mul(TimeDiff timeDiff);
	public Force dragForce(Speed maxSpeed, Power maxPower);
	public Speed mul(Speed speed);
	public Acc curveAcc(Length length);
	
}
