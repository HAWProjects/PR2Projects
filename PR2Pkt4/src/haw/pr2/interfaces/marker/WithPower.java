package haw.pr2.interfaces.marker;

import haw.pr2.interfaces.adminValue.Mutable;
import haw.pr2.interfaces.physicValues.Power;

public interface WithPower extends Mutable
{
	Power power();
	Power maxPower();
	void setLevel(double level);
}
