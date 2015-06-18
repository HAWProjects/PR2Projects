package haw.pr2.interfaces;

import haw.pr2.interfaces.adminValue.Mutable;
import haw.pr2.interfaces.physicValues.Angle;
import haw.pr2.interfaces.physicValues.CourseAngle;

public interface WithSteering extends Mutable
{
	Angle steeringAngle();
	CourseAngle courseAngle();
	void setSteeringAngle(Angle angle);
}
