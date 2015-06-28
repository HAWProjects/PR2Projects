package haw.pr2.interfaces.aspects;

import haw.pr2.interfaces.physicValues.TimeDiff;

public interface WithPropulsion extends WithPower
{
	void moveStep(TimeDiff deltaTime);
}
