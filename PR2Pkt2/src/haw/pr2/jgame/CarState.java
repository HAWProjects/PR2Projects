package haw.pr2.jgame;

public enum CarState
{
	DRIVINGFORWARD
	{
		@Override
		public void switchState(Car car)
		{
			if (Math.abs(car.getSteeringLevel()) > Konstants.MAXSTEERING)
			{
				car.setState(DRIVINGCURVE);
			}
			else if (car.getSpeed() < Konstants.MAXLEVEL)
			{
				car.setState(STOPPED);
			}
			else
			{
				car.setState(DRIVINGFORWARD);
			}
		}

		@Override
		public void step(double elapsedTime, Car car)
		{
			 System.out.println("STATE: '''''''''''''''''''''''''" + car.getState());
			// Dynamik
			// gaspedalstellung
			double proplevel = car.getProplevel();
			// aktuelle Leistung Auto
			double powerProp = car.getPowerPropMax() * proplevel; // Newton
																	// [kg*m/s**2]
			System.out.println("Force: ''''''''''''''''''''''''''''''''''''''''''''''''''''''''''***********" + powerProp);
			
		
			// Antriebskraft
			double forcePropMax = calculateForcePropMax(car); 

			// Bremskraft
			double forceBrakeMax = (car.getMass() * Konstants.ACCEARTH * -2) * car.getTraktion().getValue() * car.getBrakelevel();

			// Kraft
			double forcePropAbs = powerProp / car.getSpeed();
			System.out.println("Force: ''''''''''''''''''''''''''''''''''''''''''''''''''''''''''***********" + forcePropAbs);
			if (car.isASRActive())
			{
				forcePropAbs = Math.min(forcePropMax, (powerProp / car.getSpeed()));
			}
			System.out.println("Force: ''''''''''''''''''''''''''''''''''''''''''''''''''''''''''***********" + forcePropAbs);
		

			// Abs
			if (car.isABSActive())
			{
				if (forceBrakeMax > forcePropMax)
				{
					forceBrakeMax = forcePropMax;
				}
			}
			else
			{
				if (forceBrakeMax > forcePropMax)
				{
					car.setState(SLIDING);
				}
			}

			double forceProp = forcePropAbs * Math.signum(proplevel);// Newton [kg*m/s**2]

			// Widerstandskraft
			double forceDrag = car.getdragConst() * (Math.pow(car.getSpeed(), 2)) * Math.signum(-car.getSpeed()); // Newton
			// [kg*m/s**2]
			// Gesamtkraft die in dem Moment wirkt
			double force = forceProp + forceDrag + forceBrakeMax; // Newton [kg*m/s**2]

			// Kurvenradius

			// Beschleunigung
			
			double acc = force / car.getMass();
			

			// Kinematik

			// Aktuelle Geschwindigkeit nach Beschleunigung
			double carSpeed = car.getSpeed() + (acc * elapsedTime);
			System.out.println("SPEED: ******************************************************************" + carSpeed);
			double courseAngle = car.getCurrentDirection();

			if (carSpeed > -0.2 && carSpeed < 0.2 && proplevel < 0.1)
			{
				carSpeed = Konstants.ZERO;
			}

			double deltaX = (carSpeed * elapsedTime) * Math.cos(courseAngle);
			double deltaY = (carSpeed * elapsedTime) * Math.sin(courseAngle);

			if (car.getSteeringLevel() < 0.1 && car.getSteeringLevel() > -0.1)
			{
				car.setSteeringLevel(0.0);
			}
			car.setTime(car.getTime() + elapsedTime);
			car.setPosX(car.getPosX() + deltaX);
			car.setPosY(car.getPosY() + deltaY);
			car.setCurrentDirection(courseAngle);
			car.setSpeed(carSpeed);
			
		}
	},

	DRIVINGCURVE
	{
		@Override
		public void switchState(Car car)
		{
			if ((Math.abs(car.getSteeringLevel()) < Konstants.MAXSTEERING) && car.getSpeed() > 0.0)
			{
				car.setState(DRIVINGFORWARD);
			}
			else if (car.getSpeed() <= Konstants.MAXLEVEL)
			{
				car.setState(STOPPED);
			}
			else
			{
				car.setState(DRIVINGCURVE);
			}
		}

		@Override
		public void step(double elapsedTime, Car car)
		{
			 System.out.println("STATE: '''''''''''''''''''''''''" + car.getState());
			// gaspedalstellung
			double proplevel = car.getProplevel();

			// aktuelle Leistung Auto
			double powerProp = car.getPowerPropMax() * proplevel; // Newton

			// Antriebskraft
			double forcePropMax =  calculateForcePropMax(car);

			// Bremskraft
			double forceBrakeMax = (car.getMass() * Konstants.ACCEARTH * -2) * car.getTraktion().getValue() * car.getBrakelevel();

			// Kraft
			double forcePropAbs = 0; // Newton [kg*m/s**2]
			if (car.isASRActive())
			{
				forcePropAbs = Math.min(forcePropMax, (powerProp / car.getSpeed()));
			}
			else
			{
				forcePropAbs = powerProp / car.getSpeed();
			}

			// Abs
			if (car.isABSActive())
			{
				if (forceBrakeMax > forcePropMax)
				{
					forceBrakeMax = forcePropMax;
				}
			}
			else
			{
				if (Math.abs(forceBrakeMax) > forcePropMax)
				{
					System.out.println("ABS Sliding ******************************");
					car.setState(SLIDING);
				}
			}

			double forceProp = forcePropAbs * Math.signum(proplevel);// Newton
																		// [kg*m/s**2]

			// Widerstandskraft
			double forceDrag = car.getdragConst() * (Math.pow(car.getSpeed(), 2)) * Math.signum(-car.getSpeed()); // Newton
			// [kg*m/s**2]
			// Gesamtkraft die in dem Moment wirkt
			double force = forceProp + forceDrag + forceBrakeMax; // Newton [kg*m/s**2]

			// Kurvenradius
			double curveRadius = car.getCurveRadius() / car.getSteeringLevel();

			// Beschleunigung
			double acc =  force / car.getMass();;

			// Maximale Beschleunigung
			double maxAcc = Konstants.ACCEARTH * car.getTraktion().getValue(); // 1 = tractCoeff
			
			double curveAcc = (car.getSpeed() * car.getSpeed()) / Math.abs(curveRadius);
			if (Math.abs(acc) + curveAcc > maxAcc)
			{
				 car.setState(SLIDING);
			}
			// Kinematik

			// Aktuelle Geschwindigkeit nach Beschleunigung
			double carSpeed = car.getSpeed() + (acc * elapsedTime);

			double degree = car.getCurrentDirection();
			double deltaPos = carSpeed * elapsedTime;

			double deltaCourseAngle = deltaPos / curveRadius;
			
			//Bogenma� in Grad� umrechnen
//			deltaCourseAngle = (deltaCourseAngle / Math.PI) * 180;
			

			double courseAngle = (degree + deltaCourseAngle * car.getCurveRadius());

			if (carSpeed > -0.2 && carSpeed < 0.2 && proplevel < 0.1)
			{
				carSpeed = Konstants.ZERO;
			}
			System.out.println("__________________________"+courseAngle+"------------------------------------------");
			
			double deltaX = (deltaPos) * Math.cos(courseAngle);
			double deltaY = (deltaPos) * Math.sin(courseAngle);

			if (car.getSteeringLevel() < 0.1 && car.getSteeringLevel() > -0.1)
			{
				car.setSteeringLevel(0.0);
			}
			car.setTime(car.getTime() + elapsedTime);
			car.setPosX(car.getPosX() + deltaX);
			car.setPosY(car.getPosY() + deltaY);
			car.setCurrentDirection(courseAngle);
			car.setSpeed(carSpeed);
		}
	},

	STOPPED
	{
		@Override
		public void switchState(Car car)
		{
			if (car.getProplevel() > 0.1)
			{
				car.setSpeed(0.1);
				car.setState(DRIVINGFORWARD);
			}
			else
			{
				car.setSpeed(0.0);
				car.setState(STOPPED);
			}
		}

		@Override
		public void step(double elapsedTime, Car car)
		{
			car.setTime(car.getTime() + elapsedTime);
		}
	},
	SLIDING
	{
		 
		@Override
		public void switchState(Car car)
		{
			if (car.getSpeed() <= Konstants.ZERO)
			{
				car.setState(STOPPED);
			}
			else
			{
				car.setState(SLIDING);
			}
		}

		@Override
		public void step(double elapsedTime, Car car)
		{
			System.out.println("STATE: '''''''''''''''''''''''''" + car.getState());
			// Antriebskraft
			double forcePropMax =  calculateForcePropMax(car);

			// Bremskraft
			double forceBrakeMax = (car.getMass() * Konstants.ACCEARTH * -2) * car.getTraktion().getValue();

			// Kraft

			// Widerstandskraft
			double forceDrag = car.getdragConst() * (Math.pow(car.getSpeed(), 2)) * Math.signum(-car.getSpeed()); // Newton
			// [kg*m/s**2]
			// Gesamtkraft die in dem Moment wirkt
			double force = forcePropMax + forceDrag + forceBrakeMax; // Newton[kg*m/s**2]

			// Kurvenradius

			// Beschleunigung
			double acc = force / car.getMass();
			// Maximale Beschleunigung

			// Kinematik

			// Aktuelle Geschwindigkeit nach Beschleunigung
			double carSpeed = car.getSpeed() + (acc * elapsedTime);

			double degree = car.getCurrentDirection();
			double deltaPos = carSpeed * elapsedTime;

			double courseAngle = degree;

			if (carSpeed > -0.2 && carSpeed < 0.2)
			{
				carSpeed = Konstants.ZERO;
			}

			double deltaX = (deltaPos) * Math.cos(courseAngle);
			double deltaY = (deltaPos) * Math.sin(courseAngle);

			car.setSteeringLevel(0.0);
			car.setTime(car.getTime() + elapsedTime);
			car.setPosX(car.getPosX() + deltaX);
			car.setPosY(car.getPosY() + deltaY);
			car.setCurrentDirection(courseAngle);
			car.setSpeed(carSpeed);
		}
	};

	

	protected double calculateForcePropMax(Car car)
	{
		return car.getMass() * (Konstants.ACCEARTH) * car.getTraktion().getValue(); // Newton[kg*m/s**2]
	}
	
	public abstract void switchState(Car car);
	public abstract void step(double elapsedTime, Car car);
}
