package haw.pr2.jgame.interfaces;

public interface Force extends AbstractValue<Force> {
	public Acc div(Mass mass);
	public Mass div(Acc acc); 
	public Force mul(Speed speed);
}
