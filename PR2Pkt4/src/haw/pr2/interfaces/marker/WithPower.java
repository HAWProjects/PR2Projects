package haw.pr2.interfaces.marker;

import haw.pr2.interfaces.Mutable;
import haw.pr2.interfaces.physicValues.Power;

public interface WithPower extends Mutable
{
	public Power power();
	public Power maxPower();
	public void setLevel(double level);
}
